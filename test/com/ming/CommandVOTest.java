package com.ming;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandVOTest {

    @Test
    void getCommandName() {
=======
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
>>>>>>> 2172604312d4a761ff6a7593486f3a1dc81b570b
        String ls = "ls -a /home/ming";
        CommandVO commandVO = new CommandVO(ls);
        System.out.println(commandVO.getCommandName());
    }

<<<<<<< HEAD
    @Test
    void getParamList() {
=======
    public void testGetParamList() {
>>>>>>> 2172604312d4a761ff6a7593486f3a1dc81b570b
        String ls = "ls -a /home/ming";
        CommandVO commandVO = new CommandVO(ls);
        System.out.println(commandVO.getParamList().toString());
    }

<<<<<<< HEAD
    @Test
    void getDataList() {
=======
    public void testGetDataList() {
>>>>>>> 2172604312d4a761ff6a7593486f3a1dc81b570b
        String ls = "ls -a /home/ming";
        CommandVO commandVO = new CommandVO(ls);
        System.out.println(commandVO.getDataList().toString());
    }
}