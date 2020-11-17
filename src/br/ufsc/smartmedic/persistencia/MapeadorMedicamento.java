package br.ufsc.smartmedic.persistencia;

import br.ufsc.smartmedic.model.Medicamento;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapeadorMedicamento {
    private HashMap<Integer, Medicamento> cacheMedicamentos = new HashMap<>();
    private final String FILENAME = "medicamentos.med";

    public MapeadorMedicamento() {
        load();
    }

    public Medicamento get(Integer codigo) {
        return cacheMedicamentos.get(codigo);
    }

    public void put(Medicamento medicamento) {
        cacheMedicamentos.put(medicamento.getCodigo(), medicamento);
        persist();
    }

    public List<Medicamento> getList() {
        return new ArrayList<>(cacheMedicamentos.values());
    }

    public void persist() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheMedicamentos);
            objectOutput.flush();
            fileOutput.flush();
            objectOutput.close();
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream fileInput = new FileInputStream(FILENAME);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            this.cacheMedicamentos = (HashMap<Integer, Medicamento>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            persist();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Medicamento medicamento) {
        cacheMedicamentos.remove(medicamento.getCodigo());
    }
}
