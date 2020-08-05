package com.um.disenio.billsystem.service.api;


import com.um.disenio.billsystem.common.GenericServiceApi;
import com.um.disenio.billsystem.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceProductApi  extends GenericServiceApi<Product,Long> {
    List<Product> findByNameApi(String name);
}
