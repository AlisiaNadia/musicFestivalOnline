package com.festivalmusic.festival.validation;

import com.festivalmusic.festival.model.Festival;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

public class FestivalValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Festival.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Date today = new Date();

        ValidationUtils.rejectIfEmpty(errors, "editionName", "festival.edition");
        ValidationUtils.rejectIfEmpty(errors, "startDate", "festival.startDate");
        ValidationUtils.rejectIfEmpty(errors, "endDate", "festival.endDate");

        Festival festival = (Festival) o;

        if ((festival.getStartDate() != null && festival.getEndDate() != null)) {
            if (festival.getEndDate().before(festival.getStartDate())) {
                errors.rejectValue("endDate", "invalid.end.date");
            }
        }
        
        if (festival.getEndDate() != null && festival.getEndDate().before(today)) {
            errors.rejectValue("endDate", "invalid.date");
        }

        if (festival.getStartDate() != null && festival.getStartDate().before(today)) {
            errors.rejectValue("startDate", "invalid.date");
        }
    }
}
