package com.um.disenio.billsystem.service.api;


import com.um.disenio.billsystem.common.GenericServiceApi;
import com.um.disenio.billsystem.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceClientApi extends GenericServiceApi<Client, Long> {
    List<Client>findByDniOrCuitApi(String dni);
}
