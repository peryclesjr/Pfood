package com.picles.sa.pfood.domain.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {


    private Restaurant restaurant;
    private Validator validator;

    @BeforeEach
    public void setup(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        restaurant = new Restaurant();
        restaurant.setTaxDelivery(new BigDecimal(1.00));


    }
    @Test
    public void veriifyLengthNameMorethan180(){

        restaurant.setName("0123456789012345678901234578901230123456789012345678901234578901230123456" +
                "7890123456789012345" +
                "789012301234567890123456789012345789012301234567890123456789012345789012301234567890123456789012" +
                "3457890123");

        Set<ConstraintViolation<Restaurant>> violations = validator.validate( restaurant);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void veriifyLengthNameLessthan180(){

        restaurant.setName("0123456789012345678901234578901230123456789012345678901234578901230123456" +
                "3457890123");
        restaurant.setTaxDelivery(new BigDecimal(1.00));
        Set<ConstraintViolation<Restaurant>> violations = validator.validate( restaurant);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void veriifyTaxDEliveryNotNull(){

        restaurant.setName("0123456789012345678901234578901230123456789012345678901234578901230123456" +
                "3457890123");
        Set<ConstraintViolation<Restaurant>> violations = validator.validate( restaurant);
        System.out.println(validator.validate( restaurant));
        assertTrue(violations.isEmpty());
    }

    @Test
    public void veriifyTaxDEliveryNull(){
        Restaurant restaurantTaxNull = new Restaurant();
        restaurantTaxNull.setName("0123456789012345678901234578901230123456789012345678901234578901230123456" +
                "3457890123");
        Set<ConstraintViolation<Restaurant>> violations = validator.validate( restaurantTaxNull);
        assertFalse(violations.isEmpty());
    }

}