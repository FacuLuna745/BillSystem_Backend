package com.um.disenio.billsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "bills_footers")
public class BillFooter implements Serializable {

    @Id
    private Long id_Footer;

    @MapsId
    @OneToOne
    @JoinColumn(name = "header_id")
    @JsonIgnore
    private BillHeader bills_headers;
    private BigDecimal priceTotal;
    private String observation;

}
