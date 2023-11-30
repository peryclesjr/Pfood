package com.picles.sa.pfood.domain.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class KitchenTest {


    private Kitchen kitchen;
    private Validator validator;

    @BeforeEach
    public void setup(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        kitchen = new Kitchen();
        kitchen.setName("012345678901234567890123457890123123456");
    }
    @Test
    public void veriifytLengthmorethan30(){
        System.out.println(validator.validate( kitchen));
        Set<ConstraintViolation<Kitchen>> violations = validator.validate( kitchen);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void veriifytLengthLessthan30(){
        kitchen.setName("less than 30");
        System.out.println(validator.validate( kitchen));
        Set<ConstraintViolation<Kitchen>> violations = validator.validate( kitchen);
        assertTrue(violations.isEmpty());
    }

}