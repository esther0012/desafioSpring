package com.esther.DesafioSpring.domain.enumeration;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public enum Permissao {

    ADMIN(1, "ADMIN"),
    PADRAO(2, "USUÁRIO PADRAO");

    private Integer codigo;
    private String descricao;

    Permissao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

}
