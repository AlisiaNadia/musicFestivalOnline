package com.festivalmusic.festival.validation;

import com.festivalmusic.festival.model.SingerRegistration;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

public class SingleValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return SingerRegistration.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "user.username", "username");
        ValidationUtils.rejectIfEmpty(errors, "user.lastName", "lastName");
        ValidationUtils.rejectIfEmpty(errors, "user.firstName", "firstName");
        ValidationUtils.rejectIfEmpty(errors, "user.email", "email");
        ValidationUtils.rejectIfEmpty(errors, "user.phone", "phone");
        ValidationUtils.rejectIfEmpty(errors, "user.address", "address");
        ValidationUtils.rejectIfEmpty(errors, "user.password", "password");
        ValidationUtils.rejectIfEmpty(errors, "schedule.scheduleDate", "schedule.scheduleDate");
        ValidationUtils.rejectIfEmpty(errors, "schedule.time", "schedule.time");
        ValidationUtils.rejectIfEmpty(errors, "schedule.stageId", "schedule.stageId");

        SingerRegistration singer = (SingerRegistration) o;

        Date today = new Date();

        if (singer.getUser().getUsername().length() > 0 && (singer.getUser().getUsername().length() > 30 || singer.getUser().getUsername().length() < 5)) {
            errors.rejectValue("user.username", "username.size");
        }

        if (singer.getUser().getPassword().length() > 0 && (singer.getUser().getPassword().length() > 30 || singer.getUser().getPassword().length() < 5)) {
            errors.rejectValue("user.password", "password.size");
        }

        if (singer.getSchedule().getScheduleDate() != null && (singer.getSchedule().getScheduleDate().before(today) || singer.getSchedule().getScheduleDate().equals(today))) {
            errors.rejectValue("schedule.scheduleDate", "wrong.scheduleDate");
        }

        if (!singer.getUser().getPhone().matches("[0-9]+")) {
            errors.rejectValue("user.phone", "phone.format");
        }

        if (singer.getUser().getPhone().length() < 10) {
            errors.rejectValue("user.phone", "phone.length");
        }

    }
}
