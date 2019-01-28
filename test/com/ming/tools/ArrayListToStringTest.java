package com.ming.tools;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListToStringTest {

    @Test
    void arrayToString() {
=======
import junit.framework.TestCase;

import java.util.ArrayList;

public class ArrayListToStringTest extends TestCase {

    public void testArrayToString() {
>>>>>>> 2172604312d4a761ff6a7593486f3a1dc81b570b
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 0; i < 10; i++){
            arrayList.add((int)System.currentTimeMillis() + "");
        }
        System.out.println(ArrayListToString.arrayToString(arrayList));
    }
<<<<<<< HEAD
=======

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

>>>>>>> 2172604312d4a761ff6a7593486f3a1dc81b570b
}