package br.ufsc.smartmedic.model;

import java.util.List;

public class Paciente extends Usuario {

    public Paciente(String nome, String sexo, int idade, String cpf, String senha, List<Consulta> historicoDeConsultas) {
        super(nome, sexo, idade, cpf, senha, historicoDeConsultas);
    }
}
