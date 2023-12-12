package com.web2.av3.service;

import com.web2.av3.model.Supplier;
import com.web2.av3.repositories.SupplierRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository repository;

    @Transactional
    public ResponseEntity<Supplier> createSupplier(@RequestBody @Valid Supplier supplier){
        repository.save(new Supplier(supplier));
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity deleteSupplier(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //TODO funções de listar e atualizar fornecedores (suppliers)
}
