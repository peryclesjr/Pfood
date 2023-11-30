package com.picles.sa.pfood.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.*;




@Entity
@Table(name = "tab_kitchen")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Kitchen {

    @Id
    private Long id;

    @Column(length = 30)
    @Size( max = 30, message = "The field has size bigger than expected")
    private String name;

}
