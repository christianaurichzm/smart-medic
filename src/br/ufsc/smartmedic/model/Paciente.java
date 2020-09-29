package br.ufsc.smartmedic.model;

public class Paciente extends Usuario {
    public Paciente(String nome, String sexo, int idade, String cpf, String senha, String endereco) {
        super(nome, sexo, idade, cpf, senha, endereco, TipoUsuario.PACIENTE);
    }
}
