package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
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

    public static User buildFrom(User user){
        return User
                .builder()
                .email(user.getEmail())
                .name(user.getName())
                .group(user.getGroup())
                .cpf(user.getCpf())
                .password(user.getPassword())
                .isActive(user.getIsActive() ? Boolean.FALSE : Boolean.TRUE)
                .build();
    }

    public static User buildFrom(UserRequestDTO user, String email, String cpf, String passwordEncripted){
        return User
                .builder()
                .email(email)
                .name(user.getName())
                .group(user.getGroup())
                .cpf(cpf)
                .password(passwordEncripted)
                .isActive(Boolean.TRUE)
                .build();
    }
}