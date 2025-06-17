package com.example;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// option 1 : pure mockito
// @ExtendWith(MockitoExtension.class)
// public class ControllerUnitTesting {
// @InjectMocks
// private UserController userController;

// @Mock
// private UserService userService;

// @Test
// public void getUser() {
// when(userService.findUserById(2)).thenReturn(new Users(2, "dm"));
// ResponseEntity<Users> response = userController.getUserById(2);
// assertEquals(HttpStatus.OK, response.getStatusCode());
// assertEquals("dm", response.getBody().getName());

// }
// }

// option 2: with @MockBean and WebMvcTest
// @WebMvcTest(UserController.class)
// public class ControllerUnitTesting {

// @Autowired
// private MockMvc mockMvc;

// @MockBean
// private UserService userService;
// int id = 2;

// @Test
// public void getUser() throws Exception {
// when(userService.findUserById(id)).thenReturn(new Users(id, "dm"));
// mockMvc
// .perform(get("/users/" + id))
// .andExpect(status().isOk())
// .andExpect(jsonPath("$.id").value(2))
// .andExpect(jsonPath("$.name").value("dm"));
// }
// }

// option 3: with @Mock and webmvctest
