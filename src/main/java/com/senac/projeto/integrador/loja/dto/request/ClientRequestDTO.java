package com.senac.projeto.integrador.loja.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

    private String email;
    private String nomeCompleto;
    private String password;
    private String passwordConfirmation;
    private String genero;
    private LocalDate dataNascimento;
}
