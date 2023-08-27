package com.senac.projeto.integrador.loja.model;

import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USUARIO", schema = "PUBLIC")
public class User {

    @Id
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NOME")
    private String name;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "GRUPO")
    private GroupIndicator group;

    @Column(name = "ATIVO")
    private Boolean isActive;
}
