package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Client;
import com.um.disenio.billsystem.model.Product;
import com.um.disenio.billsystem.service.api.ServiceProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "api/")
public class ProductRestController {
    @Autowired
    private ServiceProductApi serviceProductApi;

    @GetMapping(value = "products/all")
    public List<Product> getAll(){
        return serviceProductApi.getAll();
    }

    @GetMapping(value = "select/{id}")
    public Product getById(@PathVariable Long id){
        return serviceProductApi.get(id);
    }

    @PutMapping(value = "product/edit")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
        return serviceProductApi.save(product);
    }

    @PostMapping(value = "product")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        return serviceProductApi.save(product);
    }

    @PutMapping(value = "product/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        return serviceProductApi.delete(id);
    }

    @GetMapping(value = "search_product")
    public List<Product> searchProduct(@RequestParam String name){
        return serviceProductApi.findByNameApi(name);
    }


}
