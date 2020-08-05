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
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class ServiceBillImpl implements ServiceBillApi  {
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

        System.out.println(billHeader.getClient().getId());
        billHeader.setClient(repositoryClient.findById(billHeader.getClient().getId()).orElse(null));
        billHeader.setTypeBill(billHeader.getClient().getIvaCondition() == IvaCondition.RESPONSABLE_INSCRIPTO ? TypeBill.A : TypeBill.B);
        repositoryBillHeader.save(billHeader);

        for(BillBody product:billBody){
            product.setProduct(repositoryProduct.findById(product.getProduct().getId()).orElse(null));
            product.setQuantity(product.getQuantity());//Dudas
            product.setSubTotal(product.getProduct().getPrice().multiply(product.getQuantity()));
            product.setBillHeader(billHeader);
            repositoryBillBody.save(product);
        }
        billFooter.setDate(Date.valueOf(LocalDate.now()));
        billFooter.setBills_headers(billHeader);
        billFooter.setPriceTotal(BigDecimal.valueOf(billBody.stream().map(BillBody::getSubTotal).mapToDouble(BigDecimal::doubleValue).sum()));
        repositoryBillFooter.save(billFooter);

        return new ResponseEntity<>(new Bill(billHeader,billBody,billFooter),HttpStatus.CREATED);
    }

    public List<Bill> getAll(){
        ArrayList<Bill> bills = new ArrayList<>();
        for (BillHeader billHeader : repositoryBillHeader.findAll().stream().filter(BillHeader::getActive).collect(Collectors.toList())) {
            bills.add(0,new Bill(billHeader, billHeader.getBillBodies(), repositoryBillFooter.findById(billHeader.getId()).orElse(null)));
        }
        return bills;
    }

    @Override
    public List<Bill> getBillByClient(Long id) {
        Client client = repositoryClient.findById(id).get();
        ArrayList<Bill> bills = new ArrayList<>();

        ArrayList<BillHeader> headers = (ArrayList<BillHeader>) repositoryBillHeader.findAll()
            .stream().filter(e -> e.getClient().getId().equals(client.getId())).collect(Collectors.toList());
        for(BillHeader billHeader : headers){
            bills.add(0,new Bill(billHeader, billHeader.getBillBodies(),repositoryBillFooter.findById(billHeader.getId()).get()));
        }
        return bills;
    }

    @Override
    public ResponseEntity<Bill> getBillById(Long id) {
        Bill bill = new Bill();

        bill.setBillHeader(repositoryBillHeader.findById(id).orElse(null));
        bill.setBillBody(bill.getBillHeader().getBillBodies());
        bill.setBillFooter(repositoryBillFooter.findById(id).orElse(null));

        return new ResponseEntity<>(bill,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(Long id) {
        if(!repositoryBillHeader.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BillHeader billHeader = repositoryBillHeader.findById(id).get();
        billHeader.setActive(false);
        repositoryBillHeader.save(billHeader);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
