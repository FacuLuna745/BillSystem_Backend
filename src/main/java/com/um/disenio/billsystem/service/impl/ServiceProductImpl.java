package com.um.disenio.billsystem.service.impl;


import com.um.disenio.billsystem.common.GenericServiceImpl;
import com.um.disenio.billsystem.model.Product;
import com.um.disenio.billsystem.repository.RepositoryProduct;
import com.um.disenio.billsystem.service.api.ServiceProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceProductImpl extends GenericServiceImpl<Product,Long> implements ServiceProductApi {
    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public CrudRepository<Product, Long> getRepository() {
        return repositoryProduct;
    }
}
