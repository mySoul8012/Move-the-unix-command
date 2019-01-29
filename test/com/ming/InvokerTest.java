package com.ming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvokerTest {

    @Test
    void exec() {
        Invoker invoker = new Invoker();
        invoker.exec("ls /home/ming");
    }
}