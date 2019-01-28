package com.ming.tools;

import java.util.ArrayList;
import java.util.List;

// 根据父类获得子类
public class ClassUtils {
    public static List getSonClass(Class fatherClass){
        // 定义返回值
        List returnClassList = new ArrayList();
        // 包名称
        String packageName = fatherClass.getPackage().getName();
        // 获得包中的类
        List packClasses = getClasses(packageName);
        // 判断子类
        for(Class c:packClasses){
            if(fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)){
                returnClassList.add(c);
            }
        }
        return returnClassList;
    }

    //从包中查找所有类
    private static List getClasses(String packageName){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    }
}
