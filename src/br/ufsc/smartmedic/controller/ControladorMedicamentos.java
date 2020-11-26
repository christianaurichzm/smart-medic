package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Medicamento;
import br.ufsc.smartmedic.persistencia.MapeadorMedicamento;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public List<Medicamento> criaOutrosMedicamentos(List<String> medicamentos) {
        List<Medicamento> todosMedicamentos = this.mapeadorMedicamento.getList();
        AtomicReference<Long> ultimoId = new AtomicReference<>(todosMedicamentos.get(todosMedicamentos.size() - 1).getCodigo());
        return (List<Medicamento>) medicamentos.stream().map(medicamento -> {
            ultimoId.getAndSet(ultimoId.get() + 1);
           return new Medicamento(ultimoId.get(), medicamento);
        });
    }
}
