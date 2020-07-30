package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Client;
import com.um.disenio.billsystem.service.api.ServiceClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/client")
public class ClientRestController {

    @Autowired
    private ServiceClientApi serviceClientApi;

    @GetMapping(value = "/all")
    public List<Client> getAll() {
        return serviceClientApi.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Client getById(@PathVariable Long id) {
        return serviceClientApi.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        Client obj = serviceClientApi.save(client);
        return new ResponseEntity<Client>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id){
        Client client = serviceClientApi.get(id);
        if (client != null) {
            serviceClientApi.delete(id);
        }else{
            return new ResponseEntity<Client>(client, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }
}
