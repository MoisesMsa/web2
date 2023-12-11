package com.web2.av3.controllers;

import com.web2.av3.model.Product;
import com.web2.av3.model.ProductDTO;
import com.web2.av3.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    ProductService product;

    @GetMapping
    public List<Product> getAllProducts(){
        return product.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return product.findProductById(id);
    }

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody @Valid Product data){
        product.createProduct(data);
    }

    @PutMapping
    @Transactional
    public void updateProduct(@RequestBody @Valid ProductDTO data){
        product.updateProduct(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteProduct(@PathVariable Long id){
        product.deleteProduct(id);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public void deleteProductByLogic(@PathVariable Long id){
        product.deleteLogic(id);
    }
}
