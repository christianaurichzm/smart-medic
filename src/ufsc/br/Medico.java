package ufsc.br;

import java.util.List;

public class Medico extends User{

    private String crm;
    private String competencia;
    private List consultas;
    //private UnidadeDeAtendimento unidadeDeAtendimento;

    public Medico() {
        this.crm = crm;
        this.competencia = competencia;
        this.consultas = consultas;
        //this.UnidadeDeAtendimento unidadeDeAtendimento;
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

    public List getConsultas() {
        return consultas;
    }

    public void setConsultas(List consultas) {
        this.consultas = consultas;
    }
}
