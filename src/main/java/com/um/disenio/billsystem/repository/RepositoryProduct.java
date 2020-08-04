package com.um.disenio.billsystem.repository;


import com.um.disenio.billsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProduct extends JpaRepository<Product,Long> {
    List<Product> findByIdOrName(Long id , String name);
}
