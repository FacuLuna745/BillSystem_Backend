package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Client;
import com.um.disenio.billsystem.service.api.ServiceClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "api/")
public class ClientRestController {

    @Autowired
    private ServiceClientApi serviceClientApi;

    @GetMapping(value = "clients/all")
    public List<Client> getAll() {
        return serviceClientApi.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Client getById(@PathVariable Long id) {
        return serviceClientApi.get(id);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@Valid  @RequestBody Client client){
       return serviceClientApi.save(client);
    }

    @PutMapping(value = "delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        return serviceClientApi.delete(id);
    }
}
