package com.ming;

import com.ming.tools.FileManager;

public class LS_L extends AbstractLS {
    //
    @Override
    protected String getOperateParam() {
        return super.L_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_L(com.ming.tools.ArrayListToString.arrayToString(vo.getDataList()));
    }
}
