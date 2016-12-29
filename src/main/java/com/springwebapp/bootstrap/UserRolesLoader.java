package com.springwebapp.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springwebapp.domain.UserRoles;
import com.springwebapp.repositories.UserRolesRepository;


@Component
public class UserRolesLoader {
	
	private UserRolesRepository userRolesRepository;
	 
    private Logger log = Logger.getLogger(UserRolesLoader.class);
 
    @Autowired
    public void setUserRolesRepository(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }
 
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
		UserRoles test5 = new UserRoles();
		test5.setName("Admin");
		
		log.info("Saved role:" + test5.getName());
		
		userRolesRepository.save(test5);
		
		UserRoles test6 = new UserRoles();
		test6.setName("User");
		
		userRolesRepository.save(test6);
        log.info("Saved Role:" + test6.getName());
    }

}
