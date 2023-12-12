package com.web2.av3.services;

import com.web2.av3.domain.produto.Produto;
import com.web2.av3.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAllAtivos();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.getActiveProdutoById(id);
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> getProdutosByFornecedor(Long fornecedorId) {
        return produtoRepository.findByFornecedorId(fornecedorId);
    }
}