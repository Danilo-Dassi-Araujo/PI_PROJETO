package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.dto.response.UpdateDTOResponse;
import com.senac.projeto.integrador.loja.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateDTOResponseBuilder {

    public static UpdateDTOResponse buildFrom(User user){
        return UpdateDTOResponse
                .builder()
                .email(user.getEmail())
                .name(user.getName())
                .cpf(user.getCpf())
                .group(user.getGroup())
                .build();
    }
}
