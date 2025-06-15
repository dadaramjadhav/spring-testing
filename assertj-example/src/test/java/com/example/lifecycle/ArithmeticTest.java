package com.example.lifecycle;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
 
public class ArithmeticTest {

    @Test
    public void testAdd() {
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.add(2, 3);
        assertThat(result).isEqualTo(5);
    }

}
