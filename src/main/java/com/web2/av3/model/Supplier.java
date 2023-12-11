package com.web2.av3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "suppliers")
@Entity(name = "Suppliers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Supplier {

    public Supplier(Supplier supplier){
        this.nome_fornecedor = supplier.getNome_fornecedor();
        this.endereco = supplier.getEndereco();
        this.telefone = supplier.getTelefone();
        this.email = supplier.getEmail();
        this.cnpj = supplier.getCnpj();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fornecedor;

    @NotBlank
    private String nome_fornecedor;
    private String endereco;
    private String telefone;
    private String email;

    @NotNull
    private String cnpj;

    public void atualizarFornecedor(SupplierDTO dados) {
        if (dados.nome_fornecedor() != null) {
            this.nome_fornecedor = dados.nome_fornecedor();
        }
        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.cnpj() != null){
            this.cnpj = dados.cnpj();
        }
    }
}
