package com.ming;

import com.ming.tools.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    public abstract String execute(CommandVO commandVO);
    // 建立链表
    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass){
        // 获得子类
        List classes = ClassUtils.getSonClass(abstractClass);
        // 建立链表关系
        List commandNameList = new ArrayList();
        for(Object c:classes){
            CommandName commandName = null;
            try{
                // 实例
                commandName = (CommandName) Class.forName( ((Class) c).getName()).newInstance();
            }catch(Exception e){
                e.printStackTrace();
            }
            // 链表建立
            if(commandNameList.size() > 0){
                // 获取到上一个链表，链表建立
                ((CommandName)commandNameList.get(commandNameList.size()-1)).setNext(commandName);
            }
            commandNameList.add(commandName);
        }

        return commandNameList;
    }
}
