package com.ming.tools;

import com.ming.AbstractLS;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ClassUtilsTest {

    @Test
    void getSonClass() {
        Class AbstractLS = com.ming.AbstractLS.class;
        System.out.println(ClassUtils.getSonClass(AbstractLS).toString());
    }
}