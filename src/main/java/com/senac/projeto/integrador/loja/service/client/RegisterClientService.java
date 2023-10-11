package com.senac.projeto.integrador.loja.service.client;

import com.senac.projeto.integrador.loja.builder.ClientBuilder;
import com.senac.projeto.integrador.loja.builder.RegisterClientDTOResponseBuilder;
import com.senac.projeto.integrador.loja.builder.RegisterDTOResponseBuilder;
import com.senac.projeto.integrador.loja.dto.request.ClientRequestDTO;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterClientDTOResponse;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.model.Client;
import com.senac.projeto.integrador.loja.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class RegisterClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterClientDTOResponse registerClient(ClientRequestDTO clientRequestDTO) throws Exception {

        Client emailValidate = clientRepository.findById(clientRequestDTO.getEmail()).orElse(null);

        if (!ObjectUtils.isEmpty(emailValidate)) {
            throw new Exception("Email já cadastrado!");
        }

        RegisterClientDTOResponse registerDTOResponse = RegisterClientDTOResponseBuilder.buildFrom(clientRequestDTO);
        String passwordEncripted = passwordEncoder.encode(clientRequestDTO.getPassword());
        Client toSave = ClientBuilder.buildFrom();
        clientRepository.save(toSave);
        return registerDTOResponse;
    }
}