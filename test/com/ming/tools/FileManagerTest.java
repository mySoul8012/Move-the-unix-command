package com.ming.tools;

import junit.framework.TestCase;

public class FileManagerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testLs() {
        System.out.println(FileManager.ls("/home/ming/"));
    }
}