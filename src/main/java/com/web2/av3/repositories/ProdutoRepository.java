package com.web2.av3.repositories;

import com.web2.av3.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.ativo = 1")
    List<Produto> findAllAtivos();

    @Query("SELECT p FROM Produto p WHERE p.ativo = 1 AND p.id = :produtoId")
    Optional<Produto> getActiveProdutoById(@Param("produtoId") Long produtoId);

    List<Produto> findByFornecedorId(Long fornecedorId);
}