package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.UserBuilder;
import com.senac.projeto.integrador.loja.dto.request.EmailDTORequest;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import com.senac.projeto.integrador.loja.utils.ValidatorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class InactiveAndActiveUserService {

    private final UserRepository userRepository;

    public void inactiveOrActiveUser(EmailDTORequest email) throws Exception {
        ValidatorUtils.validateEmailRequest(email);
        User user = userRepository.findById(email.getEmail()).orElse(null);

        if(ObjectUtils.isEmpty(user)){
            throw new Exception("Usuário não encontrado");
        }

        User toSave = UserBuilder.buildFrom(user);
        userRepository.save(toSave);
    }
}