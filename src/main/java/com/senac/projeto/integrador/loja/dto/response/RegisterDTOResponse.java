package com.senac.projeto.integrador.loja.dto.response;

import com.senac.projeto.integrador.loja.indicator.GroupIndicator;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTOResponse {

    private String email;
    private String name;
    private String cpf;
    private GroupIndicator group;
}
