package com.senac.projeto.integrador.loja.builder;

import com.senac.projeto.integrador.loja.dto.request.ClientRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterClientDTOResponse;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class RegisterClientDTOResponseBuilder {

    public static RegisterClientDTOResponse buildFrom(ClientRequestDTO clientRequestDTO){
        return RegisterClientDTOResponse
                .builder()
                .email(clientRequestDTO.getEmail())
                .nomeCompleto(clientRequestDTO.getNomeCompleto())
                .dataNascimento(clientRequestDTO.getDataNascimento())
                .genero(clientRequestDTO.getGenero())
                .build();
    }
}
