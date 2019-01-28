package com.ming.tools;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

// 下方的代码不太懂。。无奈摊手
// 核心思想是找到该包下的所有类，把类全部装载进入内存，对象文件夹中的类，递归读取，然后在判断子类
// 由于递归读取防止意外，使用断言
// 核心思想，是先获得包名，然后再获得该线程下的类加载器，在获得该线程下的类加载器下的
// 所有的资源符，即URL，然后再把URL转换成为文件描述符，最后再把文件描述符装载进入内存
public class ClassUtils {
    //根据父类查找到所有的子类，当子类和父类在同一个包下的时候
    // 输入Class类型的fatherClass，即需要寻找的fatherClass
    public static List getSonClass(Class fatherClass){
        //定义一个用于保存变量的返回值
        List returnClassList = new ArrayList();
        //或得需要获取子类的包名
        String packageName = fatherClass.getPackage().getName();
        //获得包中的所有类，返回的是一个数组
        List  packClasses = getClasses(packageName);
        //进行判断是否为子类
        for(Object c:packClasses){
            // 由于进入List后类型变为Object类型，需要进行强制类型转换
            // isAssignableForm用于判断接口是否相同
            // 后面的equals用于排除同一个类
            if(fatherClass.isAssignableFrom((Class)c) && !fatherClass.equals(c)){
                // 结果保存进入数组
                returnClassList.add(c);
            }
        }
        return returnClassList;
    }
    // 下方的两个方法都是用于从包中找所有类的
    //从一个包中查找出所有的类，在jar包中不能查找
    private static List getClasses(String packageName) {
        // 因为类加载机制为双拼委派模型，因为java中，每一个线程都有其自己的工作内存，在运行的时候
        // 都为主内存副本的拷贝，所以需要使用Thread.currentThread获取当前线程
        // getContextClassLoader获取类的上下文，即，类加载器
        // classLoader保存是当前线程所有类的加载器
        // 当前是在src目录下
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        // 获得包在本地计算机上的实际路径，由于获得包的名称为.所以需要进行替换
        // 当前获得的是在src目录下的com/ming，获取的是包的路径
        String path = packageName.replace('.', '/');
        // 定义集合，用于保存类的加载器的路径
        Enumeration resources = null;
        try {
            // 获得类加载器的下的path所有资源的描述符，保存进入集合中。
            // 类加载器的路径为src
            // path目录为com/ming
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 由于获取的是URL类型，需要进行转换为文件描述符，下方把资源描述符，转换成为文件描述符
        List dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = (URL)resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList classes = new ArrayList();
        // 再次把文件描述符转换成为class对象
        for (Object directory : dirs) {
            classes.addAll(findClasses((File)directory, packageName));
        }
        return classes;
    }
    // 用于把文件描述符，转换成为class对象，装载进入内存，是包中的所有的class文件
    // 下方看的不太懂，无奈，摊手
    private static List findClasses(File directory, String packageName) {
        List classes = new ArrayList();
        // 为空直接返回
        if (!directory.exists()) {
            return classes;
        }
        // 返回抽象路径名表示的目录中的文件
        File[] files = directory.listFiles();
        for (File file : files) {
            // 用于测试是否为目录
            if (file.isDirectory()) {
                // 断言
                assert !file.getName().contains(".");
                // 再次递归寻找文件，用于目录中的目录
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            // 如果是class文件
            } else if (file.getName().endsWith(".class")) {
                try {
                    // 把文件装载进入内存中
                    classes.add(Class.forName(packageName + '.' + file.getName() .substring(0, file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }
}