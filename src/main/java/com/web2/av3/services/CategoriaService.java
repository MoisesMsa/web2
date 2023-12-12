package com.web2.av3.services;

import com.web2.av3.domain.categoria.Categoria;
import com.web2.av3.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
