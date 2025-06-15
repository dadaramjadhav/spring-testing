package com.example.lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArithmeticTest {

    @Test
    @Order(4)
    @DisplayName("Addition")
    @Tag("unit")
    public void testAdd() {
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(5, arithmetic.add(2, 3));
    }

    @Test
    @Order(3)
    @DisplayName("Subtraction")
    @Tag("unit")
    // @RepeatedTest(3)
    public void testSub() {
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(1, arithmetic.sub(2, 1));
    }

    @Test
    @Order(2)
    @DisplayName("Multiplication")
    // @Timeout(4)
    @Tag("integration")
    public void testMul() {
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(6, arithmetic.mul(2, 3));
    }

    @Test
    @Order(1)
    @DisplayName("Division")
    @Tag("integration")
    // @Disabled
    public void testDiv() {
        Arithmetic arithmetic = new Arithmetic();
        assertThrows(ArithmeticException.class, () -> arithmetic.div(4, 0)  );
        // assertEquals(2, arithmetic.div(4, 2));
    }

    // @Test
    // @Order(5)
    // @EnabledOnOs(OS.WINDOWS)
    // @DisplayName("Engine")
    // void printEngine() {
    //     System.out.println("Running on JUnit 5");
    // }
}
