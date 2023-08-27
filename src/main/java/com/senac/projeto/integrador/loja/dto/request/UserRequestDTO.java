package com.senac.projeto.integrador.loja.dto.request;

import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @ApiParam("Email")
    private String email;

    @ApiParam("Nome")
    private String name;

    @ApiParam("Senha")
    private String password;

    @ApiParam("Confirmar senha")
    private String passwordConfirmation;

    @ApiParam("CPF")
    private String cpf;

    @ApiParam("Grupo")
    @Enumerated(EnumType.STRING)
    private GroupIndicator group;
}
