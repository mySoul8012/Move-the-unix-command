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
        // 建立链表
        List commandNameList = new ArrayList();
        for(Class c:classes){

        }
    }
}
