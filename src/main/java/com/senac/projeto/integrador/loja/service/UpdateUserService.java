package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.builder.UpdateDTOResponseBuilder;
import com.senac.projeto.integrador.loja.builder.UserBuilder;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.UpdateDTOResponse;
import com.senac.projeto.integrador.loja.model.SessionClientStore;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.SessionRepository;
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
    private final SessionRepository sessionRepository;

    public UpdateDTOResponse updateUser(UserRequestDTO userRequestDTO) throws Exception {
        ValidatorUtils.validateRequest(userRequestDTO);

        User user = userRepository.findById(userRequestDTO.getEmail()).orElse(null);

        if(ObjectUtils.isEmpty(user)){
            throw new Exception("Usuário não encontrado");
        }

        String passwordEncripted = passwordEncoder.encode(userRequestDTO.getPassword());

        User toSave = UserBuilder.buildFrom(userRequestDTO, user.getEmail(), user.getCpf(), passwordEncripted);

        SessionClientStore userSessionClientStore = sessionRepository.findFirstByOrderByIdDesc();

        if(toSave.getEmail().equals(userSessionClientStore.getLogin())){
            throw new Exception("Alteração de grupo para usuários logado no momento não é permitida!");
        }
        userRepository.save(toSave);

        return UpdateDTOResponseBuilder.buildFrom(toSave);
    }

}
