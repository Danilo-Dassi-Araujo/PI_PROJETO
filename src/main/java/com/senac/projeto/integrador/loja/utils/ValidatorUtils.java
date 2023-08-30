package com.senac.projeto.integrador.loja.utils;

import com.senac.projeto.integrador.loja.dto.request.EmailDTORequest;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class ValidatorUtils {

    public static void validateRequest(UserRequestDTO requestDTO) throws Exception {
        if(ObjectUtils.isEmpty(requestDTO)){
            throw new Exception("A request está vazia!");
        }

        if(ObjectUtils.isEmpty(requestDTO.getEmail())){
            throw new Exception("O email está vazio!");
        }

        if(ObjectUtils.isEmpty(requestDTO.getName())){
            throw new Exception("O nome está vazio!");
        }

        if(ObjectUtils.isEmpty(requestDTO.getCpf())){
            throw new Exception("O cpf está vazio!");
        }

        if(ObjectUtils.isEmpty(requestDTO.getPassword())){
            throw new Exception("O senha está vazia!");
        }

        if(ObjectUtils.isEmpty(requestDTO.getPasswordConfirmation())){
            throw new Exception("O confirmação de senha está vazia!");
        }

        if(!requestDTO.getPassword().equals(requestDTO.getPasswordConfirmation())){
            throw new Exception("As senhas não estão iguais!");
        }
    }
    public static void validateEmailRequest(EmailDTORequest emailDTORequest) throws Exception {
        if(ObjectUtils.isEmpty(emailDTORequest)){
            throw new Exception("Request Vazia!");
        }
    }
}
