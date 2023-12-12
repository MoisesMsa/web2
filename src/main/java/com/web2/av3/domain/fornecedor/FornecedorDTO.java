package com.web2.av3.domain.fornecedor;

import jakarta.validation.constraints.NotNull;

public record FornecedorDTO(
        @NotNull
        Long id_fornecedor,
        String nome_fornecedor,
        String endereco,
        String telefone,
        String email,
        String cnpj
) {
}
