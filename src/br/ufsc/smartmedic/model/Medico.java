package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class Medico extends Usuario implements Serializable {
    private String crm;
    private String competencia;
    private UnidadeAtendimento unidadeAtendimento;

    public Medico(String nome, String sexo, String nascimento, String cpf, String senha, String endereco, String crm, String competencia, UnidadeAtendimento unidadeAtendimento) {
        super(nome, sexo, nascimento, cpf, senha, endereco, TipoUsuario.MEDICO);
        this.crm = crm;
        this.competencia = competencia;
        this.unidadeAtendimento = unidadeAtendimento;
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

    public UnidadeAtendimento getUnidadeAtendimento() {
        return unidadeAtendimento;
    }

    public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
        this.unidadeAtendimento = unidadeAtendimento;
    }
}
