package br.ufsc.smartmedic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Serializable {
    private String nome;
    private String sexo;
    private Integer idade;
    private String cpf;
    private String senha;
    private String endereco;
    private TipoUsuario tipoUsuario;
    private List<Consulta> historicoDeConsultas;

    public Usuario(String nome, String sexo, int idade, String cpf, String senha, String endereco, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
        this.historicoDeConsultas = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Consulta> getHistoricoDeConsultas() {
        return this.historicoDeConsultas;
    }

    public void setHistoricoDeConsultas(List<Consulta> historicoDeConsultas) {
        this.historicoDeConsultas = historicoDeConsultas;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public boolean validar(String cpf, String senha) {
        return cpf.equals(this.cpf)
            && senha.equals(this.senha);
    }
}
