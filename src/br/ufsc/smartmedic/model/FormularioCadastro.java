package br.ufsc.smartmedic.model;

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
        this.validarCampos();
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

    private void validarCampos() {

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
}
