package com.example.container;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.UserRepository;
import com.example.Users;

@Testcontainers
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DaoTestExample {

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
    private UserRepository userRepo;

    @Test
    @Order(1)
    @Rollback(false)
    public void testSaveUser() {
        Users addedUser = userRepo.save(new Users(101, "dm101"));
        assertEquals(101, addedUser.getId());
        assertEquals("dm101", addedUser.getName());
    }

    @Test
    @Order(2)
    public void testFindByUserId() {
        Optional<Users> user = userRepo.findById(101);
        assertEquals(101, user.get().getId());
        assertEquals("dm101", user.get().getName());
    }
}
