package com.web2.av3.repositories;

import com.web2.av3.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
