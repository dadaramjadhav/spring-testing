package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpyExampleTest {
    @Mock
    SpyExample spyExample;

    @Test
    public void testSpyMethod(){
        when(spyExample.add(10,10)).thenReturn(20);
        
        assertEquals(20, spyExample.add(10,10));
        verify(spyExample).add(10,10);
    }

}
