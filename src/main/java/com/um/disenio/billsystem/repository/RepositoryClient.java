package com.um.disenio.billsystem.repository;


import com.um.disenio.billsystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryClient extends JpaRepository<Client,Long> {
    List<Client>findByDni(String dni);
}

