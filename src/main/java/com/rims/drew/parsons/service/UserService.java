package com.rims.drew.parsons.service;

import com.rims.drew.parsons.entity.User;

public interface UserService
{
	void save(User user);

    User findByUsername(String username);

}
