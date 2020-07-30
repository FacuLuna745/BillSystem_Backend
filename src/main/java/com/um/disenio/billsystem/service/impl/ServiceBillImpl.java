package com.um.disenio.billsystem.service.impl;

import com.um.disenio.billsystem.model.Bill;
import com.um.disenio.billsystem.model.BillBody;
import com.um.disenio.billsystem.model.BillFooter;
import com.um.disenio.billsystem.model.BillHeader;
import com.um.disenio.billsystem.repository.RepositoryBillFooter;
import com.um.disenio.billsystem.repository.RepositoryBillBody;
import com.um.disenio.billsystem.repository.RepositoryBillHeader;
import com.um.disenio.billsystem.service.api.ServiceBillApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBillImpl implements ServiceBillApi {

    private RepositoryBillHeader billHeader;
    private RepositoryBillBody billBody;
    private RepositoryBillFooter billFooter;


    @Override
    public ResponseEntity<Bill> createBill(BillHeader billHeader, List<BillBody> billBody, BillFooter billFooter) {
        return null;
    }

    @Override
    public ResponseEntity<Bill> getBillById(Long Id) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteBillById(Long id) {
        return null;
    }

    @Override
    public List<Bill> getAll() {
        return null;
    }
}
