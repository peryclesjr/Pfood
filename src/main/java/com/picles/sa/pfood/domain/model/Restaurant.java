package com.picles.sa.pfood.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column
    private String name;

    @Column(name= "tax_delivery")
    private BigDecimal taxDelivery;


}
