package com.web2.av3.domain.produto;

import com.web2.av3.domain.fornecedor.Fornecedor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProductDTO(
        @NotNull
        Long id_produto,
        String nome_produto,
        String descricao_produto,
        Float preco_produto,
        LocalDate data_validade,
        Integer estoque,
        Fornecedor fornecedor,
        boolean ativo
) {
}
