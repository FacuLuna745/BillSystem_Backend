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
    private String dni;

    @Enumerated(EnumType.ORDINAL)
    private IvaCondition ivaCondition;

    @NotEmpty
    private String country;

    @NotEmpty
    private String state;

    @NotEmpty
    private String address;

    @NotEmpty
    private String email;
}
