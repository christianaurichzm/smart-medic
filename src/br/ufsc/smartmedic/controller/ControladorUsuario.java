package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.FormularioCadastro;
import br.ufsc.smartmedic.model.Medico;
import br.ufsc.smartmedic.model.Paciente;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.persistence.MapeadorUsuario;

import java.util.List;
import java.util.Optional;

public class ControladorUsuario {
    private final MapeadorUsuario mapeadorUsuario;

    public ControladorUsuario(MapeadorUsuario mapeadorUsuario) {
        this.mapeadorUsuario = mapeadorUsuario;
    }

    public void RealizarCadastro(FormularioCadastro form) throws FormException {
        List<Usuario> usuarios = this.mapeadorUsuario.getList();

        this.validateUniqueness(form, usuarios);

        mapeadorUsuario.put(this.formToUser(form));
    }

//TODO: revisar atributos necessarios para paciente/medico (sexo e endereço p medicos)
    private Usuario formToUser(FormularioCadastro form) {
        if (form.getCrm().isPresent()) {
            return new Medico(form.getNome(),
                    form.getSexo(),
                    form.getIdade(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco().get(),
                    form.getCrm().get(),
                    form.getCompetencia().get(),
                    form.getUnidadeDeAtendimento().get());
        } else {
            return new Paciente(form.getNome(),
                    form.getSexo(),
                    form.getIdade(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco().get());
        }

    }

    private void validateUniqueness(FormularioCadastro form, List<Usuario> usuarios) throws FormException {
        Optional<Usuario> usuario = usuarios.stream().filter(user -> user.validar(user)).findFirst();

        if (usuario.isPresent()) {
            throw new FormException("Este cpf já está cadastrado");
        }
    }
}
