package com.enigma.wms.warungMakanSamudra.Util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ValidationUtil {

    // Pakai Jakarta Validator
    private final Validator validator;

    public void validate(Object object){
        Set<ConstraintViolation<Object>> result = validator.validate(object);
        System.out.println("Ini validate :" + result);
    }
}
