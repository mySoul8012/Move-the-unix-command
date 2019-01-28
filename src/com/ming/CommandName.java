package com.ming;

public abstract class CommandName {
    // 下一个节点
    private CommandName nextOperator;

    // 处理内容
    public final String handMessage(CommandVO _commandVo) {
        // 保存处理
        String result = "";
        // 进行判断是否自己处理
        // 当参数为空的时候，或者参数匹配到ArrayList中一项的时候，确认匹配
        if (_commandVo.getParamList().size() == 0 || _commandVo.getParamList().contains(this.getOperateParam())){
            result = this.echo(_commandVo);
        }else{
            if (this.nextOperator != null) {
                // 继续调用下一个节点
                result = this.nextOperator.handMessage(_commandVo);
            } else {
                result = "命令无法执行";
            }
        }
        return result;
    }
    // set / get方法
    public void setNext(CommandName _commaneName){
        this.nextOperator = _commaneName;
    }
    // 进行参数处理
    protected abstract String getOperateParam();
    // 处理任务
    protected abstract String echo(CommandVO vo);
}
