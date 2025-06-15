package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
// @ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock       //use @Mock instead of @MockBean
    private UserRepository userRepository;

    @InjectMocks            
    private UserService userService;

     @Captor
    ArgumentCaptor<User> userCaptor;

    @Captor
    ArgumentCaptor<Integer> idCaptor;

     
    // dynamic behaviour
    @Test
    public void testGetUser1() {
        when(userRepository.findById(anyInt()))
                .thenAnswer(invocation -> new User(invocation.getArgument(0), "dynamic user"));
        assertEquals("dynamic user", userService.getUserName(4545));
    }

    // exception, stubbing void method
    @Test
    public void testException() {
        doThrow(new RuntimeException("delete error")).when(userRepository).delete(99);
        assertThrows(RuntimeException.class, () -> userService.deleteUser(99));
    }

    // stubbing void method
    @Test
    public void testVoidStubMethod() {
        User user = new User(102, "dm102");
        doNothing().when(userRepository).save(user);
        userService.saveUser(user);
        verify(userRepository).save(new User(102, "dm102"));
    }

    @Test
    public void testVoidMethodUsingArgumentCaptor() {
        //doNothing().when(userRepository).save(new User(102, "dm103"));
        userService.saveUser(new User(102, "dm102"));
        verify(userRepository).save(userCaptor.capture());
        assertEquals("dm102", userCaptor.getValue().getName());
        assertEquals(102, userCaptor.getValue().getId());
    }

    @Test
    public void testArgumentCaptor(){
        userService.deleteUser(102);
        verify(userRepository).delete(idCaptor.capture());
        assertEquals(102, idCaptor.getValue().intValue());
    }

    @Test
    public void testUpdateMethod(){
        doNothing().when(userRepository).updateUser(102);
        userService.modifyUser(102);
        verify(userRepository).updateUser(102);
    }

    @Test
    public void testGetUser(){
        User user = new User(102, "dm102");
        when(userRepository.findById(102)).thenReturn(user);
        String name = userService.getUserName(102);
        verify(userRepository).findById(102);
        //assertEquals("dm102", name);
    }

    @Test
    public void testMimicDelay(){
        doNothing().when(userRepository).mimicDelay(10);
        userService.callMimicDelay();
        verify(userRepository, timeout(2000)).mimicDelay(10);
    }

    @Test
    public void orderVerificationTest(){
        userRepository.findById(101);
        userRepository.delete(101);
        InOrder inOrder = inOrder(userRepository);
        inOrder.verify(userRepository).findById(101);
        inOrder.verify(userRepository).delete(101);
    }

    //bdd style
    @Test
    public void bddStyleTest(){
        given(userRepository.findById(101)).willReturn(new User(101, "dm101"));
        String name = userService.getUserName(101);
        then(userRepository).should().findById(101);
        assertEquals("dm101", name);
    }
}
