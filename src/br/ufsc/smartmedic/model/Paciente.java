package br.ufsc.smartmedic.model;

public class Paciente extends Usuario {
    public Paciente(String nome, String sexo, String nascimento, String cpf, String senha, String endereco) {
        super(nome, sexo, nascimento, cpf, senha, endereco, TipoUsuario.PACIENTE);
    }
}
