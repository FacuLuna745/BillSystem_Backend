package com.um.disenio.billsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String cuit;

    @Enumerated(EnumType.ORDINAL)
    private IvaCondition ivaCondition;
}
