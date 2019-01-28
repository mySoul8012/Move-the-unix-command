package com.ming.tools;

<<<<<<< HEAD
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ls() {
        System.out.println(FileManager.ls("/home/ming/"));
    }

    @Test
    void ls_L() {
        System.out.println(FileManager.ls_L("/home/ming/"));
    }
=======
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
>>>>>>> 2172604312d4a761ff6a7593486f3a1dc81b570b
}