package com.um.disenio.billsystem.service.api;


import com.um.disenio.billsystem.model.Bill;
import com.um.disenio.billsystem.model.BillBody;
import com.um.disenio.billsystem.model.BillFooter;
import com.um.disenio.billsystem.model.BillHeader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceBillApi {
    ResponseEntity<Bill> createBill(BillHeader billHeader , List<BillBody> billBody , BillFooter billFooter);
    ResponseEntity<Bill> getBillById(Long Id);
    ResponseEntity<String> deleteBillById(Long id);
    List<Bill> getAll();
}
