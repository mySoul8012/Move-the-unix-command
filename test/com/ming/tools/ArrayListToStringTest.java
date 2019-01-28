package com.ming.tools;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ArrayListToStringTest extends TestCase {

    public void testArrayToString() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 0; i < 10; i++){
            arrayList.add((int)System.currentTimeMillis() + "");
        }
        System.out.println(ArrayListToString.arrayToString(arrayList));
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }
}