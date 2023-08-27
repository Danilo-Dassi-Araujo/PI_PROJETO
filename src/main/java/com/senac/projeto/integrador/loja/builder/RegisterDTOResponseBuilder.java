package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.RegisterRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterDTOResponseBuilder {


    public static RegisterDTOResponse buildFrom(RegisterRequestDTO registerRequestDTO){
        return RegisterDTOResponse
                .builder()
                .email(registerRequestDTO.getEmail())
                .name(registerRequestDTO.getName())
                .cpf(registerRequestDTO.getCpf())
                .group(registerRequestDTO.getGroup())
                .build();
    }
}
