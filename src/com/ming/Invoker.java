package com.ming;

// 用于命令分发
public class Invoker {
    public String exec(String _commandStr){
        // 返回值
        String result = "";
        // 解析命令
        CommandVO vo = new CommandVO(_commandStr);
        // 判断支持
        if(CommandEnum.getNames().contains(vo.getCommandName())) {
            // 获得命令的类的名称
            String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
            Command command;
            try {
                // 装载进入内存
                command = (Command) Class.forName(className).newInstance();
                // 执行
                result = command.execute(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            result = "命令无法解析";
        }
        return result;
    }
}
