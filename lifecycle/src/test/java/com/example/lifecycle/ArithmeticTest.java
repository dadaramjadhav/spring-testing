package com.example.lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArithmeticTest {

    @Test
    @Order(4)
    @DisplayName("Addition")
    public void testAdd() {
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(5, arithmetic.add(2, 3));
    }

    @Test
    @Order(3)
    @DisplayName("Subtraction")
    // @RepeatedTest(3)
    public void testSub() {
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(1, arithmetic.sub(2, 1));
    }

    @Test
    @Order(2)
    @DisplayName("Multiplication")
    @Timeout(4)
    public void testMul() {
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(6, arithmetic.mul(2, 3));
    }

    @Test
    @Order(1)
    @DisplayName("Division")
    public void testDiv() {
        Arithmetic arithmetic = new Arithmetic();
        assertThrows(ArithmeticException.class, () -> arithmetic.div(4, 0)  );
        // assertEquals(2, arithmetic.div(4, 2));
    }

    @Test
    @Order(5)
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Engin")
    void printEngine() {
        System.out.println("Running on JUnit 5");
    }
}
