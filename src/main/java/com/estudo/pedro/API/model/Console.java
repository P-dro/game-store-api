
package com.estudo.pedro.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Console {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String consoles;
    private double valor;
    private Date data_cadastro;
    private String observacoes;
    private Boolean ativo;

    public Console() {

    }

    public Console(String consoles, double valor, Date data_cadastro, String observacoes, Boolean ativo) {
        this.consoles = consoles;
        this.valor = valor;
        this.data_cadastro = data_cadastro;
        this.observacoes = observacoes;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsoles() {
        return consoles;
    }

    public void setConsoles(String consoles) {
        this.consoles = consoles;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

