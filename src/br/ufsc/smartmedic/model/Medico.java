package br.ufsc.smartmedic.model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Usuario {
    private String crm;
    private String competencia;
    private UnidadeDeAtendimento unidadeDeAtendimento;
    private List<Consulta> consultas;

    public Medico(String nome, String sexo, int idade, String cpf, String senha, String endereco, String crm, String competencia, UnidadeDeAtendimento unidadeDeAtendimento) {
        super(nome, sexo, idade, cpf, senha, endereco);
        this.crm = crm;
        this.competencia = competencia;
        this.unidadeDeAtendimento = unidadeDeAtendimento;
        this.consultas = new ArrayList<>();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public UnidadeDeAtendimento getUnidadeDeAtendimento() {
        return unidadeDeAtendimento;
    }

    public void setUnidadeDeAtendimento(UnidadeDeAtendimento unidadeDeAtendimento) {
        this.unidadeDeAtendimento = unidadeDeAtendimento;
    }
}
