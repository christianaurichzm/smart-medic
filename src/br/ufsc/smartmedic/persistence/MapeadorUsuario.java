package br.ufsc.smartmedic.persistence;

import br.ufsc.smartmedic.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class MapeadorUsuario {
    private HashMap<String, Usuario> cachePessoas = new HashMap<>();
    private final String filename = "usuariosSmartMedic.user";

    public MapeadorUsuario() {
        load();
    }

    public Usuario get(String cpf) {
        return cachePessoas.get(cpf);
    }

    public void put(Usuario usuario) {
        cachePessoas.put(usuario.getCpf(), usuario);
        persist();
    }

    public List<Usuario> getList() {
        return new ArrayList<>(cachePessoas.values());
    }

    public void persist() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(filename);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cachePessoas);
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
            FileInputStream fileInput = new FileInputStream(filename);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            this.cachePessoas = (HashMap<String, Usuario>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            persist();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void remove(Usuario usuario) {
        cachePessoas.remove(usuario.getCpf());
    }

}
