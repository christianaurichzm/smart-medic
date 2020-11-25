package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Medicamento;
import br.ufsc.smartmedic.persistencia.MapeadorMedicamento;

import java.util.List;

public class ControladorMedicamentos {
    private static ControladorMedicamentos controladorMedicamentos;
    private final MapeadorMedicamento mapeadorMedicamento;

    public ControladorMedicamentos() {
        this.mapeadorMedicamento = new MapeadorMedicamento();
    }

    public static ControladorMedicamentos getInstance() {
        if (controladorMedicamentos == null) {
            controladorMedicamentos = new ControladorMedicamentos();
        }
        return controladorMedicamentos;
    }

    public List<Medicamento> getMedicamentos() {
        return mapeadorMedicamento.getList();
    }

    public void setMedicamento(Medicamento medicamento) {
        this.mapeadorMedicamento.put(medicamento);
    }
}
