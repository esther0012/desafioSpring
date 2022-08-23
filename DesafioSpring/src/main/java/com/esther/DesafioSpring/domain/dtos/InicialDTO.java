package com.esther.DesafioSpring.domain.dtos;

import lombok.Data;

@Data
public class InicialDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Long permissao;

    private String descPermissao;

    public String setDescPermissao() {
        return permissao == 1 ? "ADMIN" : "PADRÃO";
    }
}
