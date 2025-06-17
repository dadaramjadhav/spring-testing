package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class DaoTest {
	@Autowired
	TestEntityManager em;
	@Autowired
	UserRepository ur;
	
	@Test
	public void test1(){
		int id = 5;
		Users user = new Users(id, "dm");
		em.persist(user);
		Optional<Users> u 	= ur.findById(id);
		assertTrue(u.isPresent());
		assertTrue(u.get().getName().equals("dm"));
	}

}
