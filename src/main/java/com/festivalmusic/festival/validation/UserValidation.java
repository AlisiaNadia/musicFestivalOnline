package com.festivalmusic.festival.validation;

import com.festivalmusic.festival.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "username", "username");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName");
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName");
        ValidationUtils.rejectIfEmpty(errors, "email", "email");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone");
        ValidationUtils.rejectIfEmpty(errors, "address", "address");
        ValidationUtils.rejectIfEmpty(errors, "password", "password");

        User user = (User) o;

        if (user.getUsername().length() > 0 && (user.getUsername().length() > 30 || user.getUsername().length() < 5)) {
            errors.rejectValue("username", "username.size");
        }

        if (user.getPassword().length() > 0 && (user.getPassword().length() > 30 || user.getPassword().length() < 5)) {
            errors.rejectValue("password", "password.size");
        }

        if (!user.getPhone().matches("[0-9]+")) {
           errors.rejectValue("phone", "phone.format");
        }

        if (user.getPhone().length() < 10) {
            errors.rejectValue("phone", "phone.length");
        }
    }


}
