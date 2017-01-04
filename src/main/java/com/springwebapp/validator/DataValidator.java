package com.springwebapp.validator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springwebapp.domain.GeneratedData;

@Component
public class DataValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> aClass) {
        return GeneratedData.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        GeneratedData data = (GeneratedData) object;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "purpose", "short");
        if (data.getVersion() != null) {
            errors.rejectValue("version", "change");
        }
        if (data.getUsername().compareTo(auth.getName()) != 0)
        {
        	errors.rejectValue("username", "user");
        }
    }
}