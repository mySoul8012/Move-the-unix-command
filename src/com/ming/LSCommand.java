package com.ming;

// 具体的LS命令,用于获得要遍历的首节点
public class LSCommand extends Command{
    public String execute(CommandVO vo){
        // 首节点
        CommandName firstNode = super.buildChain(AbstractLS.class).get(0);
        return firstNode.handMessage(vo);
    }
}
