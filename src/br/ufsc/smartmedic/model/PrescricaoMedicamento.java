package br.ufsc.smartmedic.model;

public class PrescricaoMedicamento {
    private Medicamento medicamento;
    private String frequencia;

    public PrescricaoMedicamento(Medicamento medicamento, String frequencia) {
        this.medicamento = medicamento;
        this.frequencia = frequencia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }
}
