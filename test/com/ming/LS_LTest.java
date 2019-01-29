package com.ming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LS_LTest {

    @Test
    void echo() {
        AbstractLS ls = new LS_L();
        String lsString = "ls -l /home/ming";
        CommandVO commandVO = new CommandVO(lsString);
        System.out.println(ls.handMessage(commandVO));
    }
}