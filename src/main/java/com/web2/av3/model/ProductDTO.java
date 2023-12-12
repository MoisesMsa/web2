package com.web2.av3.model;

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
        Supplier fornecedor,
        boolean ativo
) {
}
