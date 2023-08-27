package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.UpdateDTOResponseBuilder;
import com.senac.projeto.integrador.loja.builder.UserBuilder;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.UpdateDTOResponse;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import com.senac.projeto.integrador.loja.utils.ValidatorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class UpdateUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UpdateDTOResponse updateUser(UserRequestDTO userRequestDTO, String login) throws Exception {
        ValidatorUtils.validateRequest(userRequestDTO);

        User user = userRepository.findById(userRequestDTO.getEmail()).orElse(null);

        if(ObjectUtils.isEmpty(user)){
            throw new Exception("Usuário não encontrado");
        }
        if(login.equals(user.getEmail())){
            throw new Exception("Alteração de grupo para usuários próprios, não é permitida");
        }

        String passwordEncripted = passwordEncoder.encode(userRequestDTO.getPassword());

        User toSave = UserBuilder.buildFrom(userRequestDTO, user.getEmail(), user.getCpf(), passwordEncripted);
        userRepository.save(toSave);

        return UpdateDTOResponseBuilder.buildFrom(toSave);
    }

}
