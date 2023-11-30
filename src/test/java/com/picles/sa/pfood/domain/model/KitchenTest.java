package com.picles.sa.pfood.domain.model;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitchenTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Kitchen kitchen;
    @Test
    public void veriifytLengthmorethan30(){

        kitchen = new Kitchen();
        kitchen.setName("012345678901234567890123457890123123456");
        assertThrows(ConstraintViolationException.class, () -> {
            validator.validate( kitchen);
        });

    }
}