package ufsc.br;

import java.util.List;

public class Paciente extends User {

    public Paciente(String nome, String sexo, int idade, String cpf, String senha, List<Consulta> historicoDeConsultas) {
        super(nome, sexo, idade, cpf, senha, historicoDeConsultas);
    }
}
