package com.rims.drew.parsons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.User;
/**
 * simple Jpa repository for the user table
 * includes method to query DB to find by username
 * @author Drew
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
	User findByUsername(String username);

}
