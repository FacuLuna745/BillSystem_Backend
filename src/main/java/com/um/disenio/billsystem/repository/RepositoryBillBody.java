package com.um.disenio.billsystem.repository;


import com.um.disenio.billsystem.model.BillBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBillBody extends JpaRepository<BillBody,Long> {
}
