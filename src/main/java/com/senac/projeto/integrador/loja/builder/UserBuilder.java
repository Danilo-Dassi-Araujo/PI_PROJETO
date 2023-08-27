package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserBuilder {

    public static User buildFrom(RegisterDTOResponse response, String passwordEncripted){
        return User
                .builder()
                .email(response.getEmail())
                .password(passwordEncripted)
                .name(response.getName())
                .cpf(response.getCpf())
                .group(response.getGroup())
                .isActive(Boolean.TRUE)
                .build();
    }
}