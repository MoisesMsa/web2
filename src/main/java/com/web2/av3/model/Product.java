package com.web2.av3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "products")
@Entity(name = "Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    public Product(Product produtos){
        this.nome_produto = produtos.getNome_produto();
        this.descricao_produto = produtos.getDescricao_produto();
        this.preco_produto = produtos.getPreco_produto();
        this.data_validade = produtos.getData_validade();
        this.estoque = produtos.getEstoque();
        this.fornecedor = produtos.getFornecedor();
        this.ativo = produtos.isAtivo();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @NotBlank
    private String nome_produto;

    @NotBlank
    private String descricao_produto;
    private Float preco_produto;
    private LocalDate data_validade;
    private Integer estoque;

    @ManyToOne //vários produtos podem estar associados a um mesmo fornecedor
    @JoinColumn(name="id_fornecedor")
    private Supplier fornecedor;
    private boolean ativo;

    public void atualizarProduto(ProductDTO dados) {
        if (dados.nome_produto() != null) {
            this.nome_produto = dados.nome_produto();
        }
        if (dados.descricao_produto() != null) {
            this.descricao_produto = dados.descricao_produto();
        }
        if(dados.preco_produto() != null){
            this.preco_produto = dados.preco_produto();
        }
        if(dados.data_validade() != null){
            this.data_validade = dados.data_validade();
        }
        if(dados.estoque() != null){
            this.estoque = dados.estoque();
        }
        if(dados.fornecedor() != null){
            this.fornecedor = dados.fornecedor();
        }
    }

    public void inativar(){
        this.ativo = false;
    }
}
