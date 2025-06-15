package com.example.lifecycle;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest1 {
    // @Test
    @ParameterizedTest
    @ValueSource(ints = { 2})
    @Tag("integration")
    public void testIsEven(int num) {
        Arithmetic arithmetic = new Arithmetic();
        assertTrue(arithmetic.isEven(num));
    }

}
