package com.ming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LSTest {

    @Test
    void echo() {
        AbstractLS ls = new LS();
        String lsString = "ls -a /home/ming";
        CommandVO commandVO = new CommandVO(lsString);
        System.out.println(ls.echo(commandVO));
    }
}