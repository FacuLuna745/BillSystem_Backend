package com.um.disenio.billsystem.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Bill {

    private BillHeader billHeader;
    private List<BillBody> bodyBill;
    private BillFooter billFooter;

}
