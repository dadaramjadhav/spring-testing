package com.example.container;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.example.UserService;
import com.example.Users;

@SpringBootTest
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceIntegrationTesting {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test")
            .withExposedPorts(3306);

    @DynamicPropertySource
    static void setProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> "jdbc:mysql://localhost:" + mysql.getMappedPort(3306) + "/testdb");
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");

    }

    @Autowired
    private UserService userService;

    @Test
    @Order(1)
    void testCreateUser() {
        Users user = userService.saveUser(new Users(101, "dm101"));
        assertEquals(101, user.getId());
        assertEquals("dm101", user.getName());
    }

    @Test
    @Order(2)
    public void testFindUserById() {
        Users user = userService.findUserById(101);
        System.out.println("user is : " + user);
        assertEquals("dm101", user.getName());
    }
}
