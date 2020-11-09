package br.ufsc.smartmedic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = -4225794692386296603L;
    private String nome;
    private String sexo;
    private String nascimento;
    private String cpf;
    private String senha;
    private String endereco;
    private TipoUsuario tipoUsuario;
    private List<Consulta> historicoDeConsultas;

    public Usuario(String nome, String sexo, String nascimento, String cpf, String senha, String endereco, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
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

    public String getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public boolean validar(String cpf) {
        return cpf.equals(this.cpf);
    }

    public boolean isMinor() {
        String stringAno = this.nascimento.substring(6);
        int anoNascimento = Integer.parseInt(stringAno);
        int data = Calendar.getInstance().get(Calendar.YEAR);
        int idade = data-anoNascimento;

        return idade < 18;
    }

    public boolean isElder() {
        String stringAno = this.nascimento.substring(6);
        int anoNascimento = Integer.parseInt(stringAno);
        int data = Calendar.getInstance().get(Calendar.YEAR);
        int idade = data-anoNascimento;

        return idade >= 60;
    }
}
