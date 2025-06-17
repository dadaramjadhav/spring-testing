package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceIntegrationTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    private Users user;

    @BeforeEach
    void setup() {
        user = new Users(101, "dm101");
        userRepo.save(user);
    }

    @Test
    public void test1() {
        Users userFromDb = userService.findUserById(101);
        assertNotNull(userFromDb);
        assertEquals(101, userFromDb.getId());
        assertEquals("dm101", userFromDb.getName());
    }
}
