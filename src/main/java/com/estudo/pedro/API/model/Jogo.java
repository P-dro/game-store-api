
package com.estudo.pedro.API.model;

import com.estudo.pedro.API.repository.JogoRepository;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Date;

@Entity
public class Jogo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty
    private Long valor;
    private Date data_cadastro = new Date();
    private String grupos_console;
    private String observacoes;
    private Boolean ativo = true;

    public Jogo() {

    }

    public Jogo(String titulo, Long valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {return titulo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getGrupos_console() {
        return grupos_console;
    }

    public void setGrupos_console(String grupos_console) {
        this.grupos_console = grupos_console;
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

