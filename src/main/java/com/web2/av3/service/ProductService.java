package com.web2.av3.service;

import com.web2.av3.model.Product;
import com.web2.av3.model.ProductDTO;
import com.web2.av3.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAllByAtivoTrue();
    }

    public Product findProductById(@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()).getBody();
    }

    @Transactional
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){
        repository.save(new Product(product));
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ProductDTO dados){
        if(dados.id_produto() == null){
            return ResponseEntity.badRequest().build();
        }

        Product product = repository.getReferenceById(dados.id_produto());
        product.atualizarProduto(dados);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity deleteLogic(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Product product = repository.getReferenceById(id);
        product.inativar();
        return ResponseEntity.ok().build();
    }
}
