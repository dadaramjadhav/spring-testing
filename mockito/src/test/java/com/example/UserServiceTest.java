package com.example;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    //mockito style
    @Test
    public void testGetUserName() {
        User mockUser = new User(101, "dm101", "dm@gmail.com");
        when(userRepository.findById(101)).thenReturn(mockUser);
        String result = userService.getUserName(101);

        // assertEquals("dm101", userService.getUserName(101));
        verify(userRepository).findById(101);
    }

    //BDD style
    // @Test
    // public void testGetUserName(){
    //     User mockUser  = new User(101, "dm101", "dm@gmail.com");
    //     given(userRepository.findById(101)).willReturn(mockUser);
    //     assertEquals("dm101", userService.getUserName(101));
    // }

}
