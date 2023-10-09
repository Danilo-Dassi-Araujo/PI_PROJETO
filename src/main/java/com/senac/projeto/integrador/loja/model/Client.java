package com.senac.projeto.integrador.loja.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CLIENTE", schema = "PUBLIC")
public class Client {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "data_de_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "genero")
    private String genero;

}
