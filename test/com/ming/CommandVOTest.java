package com.ming;

import junit.framework.TestCase;

public class CommandVOTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        String ls = "ls";
        CommandVO commandVO = new CommandVO(ls);
    }

    public void tearDown() throws Exception {
    }

    public void testGetCommandName() {
        String ls = "ls -a /home/ming";
        CommandVO commandVO = new CommandVO(ls);
        System.out.println(commandVO.getCommandName());
    }
}