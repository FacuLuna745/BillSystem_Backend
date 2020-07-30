package com.um.disenio.billsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "bills_footers")
public class BillFooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFooter;

    @MapsId
    @OneToOne
    @JoinColumn(name = "header_id")
    @JsonIgnore
    private BillHeader billHeader;
    private BigDecimal priceTotal;
    private String observation;

}
