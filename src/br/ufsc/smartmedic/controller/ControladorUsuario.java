package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Paciente;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.persistence.MapeadorUsuario;

import java.util.List;

public class ControladorUsuario {

    private static ControladorUsuario controladorUsuario;
    private MapeadorUsuario mapeadorUsuario;

    public ControladorUsuario() {
        mapeadorUsuario = new MapeadorUsuario();
    }

    public static ControladorUsuario getInstance() {
        if (controladorUsuario == null)
            controladorUsuario = new ControladorUsuario();
        return controladorUsuario;
    }

    public List<Usuario> getUsuarios() {
        return mapeadorUsuario.getList();
    }

    public Usuario getUsuario(String cpf) {
        return mapeadorUsuario.get(cpf);
    }

    public boolean login(String cpf, String senha) {
        Usuario usuario = getUsuario(cpf);
        if (usuario != null && usuario.getSenha() == senha) {
            if (usuario instanceof Paciente) {
                System.out.println("Logou como paciente");
            } else {
                System.out.println("Logou como médico");
            }
            return true;
        }
        return false;
    }

    //public void RealizarCadastro(FormularioCadastroDTO form) throws FormException {
    //    this.validateUniqueness(form);
    //}

    //private void validateUniqueness(FormularioCadastroDTO form) throws FormException {
    //    if (!unique) {
    //      throw new FormException("Este cpf já está cadastrado");
    //  }
    //}
}
