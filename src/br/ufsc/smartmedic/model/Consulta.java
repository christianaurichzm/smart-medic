package br.ufsc.smartmedic.model;

public class Consulta {
    private final FichaSintomas fichaSintomas;
    private final Diagnostico diagnostico;
    private final Usuario paciente;
    private final Usuario medico;
    private final UnidadeAtendimento encaminhamento;
    private StatusConsulta status;

    public Consulta(FichaSintomas fichaSintomas, Diagnostico diagnostico, Usuario paciente, Usuario medico, UnidadeAtendimento encaminhamento, StatusConsulta status) {
        this.fichaSintomas = fichaSintomas;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
        this.medico = medico;
        this.encaminhamento = encaminhamento;
        this.status = status;
    }

    public FichaSintomas getFichaSintomas() {
        return fichaSintomas;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public Usuario getMedico() {
        return medico;
    }

    public UnidadeAtendimento getEncaminhamento() {
        return encaminhamento;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}
