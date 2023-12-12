package com.web2.av3.services;

import com.web2.av3.domain.fornecedor.Fornecedor;
import com.web2.av3.repositories.SupplierRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class FornecedorService {
    @Autowired
    SupplierRepository repository;

    @Transactional
    public ResponseEntity<Fornecedor> createSupplier(@RequestBody @Valid Fornecedor supplier){
        repository.save(new Fornecedor(supplier));
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
