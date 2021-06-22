package com.rims.drew.parsons.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.repository.RoleRepository;
import com.rims.drew.parsons.repository.UserRepository;

/**
 * Custom Service class used for the user table in the database
 * methods includes to save a user to the DB with an encrypted password,
 * return a user by username, and return a user by ID
 *  
 * @see UserRepository
 * @see RoleRepository
 * @see BCryptPasswordEncoder
 * @author Drew
 *
 */
@Service
public class UserServiceImpl implements UserService
{
	public static final long USER_ROLE_ID = 2;
	public static final long ADMIN_ROLE_ID = 1;
	
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       // user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setRoles(new HashSet<>());
        user.addRole(roleRepository.findById(USER_ROLE_ID).get());
        if(user.isAdmin()) {user.addRole(roleRepository.findById(ADMIN_ROLE_ID).get());}
        userRepository.save(user);
    }


	public User findById(long id)
	{
		
		return userRepository.findById(id).get();
	}

}
