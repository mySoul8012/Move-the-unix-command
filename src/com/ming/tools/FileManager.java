package com.ming.tools;

import java.io.IOException;
import java.nio.file.*;
import java.rmi.server.ExportException;
import java.util.*;

// 文件操作类,用于进行文件操作
public class FileManager {

    // ls命令
    public static String ls(String stringPath){
        String result = "";
        // 获得当前目录对象
        Path path = Paths.get(stringPath);
        // 获得目录对象流
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)){
            // 对该流进行迭代
            for(Path file:ds){
                // 获得文件名称
                result += file.getFileName() + "\n";
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return result;
    }

    // ls -l命令 输出目录树
    public static String ls_L(String stringPath) {
        Path path = Paths.get(stringPath);
        List<Path> result = new LinkedList<Path>();
        try {
            Files.walkFileTree(path, new FindJavaVisitor(path, result));
        } catch (IOException e) {
            System.out.println(e);
        }
        return result.toString();
    }
}
