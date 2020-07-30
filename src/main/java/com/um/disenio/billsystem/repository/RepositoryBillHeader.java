package com.um.disenio.billsystem.repository;


import com.um.disenio.billsystem.model.BillHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBillHeader extends JpaRepository<BillHeader,Long> {

}
