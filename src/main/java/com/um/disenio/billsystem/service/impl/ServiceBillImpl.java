package com.um.disenio.billsystem.service.impl;

import com.um.disenio.billsystem.model.*;
import com.um.disenio.billsystem.repository.*;
import com.um.disenio.billsystem.service.api.ServiceBillApi;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class ServiceBillImpl implements ServiceBillApi {
    @Autowired
    private RepositoryBillHeader repositoryBillHeader;
    @Autowired
    private RepositoryBillBody repositoryBillBody;
    @Autowired
    private RepositoryBillFooter repositoryBillFooter;
    @Autowired
    private RepositoryClient repositoryClient;
    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public ResponseEntity<Bill> createBill(BillHeader billHeader, List<BillBody> billBody, BillFooter billFooter) {
        billHeader.setDate(Date.valueOf(LocalDate.now()));
        billHeader.setClient(repositoryClient.findById(billHeader.getClient().getId()).orElse(null));
        billHeader.setTypeBill(billHeader.getClient().getIvaCondition() == IvaCondition.RESPONSABLE_INSCRIPTO ? TypeBill.A : TypeBill.B);//Operacion ternaria
        repositoryBillHeader.save(billHeader);

        for(BillBody product:billBody){
            product.setProduct(repositoryProduct.findById(product.getProduct().getId()).orElse(null));
            product.setQuantity(product.getQuantity());//Dudas
            product.setSubTotal(product.getProduct().getPrice().multiply(product.getQuantity()));
            product.setBillHeader(billHeader);
            repositoryBillBody.save(product);
        }
        return new ResponseEntity<>(new Bill(billHeader,billBody,billFooter),HttpStatus.CREATED);
    }

    public List<Bill> getAll(){
        ArrayList<Bill> bills = new ArrayList<>();

        for (BillHeader billHeader : repositoryBillHeader.findAll()) {

            bills.add(0, new Bill(billHeader, billHeader.getBillBodies(), repositoryBillFooter.findById(billHeader.getId()).orElse(null)));
        }

        return bills;
    }

}
