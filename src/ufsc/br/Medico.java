package ufsc.br;

import java.util.List;

public class Medico extends User{

    private String crm;
    private String competencia;
    private List<Consulta> consultas;
    private UnidadeDeAtendimento unidadeDeAtendimento;

    public Medico(String nome, String sexo, int idade, String cpf, String senha, List<Consulta> historicoDeConsultas, String crm, String competencia, List<Consulta> consultas, UnidadeDeAtendimento unidadeDeAtendimento) {
        super(nome, sexo, idade, cpf, senha, historicoDeConsultas);
        this.crm = crm;
        this.competencia = competencia;
        this.consultas = consultas;
        this.unidadeDeAtendimento = unidadeDeAtendimento;
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
