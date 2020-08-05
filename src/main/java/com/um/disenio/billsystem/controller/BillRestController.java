package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Bill;
import com.um.disenio.billsystem.service.api.ServiceBillApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = "billing")
    public ResponseEntity<Bill> createBill( @Valid @RequestBody Bill bill){
        return serviceBillApi.createBill(bill.getBillHeader(), bill.getBillBody(), bill.getBillFooter());
    }

    @GetMapping(value = "billing/select/{id}")
    public ResponseEntity<Bill> getBillingById(@PathVariable Long id){
        return serviceBillApi.getBillById(id);
    }

    @GetMapping("billings/all")
    public List<Bill> getBill(){
        return  serviceBillApi.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("billing_client/{clientId}")
    public List<Bill> searchBillByClient(@PathVariable Long clientId){
        return serviceBillApi.getBillByClient(clientId);
    }

    @DeleteMapping(value = "billing/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        return serviceBillApi.delete(id);
    }

}

