package br.ufsc.smartmedic.persistencia;

import br.ufsc.smartmedic.model.Medico;
import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.UnidadeAtendimento;
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

    public List<Medico> getMedicosBySpecialty(String competencia) {
        return this.getMedicos().stream()
                .filter(medico -> competencia.equals(((Medico) medico).getCompetencia()))
                .map(this::userToMedic)
                .collect(Collectors.toList());
    }

    private Medico userToMedic(Usuario usuario) {
        String crm = ((Medico) usuario).getCrm();
        String competencia = ((Medico) usuario).getCompetencia();
        UnidadeAtendimento unidadeDeAtendimento = ((Medico) usuario).getUnidadeAtendimento();

        return new Medico(
                usuario.getNome(),
                usuario.getSexo(),
                usuario.getNascimento(),
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.getEndereco(),
                crm,
                competencia,
                unidadeDeAtendimento);
    }

    public List<String> getAllSpecialties() {
        List<String> specialtyList = new ArrayList<>();
        List<Usuario> medicos = this.getMedicos();

        medicos.stream()
            .filter(medico -> !specialtyList.contains(((Medico) medico).getCompetencia()))
            .forEach(medico -> specialtyList.add(((Medico) medico).getCompetencia()));

        return specialtyList;
    }
}
