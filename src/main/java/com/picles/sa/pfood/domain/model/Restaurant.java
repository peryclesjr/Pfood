package com.picles.sa.pfood.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    @SequenceGenerator(name="seq_restaurant",
            sequenceName="seq_restaurant",
            allocationSize=1)
    @GeneratedValue(generator="seq_restaurant",strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 180, nullable = false)
    private String name;

    @Column(name= "tax_delivery", scale= 2)
    @NotNull(message = "We need to define the value, zero(0.00) or a value like 0.01, 9.99")
    private BigDecimal taxDelivery;

    @Column
    private Boolean isActivate;

    @Column
    private LocalDate  dateCreate;

    @Column
    private LocalDate  dateLastUpdate;

}
