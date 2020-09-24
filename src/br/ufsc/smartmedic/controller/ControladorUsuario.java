package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.persistence.MapeadorUsuario;

import java.util.List;

public class ControladorUsuario {

    private static ControladorUsuario controladorUsuario;
    private MapeadorUsuario mapeadorUsuario;

    public ControladorUsuario() {

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

    //public void RealizarCadastro(FormularioCadastroDTO form) throws FormException {
    //    this.validateUniqueness(form);
    //}

    //private void validateUniqueness(FormularioCadastroDTO form) throws FormException {
    //    if (!unique) {
    //      throw new FormException("Este cpf já está cadastrado");
    //  }
    //}
}
