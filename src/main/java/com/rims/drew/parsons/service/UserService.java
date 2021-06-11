package com.rims.drew.parsons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.repository.UserRepository;


@Service
public class UserService
{
	@Autowired
    private UserRepository userRepository;
	
	
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


	public User findById(long id)
	{
		
		return userRepository.findById(id).get();
	}

}
