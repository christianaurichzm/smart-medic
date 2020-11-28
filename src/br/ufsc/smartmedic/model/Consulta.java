package br.ufsc.smartmedic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 4329995520118258654L;
    private final long id;
    private final FichaSintomas fichaSintomas;

    private String diagnostico;
    private final Usuario paciente;
    private Medico medico;
    private UnidadeAtendimento encaminhamento;
    private StatusConsulta status;
    private final Date data;

    private List<PrescricaoMedicamento> prescricaoMedicamentos;

    public Consulta(FichaSintomas fichaSintomas, Usuario paciente, Medico medico, long id) {
        this.fichaSintomas = fichaSintomas;
        this.paciente = paciente;
        this.medico = medico;
        this.id = id;
        this.status = StatusConsulta.PENDING;
        this.data = new Date();
        this.prescricaoMedicamentos = new ArrayList<>();
    }

    public FichaSintomas getFichaSintomas() {
        return this.fichaSintomas;
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

    public void setEncaminhamento(UnidadeAtendimento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public List<PrescricaoMedicamento> getPrescricaoMedicamentos() { return prescricaoMedicamentos; }

    public void setPrescricaoMedicamentos(List<PrescricaoMedicamento> prescricaoMedicamentos) { this.prescricaoMedicamentos = prescricaoMedicamentos; }

    public String getDiagnostico() { return diagnostico; }

    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    @Override
    public String toString() {
        return this.getPaciente().getNome() + " - " + this.getData();
    }
}
