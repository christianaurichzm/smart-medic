package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable {
    public Paciente(String nome, String sexo, String nascimento, String cpf, String senha, String endereco) {
        super(nome, sexo, nascimento, cpf, senha, endereco, TipoUsuario.PACIENTE);
    }
}
