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
    public void validate(Object o, Errors errors) {
        GeneratedData data = (GeneratedData) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Purpose", "NotEmpty");
        if (data.getPurpose().length() < 3) {
            errors.rejectValue("purpose", "Size.data.purpose");
        }
        if (data.getNextSeqNum() < 0) {
            errors.rejectValue("version", "DataVersion");
        }
    }
}