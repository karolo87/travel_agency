package com.travelagency.demo.validator;

import com.travelagency.demo.dto.TripPurchaseDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TripPurchaseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TripPurchaseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TripPurchaseDto trip = (TripPurchaseDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientFirstName", "NotEmpty", "Pole wymagane!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientLastName", "NotEmpty", "Pole wymagane!");

//        if (trip.getAdultsQuantity() == null || trip.getAdultsQuantity().equals("")) {
//            errors.rejectValue("adultsQuantity", "value.positive", "Pole nie może być wartością ujemną.");
//        }
        if (trip.getChildrenQuantity() == null || Integer.valueOf(trip.getChildrenQuantity()) < 0) {
            errors.rejectValue("childrenQuantity", "value.positive", "Pole nie może być wartością ujemną.");
        }
        if (!trip.getAdultsQuantity().matches("^\\d+$")) {
            errors.rejectValue("adultsQuantity", "not.int");
        }
        if (!trip.getChildrenQuantity().matches("^\\d+$")) {
            errors.rejectValue("childrenQuantity", "not.int");
        }
    }
}
