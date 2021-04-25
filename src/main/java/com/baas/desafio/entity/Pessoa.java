package com.baas.desafio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pessoa {

    @Id
    private Long idPessoa;
    private String nome;
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    public Pessoa() {
    }


    public Pessoa(Long idPessoa, String nome, String cpf, Date dataNascimento) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}