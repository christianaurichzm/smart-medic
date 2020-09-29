package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.TipoUsuario;

public class FormularioCadastro {
    private final String cpf;
    private final String nome;
    private final String sexo;
    private final String senha;
    private final String nascimento;
    private final String endereco;
    private final TipoUsuario tipoUsuario;

    public FormularioCadastro(String cpf, String nome, String sexo, String senha, String nascimento, String endereco, TipoUsuario tipoUsuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.senha = senha;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getNascimento() {
        return this.nascimento;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCpf() {
        return this.cpf;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
