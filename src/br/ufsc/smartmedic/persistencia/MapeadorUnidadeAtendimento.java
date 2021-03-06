package br.ufsc.smartmedic.persistencia;

import br.ufsc.smartmedic.model.UnidadeAtendimento;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MapeadorUnidadeAtendimento {
    private HashMap<Long, UnidadeAtendimento> cacheUnidadesAtendimento = new HashMap<>();
    private final String FILENAME = "unidadesAtendimentoSmartMedic.unit";

    public MapeadorUnidadeAtendimento() {
        load();
    }

    public UnidadeAtendimento get(Long cnes) {
        return cacheUnidadesAtendimento.get(cnes);
    }

    public Optional<UnidadeAtendimento> getByName(String name) {
        List<UnidadeAtendimento> unidades = this.getList();

        return unidades.stream().filter(unidade -> unidade.getNome().equals(name)).findFirst();
    }

    public void put(UnidadeAtendimento unidadeAtendimento) {
        cacheUnidadesAtendimento.put(unidadeAtendimento.getCnes(), unidadeAtendimento);
        persist();
    }

    public List<UnidadeAtendimento> getList() {
        return new ArrayList<>(cacheUnidadesAtendimento.values());
    }

    public void persist() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheUnidadesAtendimento);
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
            this.cacheUnidadesAtendimento = (HashMap<Long, UnidadeAtendimento>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            persist();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(UnidadeAtendimento unidadeAtendimento) {
        cacheUnidadesAtendimento.remove(unidadeAtendimento.getCnes());
    }

    public String[] getNomes() {
        return this.getList().stream()
                .map(UnidadeAtendimento::getNome).toArray(String[]::new);
    }
}
