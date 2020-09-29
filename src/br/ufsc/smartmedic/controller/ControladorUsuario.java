package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.formularios.FormularioAlteracaoDeDados;
import br.ufsc.smartmedic.formularios.FormularioCadastro;
import br.ufsc.smartmedic.formularios.FormularioCadastroMedico;
import br.ufsc.smartmedic.model.*;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.persistencia.MapeadorUsuario;

import java.util.List;
import java.util.Optional;

public class ControladorUsuario {

    private static ControladorUsuario controladorUsuario;
    private final MapeadorUsuario mapeadorUsuario;
    private Usuario usuarioSessao;

    public ControladorUsuario() {
        this.mapeadorUsuario = new MapeadorUsuario();
    }

    public static ControladorUsuario getInstance() {
        if (controladorUsuario == null) {
            controladorUsuario = new ControladorUsuario();
        }
        return controladorUsuario;
    }

    public void realizarCadastro(FormularioCadastro form) throws FormException {
        List<Usuario> usuarios = this.mapeadorUsuario.getList();
        this.validateUniqueness(form, usuarios);
        mapeadorUsuario.put(this.formToUser(form));
    }

    private Usuario formToUser(FormularioCadastro form) {
        if (form instanceof FormularioCadastroMedico) {
            return new Medico(form.getNome(),
                    form.getSexo(),
                    form.getIdade(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco(),
                    ((FormularioCadastroMedico) form).getCrm(),
                    ((FormularioCadastroMedico) form).getCompetencia(),
                    ((FormularioCadastroMedico) form).getUnidadeDeAtendimento());
        } else {
            return new Paciente(form.getNome(),
                    form.getSexo(),
                    form.getIdade(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco());
        }
    }

    private void validateUniqueness(FormularioCadastro form, List<Usuario> usuarios) throws FormException {
        Optional<Usuario> usuario = usuarios.stream().filter(user -> user.validar(form.getCpf(), form.getSenha())).findFirst();

        if (usuario.isPresent()) {
            throw new FormException("Este cpf já está cadastrado");
        }
    }

    public List<Usuario> getUsuarios() {
        return mapeadorUsuario.getList();
    }

    public Usuario getUsuario(String cpf) {
        return mapeadorUsuario.get(cpf);
    }

    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public TipoUsuario login(String cpf, String senha) {
        Usuario usuario = getUsuario(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            this.usuarioSessao = usuario;
            return usuario.getTipoUsuario();
        } else {
            System.out.println("Usuario nao encontrado");
            return null;
        }
    }

    public void alterarDados(Usuario usuario, FormularioAlteracaoDeDados form) {
        form.getNome().ifPresent(usuario::setNome);
        form.getSexo().ifPresent(usuario::setSexo);
        form.getIdade().ifPresent(usuario::setIdade);
        form.getSenha().ifPresent(usuario::setSenha);
        form.getEndereco().ifPresent(usuario::setEndereco);

        if (usuario instanceof Medico) {
            form.getUnidadeDeAtendimento().ifPresent(((Medico) usuario)::setUnidadeDeAtendimento);
            form.getCompetencia().ifPresent(((Medico) usuario)::setCompetencia);
        }

        this.mapeadorUsuario.put(usuario);
    }
}
