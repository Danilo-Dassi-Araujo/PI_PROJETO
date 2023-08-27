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
