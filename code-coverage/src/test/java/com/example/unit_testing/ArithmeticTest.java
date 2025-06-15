package com.example.unit_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArithmeticTest {
    
    @Test
    public void testAdd(){
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(5, arithmetic.add(2, 3));
    }
    @Test
    public void testSub(){
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(1, arithmetic.sub(2, 1));
    }
    @Test
    public void testMul(){
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(6, arithmetic.mul(2, 3));
    }
    @Test
    public void testDiv(){
        Arithmetic arithmetic = new Arithmetic();
        assertEquals(2, arithmetic.div(4, 2));
    }
}
