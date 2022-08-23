package com.esther.DesafioSpring.model;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "INICIAL")
public class Inicial {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_INICIAL", sequenceName = "SQ_INICIAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INICIAL")
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "ID_PERMISSAO" )
    private Long permissao;

    @Column(name = "RESET")
    private String reset;

}
