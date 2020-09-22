package ufsc.br;

public class Consulta {
    private final FichaDeSintomas fichaDeSintomas;
    private final Diagnostico diagnostico;
    private final User paciente;
    private final User medico;
    private final UnidadeDeAtendimento encaminhamento;
    private StatusConsulta status;

    public Consulta(FichaDeSintomas fichaDeSintomas, Diagnostico diagnostico, User paciente, User medico, UnidadeDeAtendimento encaminhamento, StatusConsulta status) {
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

    public User getPaciente() {
        return paciente;
    }

    public User getMedico() {
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
