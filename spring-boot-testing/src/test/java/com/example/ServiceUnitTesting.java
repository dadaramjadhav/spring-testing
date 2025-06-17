package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceUnitTesting {

    @Mock
    private UserRepository userRepo;

    @InjectMocks
    private UserService userService;

    @Test
    public void test1() {
        Users mockUser = new Users(1, "dm");
        when(userRepo.findById(1)).thenReturn(Optional.of(mockUser));

        Users result = userService.findUserById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("dm", result.getName());
    }
}
