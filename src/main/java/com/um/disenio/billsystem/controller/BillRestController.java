package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Bill;
import com.um.disenio.billsystem.service.api.ServiceBillApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bill")
public class BillRestController {
    private ServiceBillApi serviceBillApi;


    @PostMapping(value = "/create")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        return serviceBillApi.createBill(bill.getBillHeader(), bill.getBodyBill(), bill.getBillFooter());
    }

    @GetMapping("/all")
    public List<Bill> getFactura(){
        return  serviceBillApi.getAll();
    }
}
