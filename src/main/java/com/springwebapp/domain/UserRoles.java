package com.springwebapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER_ROLES")
public class UserRoles {
	private Long id;
	private String name;
	private Set<Users> userList;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "roles")
	public Set<Users> getUsers() {
		return userList;
	}

	public void setUsers(Set<Users> users) {
		this.userList = users;
	}
}
