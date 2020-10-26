package br.ufsc.smartmedic.model;

public class Consulta {
    private final FichaSintomas fichaSintomas;
    private Diagnostico diagnostico;
    private final Usuario paciente;
    private final Usuario medico;
    private UnidadeAtendimento encaminhamento;
    private StatusConsulta status;

    public Consulta(FichaSintomas fichaSintomas, Usuario paciente, Usuario medico) {
        this.fichaSintomas = fichaSintomas;
        this.paciente = paciente;
        this.medico = medico;
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

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}
