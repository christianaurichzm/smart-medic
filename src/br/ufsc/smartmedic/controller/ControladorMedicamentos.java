package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Medicamento;
import br.ufsc.smartmedic.model.PrescricaoMedicamento;
import br.ufsc.smartmedic.persistencia.MapeadorMedicamento;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
        return medicamentos.stream().map(medicamento -> {
            ultimoId.getAndSet(ultimoId.get() + 1);
           return new Medicamento(ultimoId.get(), medicamento);
        }).collect(Collectors.toList());
    }

    public List<PrescricaoMedicamento> novasPrescricoes(List<Medicamento> medicamentos, List<String> frequencias) {
        if (medicamentos.size() != frequencias.size()) {
            return null;
        }

        List<PrescricaoMedicamento> prescricoes = new ArrayList<>();

        for (int i = 0; i < medicamentos.size(); i++) {
            prescricoes.add(new PrescricaoMedicamento(medicamentos.get(i), frequencias.get(i)));
        }

        return prescricoes;
    }
}
