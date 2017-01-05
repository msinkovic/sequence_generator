package com.springwebapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springwebapp.domain.GeneratedData;
import com.springwebapp.services.GeneratedDataService;

@Component
public class DataValidator implements Validator {
    
	@Autowired
	private GeneratedDataService generatedDataService;
	
    @Override
    public boolean supports(Class<?> aClass) {
        return GeneratedData.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        GeneratedData data = (GeneratedData) object;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "purpose", "short");
        
        if (generatedDataService.getGeneratedDataBySeqNum(data.getNextSeqNum()) != null) {
        	data.setNextSeqNum(data.getNextSeqNum()+1);
            errors.rejectValue("version", "change");
        }
        if (data.getUsername().compareTo(auth.getName()) != 0)
        {
        	errors.rejectValue("username", "user");
        }
    }
}