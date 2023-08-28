package com.senac.projeto.integrador.loja.filter;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ControllerFilter {

    @ApiParam("Nome")
    private String name;
}
