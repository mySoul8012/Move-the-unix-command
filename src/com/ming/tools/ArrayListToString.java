package com.ming.tools;

import java.util.ArrayList;

// ArrayList转字符串
public class ArrayListToString {
    public static String arrayToString(ArrayList<String> arrayString){
        String result = "";
        if(arrayString != null && arrayString.size() > 0){
            // 遍历，拼接
            for(String item:arrayString){
                result += item;
            }
        }
        return result;
    }
}
