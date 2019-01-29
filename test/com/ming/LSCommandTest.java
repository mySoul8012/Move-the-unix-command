package com.ming;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LSCommandTest {

    @Test
    void buildChain() throws ClassNotFoundException{
        // 获取Class
        Class LSCommand = Class.forName("com.ming.AbstractLS");
        LSCommand lsCommand = new LSCommand();
        List<? extends CommandName> list;
        list = lsCommand.buildChain(LSCommand);
        System.out.println(list);
    }

    @Test
    void execute() {
        CommandVO commandVO = new CommandVO("ls -l /home/ming");
        LSCommand lsCommand = new LSCommand();
        System.out.println(lsCommand.execute(commandVO));
    }
}