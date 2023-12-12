package com.web2.av3.controllers;

import com.web2.av3.domain.produto.Produto;
import com.web2.av3.domain.produto.ProductDTO;
import com.web2.av3.services.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductoController {
    @Autowired
    ProdutoService product;

    @GetMapping
    public List<Produto> getAllProducts(){
        return product.getAllProducts();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id){
        return product.findProductById(id);
    }

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody @Valid Produto data){
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
