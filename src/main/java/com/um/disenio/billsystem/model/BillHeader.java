package com.um.disenio.billsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bills_headers")
public class BillHeader implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Client client;

    @Enumerated(EnumType.ORDINAL)
    private TypeBill typeBill;


    @OneToMany(mappedBy = "billHeader")
    @JsonIgnore
    private List<BillBody> billBodies;
}

