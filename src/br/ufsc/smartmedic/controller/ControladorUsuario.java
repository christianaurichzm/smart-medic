package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.formularios.FormularioAlteracaoDeDados;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.model.formularios.FormularioCadastroMedico;
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

    public TipoUsuario login(String cpf, String senha) throws FormException {
        Usuario usuario = getUsuario(cpf);
        if (usuario != null) {
            if (usuario.getSenha().equals(senha)) {
                this.usuarioSessao = usuario;
                return usuario.getTipoUsuario();
            } else {
                throw new FormException("Senha incorreta.");
            }
        } else {
            throw new FormException("Usuário não encontrado.");
        }
    }

    public void alterarDados(Usuario usuario, FormularioAlteracaoDeDados form) {
        form.getNome().ifPresent(usuario::setNome);
        form.getSexo().ifPresent(usuario::setSexo);
        form.getNascimento().ifPresent(usuario::setNascimento);
        form.getSenha().ifPresent(usuario::setSenha);
        form.getEndereco().ifPresent(usuario::setEndereco);

        if (usuario instanceof Medico) {
            form.getUnidadeAtendimento().ifPresent(((Medico) usuario)::setUnidadeAtendimento);
            form.getCompetencia().ifPresent(((Medico) usuario)::setCompetencia);
        }

        this.mapeadorUsuario.put(usuario);
    }
    private Usuario formToUser(FormularioCadastro form) {
        if (form instanceof FormularioCadastroMedico) {
            return new Medico(form.getNome(),
                    form.getSexo(),
                    form.getNascimento(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco(),
                    ((FormularioCadastroMedico) form).getCrm(),
                    ((FormularioCadastroMedico) form).getCompetencia(),
                    ControladorUnidadeAtendimento.getInstance().getMapeadorUnidadeAtendimento().getByName(((FormularioCadastroMedico) form).getUnidadeAtendimento()).get());
        } else {
            return new Paciente(form.getNome(),
                    form.getSexo(),
                    form.getNascimento(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco());
        }
    }

    private void validateUniqueness(FormularioCadastro form, List<Usuario> usuarios) throws FormException {
        Optional<Usuario> usuario = usuarios.stream().filter(user -> user.validar(form.getCpf())).findFirst();

        if (usuario.isPresent()) {
            throw new FormException("Este cpf já está cadastrado");
        }
    }

    public Usuario getUsuario(String cpf) {
        return mapeadorUsuario.get(cpf);
    }

    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }
}
