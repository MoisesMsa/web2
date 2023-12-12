package com.web2.av3.controllers;

import com.web2.av3.model.Supplier;
import com.web2.av3.service.SupplierService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    SupplierService supplier;

    @PostMapping
    @Transactional
    public void createSupplier(@RequestBody @Valid Supplier data){
        supplier.createSupplier(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteSupplier(@PathVariable Long id){
        supplier.deleteSupplier(id);
    }
}
