package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.model.Client;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ClientBuilder {

    public static Client buildFrom(){
        return Client
                .builder()
                .email("")
                .nomeCompleto("")
                .dataNascimento(LocalDate.MAX)
                .genero("")
                .build();
    }
}
