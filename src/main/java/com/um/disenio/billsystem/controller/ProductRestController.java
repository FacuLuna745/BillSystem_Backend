package com.um.disenio.billsystem.controller;


import com.um.disenio.billsystem.model.Product;
import com.um.disenio.billsystem.service.api.ServiceProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/")
public class ProductRestController {
    @Autowired
    private ServiceProductApi serviceProductApi;

    @GetMapping(value = "product/all")
    public List<Product> getAll(){
        return serviceProductApi.getAll();
    }

    @GetMapping(value = "/select/{id}")
    public Product getById(@PathVariable Long id){
        return serviceProductApi.get(id);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return serviceProductApi.save(product);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        Product product = serviceProductApi.get(id);
        if (product.getActive() == true) {
            serviceProductApi.delete(id);
        }else{
            return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }


}
