package com.um.disenio.billsystem.service.api;


import com.um.disenio.billsystem.common.GenericServiceApi;
import com.um.disenio.billsystem.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceBillApi {
    ResponseEntity<Bill> createBill(BillHeader billHeader , List<BillBody> billBody , BillFooter billFooter);
    List<Bill> getAll();
    List<Bill> getBillByClient(Long id);
    ResponseEntity<Bill> getBillById(Long id);
    ResponseEntity<HttpStatus>delete(Long id);
}
