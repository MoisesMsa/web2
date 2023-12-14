package com.web2.av3.controllers;

import com.web2.av3.domain.produto.Produto;
import com.web2.av3.domain.produto.ProdutoResponse;
import com.web2.av3.domain.fornecedor.Fornecedor;
import com.web2.av3.repositories.FornecedorRepository;
import com.web2.av3.repositories.ProdutoRepository;
import com.web2.av3.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoResponse> produtoResponses = produtos.stream()
                .map(produto -> new ProdutoResponse(produto))
                .collect(Collectors.toList());

        return ResponseEntity.ok(produtoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id)
                .map(produto -> new ResponseEntity<>(produto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody Produto produto) {
        Long fornecedorId = produto.getFornecedor().getId();
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId).orElse(null);

        if (fornecedor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        produto.setFornecedor(fornecedor);

        Produto novoProduto = produtoService.saveProduto(produto);

        ProdutoResponse produtoResponse = new ProdutoResponse(novoProduto, fornecedor);

        return ResponseEntity.ok(produtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.getProdutoById(id)
                .map(existingProduto -> {
                    produto.setId(id);
                    Produto produtoAtualizado = produtoService.saveProduto(produto);
                    return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable Long id, @RequestParam(name = "logic", defaultValue = "false") boolean logic) {
        return produtoService.getProdutoById(id)
                .map(existingProduto -> {

                    if(logic) {
                        existingProduto.setAtivo(0);
                        produtoService.saveProduto(existingProduto);
                    } else {
                        produtoService.deleteProduto(id);
                    }

                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/fornecedor/{fornecedorId}")
    public ResponseEntity<List<ProdutoResponse>> listarProdutosPorFornecedor(@PathVariable Long fornecedorId) {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoResponse> produtoResponses = produtos.stream()
                .filter(produto -> produto.getFornecedor().getId().equals(fornecedorId))
                .map(produto -> new ProdutoResponse(produto))
                .collect(Collectors.toList());

        return ResponseEntity.ok(produtoResponses);
    }
}
