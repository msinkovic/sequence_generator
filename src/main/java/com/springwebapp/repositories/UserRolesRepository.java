package com.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springwebapp.domain.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{
}
