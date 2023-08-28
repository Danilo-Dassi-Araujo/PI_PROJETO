package com.senac.projeto.integrador.loja.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTOResponse {

    private String message;
    private Boolean isPermission;
}
