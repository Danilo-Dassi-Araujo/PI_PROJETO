package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterDTOResponseBuilder {


    public static RegisterDTOResponse buildFrom(UserRequestDTO userRequestDTO){
        return RegisterDTOResponse
                .builder()
                .email(userRequestDTO.getEmail())
                .name(userRequestDTO.getName())
                .cpf(userRequestDTO.getCpf())
                .group(userRequestDTO.getGroup())
                .build();
    }
}
