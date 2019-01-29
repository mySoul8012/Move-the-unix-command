package com.ming;

import java.util.ArrayList;
import java.util.List;

// 命令配置,使用枚举
public enum CommandEnum {
    // 一个项对应一个value
    ls("com.ming.LSCommand");
    private String value = "";
    private CommandEnum(String value) {
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    // 返回枚举的对象
    public static List getNames(){
        // 获取values
        CommandEnum[] commandEnums = CommandEnum.values();
        List names = new ArrayList();
        for(CommandEnum c:commandEnums){
            names.add(c.name());
        }
        return names;
    }
}
