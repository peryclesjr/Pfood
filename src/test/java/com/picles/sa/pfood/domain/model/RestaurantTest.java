package com.picles.sa.pfood.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {


    Restaurant restaurant;
    @Test
    public void veriifytLengthmorethan30(){
        restaurant = new Restaurant();
        restaurant.setName("012345678901234567890123457890123");
        assertTrue(restaurant.getName().length() > 30);
    }



}