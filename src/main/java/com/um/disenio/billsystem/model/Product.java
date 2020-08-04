package com.um.disenio.billsystem.model;

import com.um.disenio.billsystem.common.Active;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="products")
public class Product implements Active<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private ProductCategory productCategory;

    @NotEmpty
    private BigDecimal price;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean active = true;

}
