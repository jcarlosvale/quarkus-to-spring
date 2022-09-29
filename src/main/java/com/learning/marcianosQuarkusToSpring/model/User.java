package com.learning.marcianosQuarkusToSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="cpf", unique = true)
    private String cpf;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "titular")
    @JoinColumn(name = "contaDoUsuario")
    Conta contaDoUsuario;
}
