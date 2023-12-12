package com.web2.av3.domain.produto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web2.av3.domain.categoria.Categoria;
import com.web2.av3.domain.fornecedor.Fornecedor;
import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
@Data
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "data_validade", length = 15)
    private String dataValidade;

    @Column(name = "estoque")
    private Integer estoque;

    @Column(name = "ativo")
    private Integer ativo;

    // Produto tem 1 fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

//    @ManyToMany(mappedBy = "produtos")
//    private Set<Categoria> categorias = new HashSet<>();
}

