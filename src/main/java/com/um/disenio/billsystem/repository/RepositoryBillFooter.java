package com.um.disenio.billsystem.repository;


import com.um.disenio.billsystem.model.BillFooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBillFooter extends JpaRepository<BillFooter,Long>{

}
