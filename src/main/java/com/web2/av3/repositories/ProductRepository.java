package com.web2.av3.repositories;

import com.web2.av3.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByAtivoTrue();
}
