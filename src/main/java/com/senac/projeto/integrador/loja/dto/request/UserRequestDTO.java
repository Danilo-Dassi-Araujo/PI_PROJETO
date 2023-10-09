package com.senac.projeto.integrador.loja.dto.request;

import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String email;
    private String name;
    private String password;
    private String passwordConfirmation;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private GroupIndicator group;
}
