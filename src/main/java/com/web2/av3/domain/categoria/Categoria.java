package com.web2.av3.domain.categoria;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Timestamp;
import com.web2.av3.domain.produto.Produto;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

//    @ManyToMany
//    @JoinTable(
//            name = "produto_categoria",
//            joinColumns = @JoinColumn(name = "categoria_id"),
//            inverseJoinColumns = @JoinColumn(name = "produto_id")
//    )
//    private Set<Produto> produtos = new HashSet<>();
}

