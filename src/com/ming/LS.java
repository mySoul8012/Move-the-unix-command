package com.ming;

import com.ming.tools.*;

public class LS extends AbstractLS {
    // 参数为空
    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    // 处理最简单的ls
    @Override
    protected String echo(CommandVO vo) {
        System.out.println('2');
        return FileManager.ls(com.ming.tools.ArrayListToString.arrayToString(vo.getDataList()));
    }
}
