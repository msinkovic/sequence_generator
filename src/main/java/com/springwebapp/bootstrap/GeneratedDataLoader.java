package com.springwebapp.bootstrap;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
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

	private Logger logData = Logger.getLogger(GeneratedDataLoader.class);

	private Logger logUser = Logger.getLogger(UsersLoader.class);

	private Logger logRole = Logger.getLogger(UserRolesLoader.class);

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

		for (int i = 0; i < 20; i++) {
			GeneratedData test = new GeneratedData();
			LocalDateTime sqlDate = LocalDateTime.now();
			test.setDate(sqlDate);
			test.setPurpose("nekaj random");
			test.setUsername("pero");
			dataRepository.save(test);
			logData.info("Saved transaction - id: " + test.getSeqNum());
		}

		for (int i = 0; i < 20; i++) {
			GeneratedData test2 = new GeneratedData();
			test2.setPurpose("nekaj ne tolko random");
			LocalDateTime sqlDate2 = LocalDateTime.now();
			test2.setDate(sqlDate2);
			test2.setUsername("jurica");
			dataRepository.save(test2);

			logData.info("Saved transaction - id:" + test2.getSeqNum());
		}

		BCryptPasswordEncoder pwd = new BCryptPasswordEncoder(6);

		Users test3 = new Users();
		test3.setUsername("pero");
		test3.setPassword(pwd.encode("password"));

		userRepository.save(test3);

		logUser.info("Saved transaction - id: " + test3.getUsername());

		pwd = new BCryptPasswordEncoder(6);

		Users test4 = new Users();
		test4.setUsername("jurica");
		test4.setPassword(pwd.encode("password123"));

		userRepository.save(test4);

		logUser.info("Saved transaction - id:" + test4.getUsername());

		UserRoles test5 = new UserRoles();
		test5.setName("Admin");

		logRole.info("Saved Role:" + test5.getName());

		userRolesRepository.save(test5);

		UserRoles test6 = new UserRoles();
		test6.setName("User");

		logRole.info("Saved Role:" + test6.getName());

		userRolesRepository.save(test6);
	}

}