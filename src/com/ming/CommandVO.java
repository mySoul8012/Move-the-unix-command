package com.ming;

import java.util.ArrayList;
import java.util.HashSet;

// 命令对象
public class CommandVO {
    // 参数名,参数选项的分隔
    public final static String DIVIDE_FLAG = " ";
    // 定义参数前符号
    public final static String PREFIX = "-";
    // 命令名称
    private String commandName = "";
    // 参数列表
    private ArrayList paramList = new ArrayList();
    // 操作数列表
    private ArrayList dataList = new ArrayList();
    // 传入命令
    public CommandVO(String commandName){
        // 判空
        if(commandName != null && commandName.length() != 0){
            // 拆分,拆分成为2~3个长度的数组
            String[] compleStx = commandName.split(CommandVO.DIVIDE_FLAG);
            // 获取执行符号
            this.commandName = compleStx[0];
            // 参数放入List中
            for(int i = 1; i < compleStx.length; i++){
                String str = compleStx[i];
                // 如果有前缀符号，则为参数
                if(str.indexOf(CommandVO.PREFIX) == 0){
                    this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
                }else{
                    // 否则为操作数
                    this.dataList.add(str.trim());
                }
            }
        }else{
            // 传递命令错误
            System.out.println("参数错误");
        }
    }
    // 命令名
    public String getCommandName(){
        return this.commandName;
    }
    // 参数
    public ArrayList getParamList(){
        // 处理空参数
        if(this.paramList.size() == 0){
            this.paramList.add("");
        }

        // 去重
        return new ArrayList(new HashSet(this.paramList));
    }

    // 获得操作数
    public ArrayList getDataList(){
        return this.dataList;
    }
}
