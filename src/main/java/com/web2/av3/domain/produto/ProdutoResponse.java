package com.web2.av3.domain.produto;

import lombok.Getter;
import lombok.Setter;

import com.web2.av3.domain.fornecedor.Fornecedor;
@Getter
@Setter
public class ProdutoResponse {

    public ProdutoResponse(Produto produto, Fornecedor fornecedor) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.ativo = produto.getAtivo();
        this.descricao = produto.getDescricao();
        this.dataValidade = produto.getDataValidade();
        this.estoque = produto.getEstoque();
        this.FornecedorId = fornecedor.getId();
        this.Fornecedor = fornecedor.getNome();
    }

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.ativo = produto.getAtivo();
        this.descricao = produto.getDescricao();
        this.dataValidade = produto.getDataValidade();
        this.estoque = produto.getEstoque();
        this.Fornecedor = produto.getFornecedor().getNome();
        this.FornecedorId = produto.getFornecedor().getId();
    }

    private Long id;
    private String nome;
    private String descricao;
    private String dataValidade;
    private Integer ativo;
    private Integer estoque;
    private Long FornecedorId;
    private String Fornecedor;
}
