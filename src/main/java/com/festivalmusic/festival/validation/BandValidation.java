package com.festivalmusic.festival.validation;

import com.festivalmusic.festival.model.BandRegistration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class BandValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return BandRegistration.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "name", "band.name");
        ValidationUtils.rejectIfEmpty(errors, "schedule.time", "schedule.time");
        ValidationUtils.rejectIfEmpty(errors, "schedule.stageId.stageId", "schedule.stageId");

        BandRegistration band = (BandRegistration) o;


        if (band.getUsers() != null) {
            if( band.getUsers().size() > 0 ) {

                for (int i = 0; i < band.getUsers().size(); i++) {

                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].username", "username");
                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].lastName", "lastName");
                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].firstName", "firstName");
                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].email", "email");
                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].phone", "phone");
                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].address", "address");
                    ValidationUtils.rejectIfEmpty(errors, "users[" + i + "].password", "password");

                    if (band.getUsers().get(i).getUsername().length() > 0 && (band.getUsers().get(i).getUsername().length() > 30 || band.getUsers().get(i).getUsername().length() < 5)) {
                        errors.rejectValue("users[" + i + "].username", "username.size");
                    }


                    if (band.getUsers().get(i).getUsername().length() > 0 && (band.getUsers().get(i).getUsername().length() > 30 || band.getUsers().get(i).getUsername().length() < 5)) {
                        errors.rejectValue("users[" + i + "].password", "password.size");
                    }
                }

                Date today = new Date();

                if (band.getSchedule().getScheduleDate() != null && (band.getSchedule().getScheduleDate().before(today) || band.getSchedule().getScheduleDate().equals(today))) {
                    errors.rejectValue("schedule.scheduleDate", "wrong.scheduleDate");
                }
            }
        }
    }
}
