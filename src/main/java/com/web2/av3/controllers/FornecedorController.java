package com.web2.av3.controllers;

import com.web2.av3.domain.fornecedor.Fornecedor;
import com.web2.av3.services.FornecedorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class FornecedorController {
    @Autowired
    FornecedorService supplier;

    @PostMapping
    @Transactional
    public void createSupplier(@RequestBody @Valid Fornecedor data){
        supplier.createSupplier(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteSupplier(@PathVariable Long id){
        supplier.deleteSupplier(id);
    }
}
