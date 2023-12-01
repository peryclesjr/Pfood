package com.picles.sa.pfood.domain.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {


    private Restaurant restaurant;
    private Validator validator;

    private DateTimeFormatter ftDate;

    private LocalDate localDate;

    @BeforeEach
    public void setup(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        restaurant = new Restaurant();
        restaurant.setTaxDelivery(new BigDecimal(1.00));
        localDate = LocalDate.now();
        restaurant.setDateCreate(localDate);
        restaurant.setDateLastUpdate(localDate);


        ftDate = DateTimeFormatter.ofPattern("YYYY-MM-DD");

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
    public void veriifyTaxDeliveryNotNull(){

        restaurant.setName("0123456789012345678901234578901230123456789012345678901234578901230123456" +
                "3457890123");
        Set<ConstraintViolation<Restaurant>> violations = validator.validate( restaurant);
        System.out.println(validator.validate( restaurant));
        assertTrue(violations.isEmpty());
    }

    @Test
    public void veriifyTaxDeliveryNull(){
        Restaurant restaurantTaxNull = new Restaurant();
        restaurantTaxNull.setName("0123456789012345678901234578901230123456789012345678901234578901230123456" +
                "3457890123");
        Set<ConstraintViolation<Restaurant>> violations = validator.validate( restaurantTaxNull);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void verifyRestaurantIsActivated(){
        restaurant.setIsActivate(true);

        assertEquals(true, restaurant.getIsActivate());
    }

    @Test
    public void verifyRestaurantIsNotActivated(){
        restaurant.setIsActivate(false);

        assertEquals(false, restaurant.getIsActivate());
    }

    @Test
    public void verifyDateCreateAndUpdateRestaurant(){
        String ftString = localDate.format(ftDate);
        assertEquals(ftString,  restaurant.getDateCreate().format(ftDate));
        assertEquals(ftString,  restaurant.getDateLastUpdate().format(ftDate));


        //update
        LocalDate nowLocalDate = LocalDate.now();
        restaurant.setDateLastUpdate(nowLocalDate);
        String ftStringNow = nowLocalDate.format(ftDate);
        assertEquals(ftStringNow,  restaurant.getDateLastUpdate().format(ftDate));

    }

}