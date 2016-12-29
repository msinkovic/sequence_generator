package com.springwebapp.bootstrap;

import java.security.SecureRandom;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.springwebapp.domain.Users;
import com.springwebapp.repositories.UsersRepository;


@Component
public class UsersLoader {
	
	private UsersRepository userRepository;
	 
    private Logger log = Logger.getLogger(UsersLoader.class);
 
    @Autowired
    public void setUserRepository(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
    	BCryptPasswordEncoder pwd = new BCryptPasswordEncoder(512, new SecureRandom());
    	
        Users test = new Users();
        test.setUsername("pero");
        test.setPassword(pwd.encode("password"));
        
        userRepository.save(test);
 
        log.info("Saved transaction - id: " + test.getId());
 
        Users test2 = new Users();
        test2.setUsername("jure");
        test2.setPassword(pwd.encode("password123"));
        
        userRepository.save(test2);
 
        log.info("Saved transaction - id:" + test2.getId());
    }

}
