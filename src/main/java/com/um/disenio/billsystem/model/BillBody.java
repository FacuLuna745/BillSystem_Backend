package com.um.disenio.billsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "bills_bodys")
public class BillBody implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "billHeader_id")
    @JsonIgnore
    private BillHeader billHeader;
    private BigDecimal quantity;
    private BigDecimal subTotal;

}
