package br.ufsc.smartmedic.persistencia;

import br.ufsc.smartmedic.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

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
}
