package com.web2.av3.model;

import jakarta.validation.constraints.NotNull;

public record SupplierDTO(
        @NotNull
        Long id_fornecedor,
        String nome_fornecedor,
        String endereco,
        String telefone,
        String email,
        String cnpj
) {
}
