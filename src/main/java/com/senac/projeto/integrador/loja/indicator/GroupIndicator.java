package com.senac.projeto.integrador.loja.indicator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupIndicator {

    ADMIN("Administrador"),
    ESTOQUISTA("Estoquista");

    private String groupName;
}
