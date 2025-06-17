package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

//option 1: integration testing using testresttemplate 
//loads entire application context
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class ControllerIntegrationTest {
//     @Autowired
//     TestRestTemplate restTemplate;

//     @Autowired
//     UserRepository userRepository;

//     @BeforeEach
//     void setup() {
//         userRepository.save(new Users(1, "dm"));
//     }

//     @Test
//     public void getUserTest() {
//         ResponseEntity<Users> resp = restTemplate.getForEntity("/users/1", Users.class);
//         assertEquals(resp.getStatusCodeValue(), 200);
//         assertEquals(resp.getBody().getId(), 1);
//     }
// }


//Option 2: Use MockMvc with @SpringBootTest (without slicing)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @AutoConfigureMockMvc
// public class ControllerIntegrationTest {
//     @Autowired
//     MockMvc mockMvc;

//     @Autowired
//     UserRepository userRepository;

//     int id = 1;

//     @BeforeEach
//     void setup() {
//         userRepository.save(new Users(id, "dm"));
//     }

//     @Test
//     public void getUserTest() throws Exception {
//         mockMvc.perform(get("/users/" + id))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.id").value(id))
//                 .andExpect(jsonPath("$.name").value("dm"));
//     }
// }

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ControllerIntegrationTest {

    
    @Autowired
    UserRepository userRepository;

    int id = 1;

    @BeforeEach
    void setup() {
        userRepository.save(new Users(id, "dm"));
    }

    @Test
    public void getUserTest() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users> response = restTemplate.getForEntity("http://localhost:8080/users/"+ id,   Users.class);
        assertEquals(1, response.getBody().getId());
        assertEquals("dm", response.getBody().getName());
        
    }
}