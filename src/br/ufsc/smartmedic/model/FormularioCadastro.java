package br.ufsc.smartmedic.model;

import java.util.List;
import java.util.Optional;

public class FormularioCadastro {

    private final String nome;
    private final String sexo;
    private final int idade;
    private final String cpf;
    private final String senha;
    private final String endereco;
    private final String crm;
    private final String competencia;
    private final UnidadeDeAtendimento unidadeDeAtendimento;

    public FormularioCadastro(String nome, String sexo, int idade, String cpf, String senha, String endereco, String crm, String competencia, UnidadeDeAtendimento unidadeDeAtendimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.crm = crm;
        this.competencia = competencia;
        this.unidadeDeAtendimento = unidadeDeAtendimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public Optional<String> getEndereco() {
        return Optional.ofNullable(endereco);
    }

    public Optional<String> getCrm() {
        return Optional.ofNullable(crm);
    }

    public Optional<String> getCompetencia() {
        return Optional.ofNullable(competencia);
    }

    public Optional<UnidadeDeAtendimento> getUnidadeDeAtendimento() {
        return Optional.ofNullable(unidadeDeAtendimento);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public void setUnidadeDeAtendimento(UnidadeDeAtendimento unidadeDeAtendimento) {
        this.unidadeDeAtendimento = unidadeDeAtendimento;
    }
}
