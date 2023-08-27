package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.RegisterDTOResponseBuilder;
import com.senac.projeto.integrador.loja.builder.UserBuilder;
import com.senac.projeto.integrador.loja.dto.request.RegisterRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegisterUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterDTOResponse registerUser(RegisterRequestDTO registerRequestDTO) throws Exception {
        if(ObjectUtils.isEmpty(registerRequestDTO)){
            throw new Exception("Request Vazia");
        }

        if(!registerRequestDTO.getPassword().equals(registerRequestDTO.getPasswordConfirmation())){
            throw new Exception("As senhas não estão iguais!");
        }
        User emailValidate = userRepository.findById(registerRequestDTO.getEmail()).orElse(null);
        User cpfValidate = userRepository.findByCpf(registerRequestDTO.getCpf());

        if(!ObjectUtils.isEmpty(emailValidate)){
            throw new Exception("Email já cadastrado!");
        }

        if(!ObjectUtils.isEmpty(cpfValidate)){
            throw new Exception("CPF já cadastrado!");
        }

        RegisterDTOResponse registerDTOResponse = RegisterDTOResponseBuilder.buildFrom(registerRequestDTO);
        String passwordEncripted = passwordEncoder.encode(registerRequestDTO.getPassword());
        User toSave = UserBuilder.buildFrom(registerDTOResponse, passwordEncripted);
        userRepository.save(toSave);
        return registerDTOResponse;
    }
}
