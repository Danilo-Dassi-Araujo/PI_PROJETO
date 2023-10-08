package com.senac.projeto.integrador.loja.service;

import com.senac.projeto.integrador.loja.dto.request.LoginRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.LoginDTOResponse;
import com.senac.projeto.integrador.loja.model.Session;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.SessionRepository;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SessionRepository sessionRepository;

    public LoginDTOResponse loginUser(LoginRequestDTO loginRequestDTO) throws Exception {
        if (ObjectUtils.isEmpty(loginRequestDTO)) {
            throw new Exception("Preencha os campos!");
        }

        User user = userRepository.findById(loginRequestDTO.getEmail()).orElse(null);

        if (ObjectUtils.isEmpty(user)) {
            return LoginDTOResponse
                    .builder()
                    .message("Acesso negado! Usuário não cadastrado!")
                    .isPermission(Boolean.FALSE)
                    .build();
        }
        Boolean isSame = verifyPassword(loginRequestDTO.getPassword(), user);

        if (!isSame) {
            return LoginDTOResponse
                    .builder()
                    .message("Acesso negado! Senha incorreta!")
                    .isPermission(Boolean.FALSE)
                    .build();
        }

        Session session = Session.builder()
                .login(user.getEmail())
                .role(user.getGroup().getGroupName())
                .build();

        sessionRepository.save(session);

        return LoginDTOResponse
                .builder()
                .message("Acesso concedido!")
                .isPermission(Boolean.TRUE)
                .build();
    }

    private Boolean verifyPassword(String password, User user) {
        return passwordEncoder.matches(password, user.getPassword());
    }
}
