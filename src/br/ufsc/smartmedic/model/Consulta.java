package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 3578977060556765863L;
    private long id;
    private final FichaSintomas fichaSintomas;
    private Diagnostico diagnostico;
    private final Usuario paciente;
    private Usuario medico;
    private UnidadeAtendimento encaminhamento;
    private StatusConsulta status;

    public Consulta(FichaSintomas fichaSintomas, Usuario paciente, Usuario medico, long id) {
        this.fichaSintomas = fichaSintomas;
        this.paciente = paciente;
        this.id = id;
        this.status = StatusConsulta.PENDING;
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

    public void setMedico(Usuario medico) {
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
}
