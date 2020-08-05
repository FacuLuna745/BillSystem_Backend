package com.um.disenio.billsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
    @JsonIgnore
    private Long id_Footer;

    private Date date;

    @MapsId
    @OneToOne
    @JoinColumn(name = "header_id")
    @JsonIgnore
    private BillHeader bills_headers;
    private BigDecimal priceTotal;
    private String observation;

}
