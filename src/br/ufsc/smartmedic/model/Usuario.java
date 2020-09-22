package br.ufsc.smartmedic.model;

import java.util.List;

public class Usuario {

    private String nome;
    private String sexo;
    private int idade;
    private String cpf;
    private String senha;

    public Usuario(String nome, String sexo, int idade, String cpf, String senha, List<Consulta> historicoDeConsultas) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
        this.historicoDeConsultas = historicoDeConsultas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Consulta> getHistoricoDeConsultas() {
        return historicoDeConsultas;
    }

    public void setHistoricoDeConsultas(List<Consulta> historicoDeConsultas) {
        this.historicoDeConsultas = historicoDeConsultas;
    }
}
