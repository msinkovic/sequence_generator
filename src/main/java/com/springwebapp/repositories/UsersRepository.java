package com.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springwebapp.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
}
