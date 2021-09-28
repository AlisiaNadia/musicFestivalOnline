package com.festivalmusic.festival.validation;

import com.festivalmusic.festival.model.AddStage;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StageValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AddStage.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "stage.genre", "stage.genre");
        ValidationUtils.rejectIfEmpty(errors, "stage.capacity", "stage.capacity");

        Integer capacityLimit = 0;

        AddStage stage = (AddStage) o;

        if (stage.getTicketInfo() != null) {

                for (int i = 0; i < stage.getTicketInfo().size(); i++) {

                    ValidationUtils.rejectIfEmpty(errors, "ticketInfo[" + i + "].amount", "ticketInfo.amount");
                    ValidationUtils.rejectIfEmpty(errors, "ticketInfo[" + i + "].type", "ticketInfo.type");
                    ValidationUtils.rejectIfEmpty(errors, "ticketInfo[" + i + "].price", "ticketInfo.price");

                    if (stage.getTicketInfo().get(i).getAmount() != null) {
                        capacityLimit = capacityLimit + stage.getTicketInfo().get(i).getAmount();
                    }
                }
        }

        if (capacityLimit > 0 && stage.getStage().getCapacity() != null && capacityLimit > stage.getStage().getCapacity()) {
           errors.rejectValue("stage.capacity", "stage.capacity.limit");
        }
    }
}
