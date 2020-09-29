package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.UnidadeAtendimento;

import java.util.Optional;

public class FormularioAlteracaoDeDados {
    private final String nome;
    private final String sexo;
    private final Integer idade;
    private final String senha;
    private final String endereco;
    private final String competencia;
    private final UnidadeAtendimento unidadeAtendimento;

    public FormularioAlteracaoDeDados(String nome, String sexo, Integer idade, String senha, String endereco, String competencia, UnidadeAtendimento unidadeAtendimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.senha = senha;
        this.endereco = endereco;
        this.competencia = competencia;
        this.unidadeAtendimento = unidadeAtendimento;
        this.validarCampos();
    }

    //TODO: fazer validacao de campos cpf, senha, endereco, unidade
    private void validarCampos() {
    }

    public Optional<String> getNome() {
        return Optional.ofNullable(nome);
    }

    public Optional<String> getSexo() {
        return Optional.ofNullable(sexo);
    }

    public Optional<Integer> getIdade() {
        return Optional.ofNullable(idade);
    }

    public Optional<String> getSenha() {
        return Optional.ofNullable(senha);
    }

    public Optional<String> getEndereco() {
        return Optional.ofNullable(endereco);
    }

    public Optional<String> getCompetencia() {
        return Optional.ofNullable(competencia);
    }

    public Optional<UnidadeAtendimento> getUnidadeAtendimento() {
        return Optional.ofNullable(unidadeAtendimento);
    }
}
