package com.springwebapp.services;

import com.springwebapp.domain.Users;

public interface UserService {

	Users findByUsername(String username);

	void save(Users user);

}
