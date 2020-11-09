package br.ufsc.smartmedic.model;

import java.io.Serializable;
import java.util.Date;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 4329995520118258654L;
    private long id;
    private final FichaSintomas fichaSintomas;
    private Diagnostico diagnostico;
    private final Usuario paciente;
    private Medico medico;
    private UnidadeAtendimento encaminhamento;
    private StatusConsulta status;
    private final Date data;

    public Consulta(FichaSintomas fichaSintomas, Usuario paciente, Medico medico, long id) {
        this.fichaSintomas = fichaSintomas;
        this.paciente = paciente;
        this.medico = medico;
        this.id = id;
        this.status = StatusConsulta.PENDING;
        this.data = new Date();
    }

    public FichaSintomas getFichaSintomas() {
        return this.fichaSintomas;
    }

    public Diagnostico getDiagnostico() {
        return this.diagnostico;
    }

    public Usuario getPaciente() {
        return this.paciente;
    }

    public Usuario getMedico() {
        return this.medico;
    }

    public UnidadeAtendimento getEncaminhamento() {
        return this.encaminhamento;
    }

    public StatusConsulta getStatus() {
        return this.status;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setEncaminhamento(UnidadeAtendimento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
}
