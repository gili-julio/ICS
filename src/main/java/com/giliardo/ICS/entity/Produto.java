package com.giliardo.ICS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private float precoCusto;
    private float precoVenda;
    private int qtdEstoque;

    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public float getPrecoCusto() {
        return this.precoCusto;
    }

    public float getPrecoVenda() {
        return this.precoVenda;
    }

    public int getQtdEstoque() {
        return this.qtdEstoque;
    }

    public Loja getLoja() {
        return this.loja;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}
