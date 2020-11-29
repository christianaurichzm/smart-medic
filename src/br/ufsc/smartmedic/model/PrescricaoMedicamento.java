package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class PrescricaoMedicamento implements Serializable {
    private static final long serialVersionUID = 904584699892087863L;
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
