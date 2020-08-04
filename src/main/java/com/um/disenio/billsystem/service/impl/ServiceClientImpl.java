package com.um.disenio.billsystem.service.impl;



import com.um.disenio.billsystem.common.GenericServiceImpl;
import com.um.disenio.billsystem.model.Client;
import com.um.disenio.billsystem.repository.RepositoryClient;
import com.um.disenio.billsystem.service.api.ServiceClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceClientImpl extends GenericServiceImpl<Client, Long> implements ServiceClientApi {
    @Autowired
    private RepositoryClient repositoryClient;

    @Override
    public List<Client> findByDniOrCuitApi(String dni) {
        return repositoryClient.findByDni(dni).stream().filter(Client::getActive).collect(Collectors.toList());
    }

    @Override
    public JpaRepository<Client, Long> getRepository() {
        return repositoryClient;
    }

}
