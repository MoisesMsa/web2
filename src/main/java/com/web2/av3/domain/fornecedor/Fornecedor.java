package com.web2.av3.domain.fornecedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web2.av3.domain.produto.Produto;
import com.web2.av3.services.FornecedorService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Fornecedor {

    public Fornecedor() { }
    public Fornecedor(Long id) {
        this.id = id;
        FornecedorService fornecedor = new FornecedorService();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "O cnpj é obrigatório")
    @Column(unique = true)
    private String cnpj;

    // Fornecedor tem vários produtos
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produto> produtos;


}

