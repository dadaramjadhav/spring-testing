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

// @Testcontainers          //not needed, possible to configure using below properties
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url=jdbc:tc:mysql:8.0.26:///testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop" // <-- important
})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DaoTestMinimalTestContainer {

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
