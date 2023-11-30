package com.picles.sa.pfood.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tab_restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Restaurant {

    @Id
    private Long id;

    @Column(length = 180, nullable = false)
    private String name;

    @Column(name= "tax_delivery", scale= 2)
    @NotNull(message = "We need to define the value, zero(0.00) or a value like 0.01, 9.99")
    private BigDecimal taxDelivery;


}
