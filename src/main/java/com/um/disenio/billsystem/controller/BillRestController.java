package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Bill;
import com.um.disenio.billsystem.service.api.ServiceBillApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "api/")
public class BillRestController {
    @Autowired
    private ServiceBillApi serviceBillApi;

    @PostMapping(value = "billing/create")
    public ResponseEntity<Bill> createBill( @Valid @RequestBody Bill bill){
        return serviceBillApi.createBill(bill.getBillHeader(), bill.getBodyBill(), bill.getBillFooter());
    }
    @GetMapping("billings/all")
    public List<Bill> getFactura(){
        return  serviceBillApi.getAll();
    }
}
