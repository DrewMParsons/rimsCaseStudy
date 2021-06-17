package com.rims.drew.parsons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class UserRepoTest
{

	@Autowired
	UserRepository userRepo;
	/*
	 * @Test to check if FindByUsername works in UserRepository
	 * success if test returns a user for the given value that is currently in the database
	 */
	@Test
	public void testFindByUsername() {
		assertNotNull(userRepo.findByUsername("drewparso2"));
		
	}
	
	/*
	 * @Test to check if FindByUsername works in UserRepository
	 * success if test returns null for the given value that is currently NOT in the database
	 */
	@Test
	public void testFindByUsernameIsNull() {
		assertNull(userRepo.findByUsername("drewparso"));
		
	}
}
