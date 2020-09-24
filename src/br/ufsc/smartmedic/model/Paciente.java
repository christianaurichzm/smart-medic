package br.ufsc.smartmedic.model;

public class Paciente extends Usuario {
    private String endereco;

    public Paciente(String nome, String sexo, int idade, String cpf, String senha, String endereco) {
        super(nome, sexo, idade, cpf, senha);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
