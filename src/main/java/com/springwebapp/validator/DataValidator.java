package com.springwebapp.validator;

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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "purpose", "NotEmpty");
        if (data.getVersion() != null) {
            errors.rejectValue("version", "DataVersion");
        }
    }
}