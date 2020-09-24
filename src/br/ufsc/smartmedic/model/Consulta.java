package br.ufsc.smartmedic.model;

public class Consulta {
    private final FichaDeSintomas fichaDeSintomas;
    private final Diagnostico diagnostico;
    private final Usuario paciente;
    private final Usuario medico;
    private final UnidadeDeAtendimento encaminhamento;
    private StatusConsulta status;

    public Consulta(FichaDeSintomas fichaDeSintomas, Diagnostico diagnostico, Usuario paciente, Usuario medico, UnidadeDeAtendimento encaminhamento, StatusConsulta status) {
        this.fichaDeSintomas = fichaDeSintomas;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
        this.medico = medico;
        this.encaminhamento = encaminhamento;
        this.status = status;
    }

    public FichaDeSintomas getFichaDeSintomas() {
        return fichaDeSintomas;
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

    public UnidadeDeAtendimento getEncaminhamento() {
        return encaminhamento;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}
