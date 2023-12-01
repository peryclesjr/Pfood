package com.picles.sa.pfood.domain.model;


import jakarta.persistence.*;
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
    @SequenceGenerator(name="seq_kitchen",
            sequenceName="seq_kitchen",
            allocationSize=1)
    @GeneratedValue(generator="seq_kitchen",strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 30)
    @Size( max = 30, message = "The field has size bigger than expected")
    private String name;

}
