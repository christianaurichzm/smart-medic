package br.ufsc.smartmedic.persistencia;

import br.ufsc.smartmedic.model.Medico;
import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapeadorUsuario {
    private HashMap<String, Usuario> cacheUsuarios = new HashMap<>();
    private final String FILENAME = "usuariosSmartMedic.user";

    public MapeadorUsuario() {
        load();
    }

    public Usuario get(String cpf) {
        return cacheUsuarios.get(cpf);
    }

    public void put(Usuario usuario) {
        cacheUsuarios.put(usuario.getCpf(), usuario);
        persist();
    }

    public List<Usuario> getList() {
        return new ArrayList<>(cacheUsuarios.values());
    }

    public void persist() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheUsuarios);
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
            this.cacheUsuarios = (HashMap<String, Usuario>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            persist();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Usuario usuario) {
        cacheUsuarios.remove(usuario.getCpf());
    }

    public List<Usuario> getMedicos() {
        return this.getList().stream()
                .filter(usuario -> usuario.getTipoUsuario().equals(TipoUsuario.MEDICO))
                .collect(Collectors.toList());
    }

    public List<Usuario> getMedicosBySpecialty(String competencia) {
        return this.getMedicos().stream()
                .filter(medico -> competencia.equals(((Medico) medico).getCompetencia()))
                .collect(Collectors.toList());
    }

    public List<String> getAllSpecialties() {
        List<String> specialtyList = new ArrayList<>();

        this.getMedicos().stream()
            .filter(medico -> !specialtyList.contains(((Medico) medico).getCompetencia()))
            .map(medico -> specialtyList.add(((Medico) medico).getCompetencia()));

        return specialtyList;
    }

//    public List<String> getAllSpecialties() {
//        List<Usuario> medicos = this.getMedicos();
//        List<String> specialtyList = new ArrayList<>();
//
//        for (Usuario medico : medicos) {
//            if (!specialtyList.contains(((Medico) medico).getCompetencia())) {
//                specialtyList.add(((Medico) medico).getCompetencia());
//            }
//        }
//
//        return specialtyList;
//    }

//    public List<Usuario> getMedicosBySpecialty(String competencia) {
//        List<Usuario> usuarios = this.getMedicos();
//        List<Usuario> medicos = new ArrayList<>();
//
//        for (Usuario u : usuarios) {
//            if (competencia.equals(((Medico) u).getCompetencia())) {
//                medicos.add(u);
//            }
//        }
//        return medicos;
//    }

}
