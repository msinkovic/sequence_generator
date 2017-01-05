package com.springwebapp.bootstrap;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.springwebapp.domain.GeneratedData;
import com.springwebapp.domain.UserRoles;
import com.springwebapp.domain.Users;
import com.springwebapp.repositories.GeneratedDataRepository;
import com.springwebapp.repositories.UserRolesRepository;
import com.springwebapp.repositories.UsersRepository;

@Component
public class GeneratedDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private GeneratedDataRepository dataRepository;
	private UsersRepository userRepository;
	private UserRolesRepository userRolesRepository;

	@Autowired
	public void setDataRepository(GeneratedDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@Autowired
	public void setUserRepository(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserRolesRepository(UserRolesRepository userRolesRepository) {
		this.userRolesRepository = userRolesRepository;
		;
	}

	public void onApplicationEvent(ContextRefreshedEvent event) {

			GeneratedData test = new GeneratedData();
			LocalDateTime sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setPurpose("nesto random");
			test.setUsername("pero");
			dataRepository.save(test);
			
			test = new GeneratedData();
			test.setPurpose("nesto ne tolko random");
			sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setUsername("jurica");
			dataRepository.save(test);
			
			test = new GeneratedData();
			test.setPurpose("malo duzi tekst za testiranje trimmanja");
			sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setUsername("jurica");
			dataRepository.save(test);
			
			test = new GeneratedData();
			test.setPurpose("asd");
			sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setUsername("pero");
			dataRepository.save(test);
			
			test = new GeneratedData();
			test.setPurpose("need this");
			sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setUsername("pero");
			dataRepository.save(test);
			
			test = new GeneratedData();
			test.setPurpose("jos jedna sekvenca");
			sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setUsername("jurica");
			dataRepository.save(test);
			
			test = new GeneratedData();
			test.setPurpose("sedma sekvenca, da se vidi paging na dijelu");
			sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setUsername("pero");
			dataRepository.save(test);
			

			BCryptPasswordEncoder pwd = new BCryptPasswordEncoder(6);
	
			Users test2 = new Users();
			test2.setUsername("pero");
			test2.setPassword(pwd.encode("password"));
	
			userRepository.save(test2);
	
	
			pwd = new BCryptPasswordEncoder(6);
	
			test2 = new Users();
			test2.setUsername("jurica");
			test2.setPassword(pwd.encode("password123"));
	
			userRepository.save(test2);
	
			UserRoles test3 = new UserRoles();
			test3.setName("Admin");
	
			userRolesRepository.save(test3);
	
			test3 = new UserRoles();
			test3.setName("User");
	
			userRolesRepository.save(test3);
		}

}