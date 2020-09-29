package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.UnidadeAtendimento;
import br.ufsc.smartmedic.model.excecoes.FormException;

import java.util.Optional;

public class FormularioAlteracaoDeDados {
    private final String nome;
    private final String sexo;
    private final String nascimento;
    private final String senha;
    private final String endereco;
    private final String competencia;
    private final String unidadeAtendimento;

    public FormularioAlteracaoDeDados(String nome, String sexo, String nascimento, String senha, String endereco, String competencia, String unidadeAtendimento) throws FormException {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.senha = senha;
        this.endereco = endereco;
        this.competencia = competencia;
        this.unidadeAtendimento = unidadeAtendimento;
        this.validarCampos();
    }

    private void validarCampos() throws FormException {
        if (this.getSenha().isPresent()) {
            this.validarSenha();
        }
    }

    private void validarSenha() throws FormException {
        if (!this.getSenha().get().matches("^[a-zA-Z0-9]{4,12}$")) {
            throw new FormException("A senha só pode consistir de caracteres alfanuméricos");
        }
    }

    public Optional<String> getNome() {
        return Optional.ofNullable(nome);
    }

    public Optional<String> getSexo() {
        return Optional.ofNullable(sexo);
    }

    public Optional<String> getNascimento() {
        return Optional.ofNullable(nascimento);
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

    public Optional<String> getUnidadeAtendimento() {
        return Optional.ofNullable(unidadeAtendimento);
    }
}
