package com.um.disenio.billsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "bills_headers")
public class BillHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @Enumerated(EnumType.ORDINAL)
    private TypeBill typeBill;

    @OneToOne
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "bill_header")
    private List<BillBody> billBodies;

}

