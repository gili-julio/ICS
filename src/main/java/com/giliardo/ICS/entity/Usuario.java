package com.giliardo.ICS.entity;

import com.giliardo.ICS.enums.NivelUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private NivelUsuario nivel;

    @ManyToOne
    @JoinColumn(name = "cargo_nome")
    private Cargo cargo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public NivelUsuario getNivel() {
        return this.nivel;
    }

    public void setNivel(NivelUsuario nivel) {
        this.nivel = nivel;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
