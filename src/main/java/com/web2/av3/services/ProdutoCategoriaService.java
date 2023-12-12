package com.web2.av3.services;

import com.web2.av3.domain.categoria.Categoria;
import com.web2.av3.domain.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web2.av3.repositories.ProdutoRepository;
import com.web2.av3.repositories.CategoriaRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProdutoCategoriaService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

//    public Produto salvarProdutoComCategorias(Produto produto, Set<Long> categoriaIds) {
//        Set<Categoria> categorias = (Set<Categoria>) categoriaRepository.findAllById(categoriaIds);
//        produto.setCategorias(categorias);
//        return produtoRepository.save(produto);
//    }
//
//    public Set<Categoria> obterCategoriasDeProduto(Long produtoId) {
//        Produto produto = produtoRepository.findById(produtoId).orElse(null);
//        return produto != null ? produto.getCategorias() : new HashSet<>();
//    }

}
