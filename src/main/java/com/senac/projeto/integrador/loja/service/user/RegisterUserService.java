package com.senac.projeto.integrador.loja.service.user;

import com.senac.projeto.integrador.loja.builder.RegisterDTOResponseBuilder;
import com.senac.projeto.integrador.loja.builder.UserBuilder;
import com.senac.projeto.integrador.loja.dto.request.UserRequestDTO;
import com.senac.projeto.integrador.loja.dto.response.RegisterDTOResponse;
import com.senac.projeto.integrador.loja.model.User;
import com.senac.projeto.integrador.loja.repository.UserRepository;
import com.senac.projeto.integrador.loja.utils.ValidaCpf;
import com.senac.projeto.integrador.loja.utils.ValidatorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class RegisterUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterDTOResponse registerUser(UserRequestDTO userRequestDTO) throws Exception {
        ValidatorUtils.validateRequest(userRequestDTO);
        boolean cpf = ValidaCpf.isCPF(userRequestDTO.getCpf());

        if (Boolean.FALSE.equals(cpf)) {
            throw new Exception("CPF inválido");
        }

        User emailValidate = userRepository.findById(userRequestDTO.getEmail()).orElse(null);
        User cpfValidate = userRepository.findByCpf(userRequestDTO.getCpf());

        if (!ObjectUtils.isEmpty(emailValidate)) {
            throw new Exception("Email já cadastrado!");
        }

        if (!ObjectUtils.isEmpty(cpfValidate)) {
            throw new Exception("CPF já cadastrado!");
        }

        RegisterDTOResponse registerDTOResponse = RegisterDTOResponseBuilder.buildFrom(userRequestDTO);
        String passwordEncripted = passwordEncoder.encode(userRequestDTO.getPassword());
        User toSave = UserBuilder.buildFrom(registerDTOResponse, passwordEncripted);
        userRepository.save(toSave);
        return registerDTOResponse;
    }
}
