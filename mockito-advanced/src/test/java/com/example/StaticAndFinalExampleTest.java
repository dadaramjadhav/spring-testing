package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class StaticAndFinalExampleTest {
    @Test
    public void testStaticMethod() {
        // Mockito.mockStatic(StaticAndFinalExample.class);
        // Mockito.when(StaticAndFinalExample.getOrgName()).thenReturn("Accenture");

        // assertEquals("Accenture", StaticAndFinalExample.getOrgName());

        try (MockedStatic<StaticAndFinalExample> mocked = mockStatic(StaticAndFinalExample.class)) {
            mocked.when(StaticAndFinalExample::getOrgName).thenReturn("Accenture");
            assertEquals("Accenture", StaticAndFinalExample.getOrgName());
        }
    }

    @Test
    public void testFinalMethod() {
        StaticAndFinalExample instance = Mockito.mock(StaticAndFinalExample.class);
        Mockito.when(instance.getPi()).thenReturn("3.14");
        assertEquals("3.14", instance.getPi());
    }

}
