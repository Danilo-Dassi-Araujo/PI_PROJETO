package com.senac.projeto.integrador.loja.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PRODUTOS", schema = "PUBLIC")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_do_produto", length = 200, nullable = false)
    private String nameProduct;

    @Column(name = "descricao", length = 2000, nullable = false)
    private String descriptionProduct;

    @Column(name= "avaliacao",nullable = false)
    private Double assessmentProduct;

    @Column(name = "preco_produto", precision = 10, scale = 2, nullable = false)
    private Double priceProduct;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer stockQuantity;

    @Column(name = "is_ativo", nullable = false)
    private Boolean isActive;
}
