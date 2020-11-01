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

    private void setUsuarioSessao(Usuario usuario) {
        this.usuarioSessao = usuario;
    }

    public void realizarCadastro(FormularioCadastro form) throws FormException {
        List<Usuario> usuarios = this.mapeadorUsuario.getList();
        this.validateUniqueness(form, usuarios);
        mapeadorUsuario.put(this.formToUser(form));
    }

    public void login(String cpf, String senha) throws FormException {
        Usuario usuario = getUsuario(cpf);
        if (usuario != null) {
            if (usuario.getSenha().equals(senha)) {
                setUsuarioSessao(usuario);
            } else {
                throw new FormException("Senha incorreta.");
            }
        } else {
            throw new FormException("Usuário não encontrado.");
        }
    }

    public void logout() {
        setUsuarioSessao(null);
    }

    public void alterarDados(Usuario usuario, FormularioAlteracaoDeDados form) {
        form.getNome().ifPresent(usuario::setNome);
        form.getSexo().ifPresent(usuario::setSexo);
        form.getNascimento().ifPresent(usuario::setNascimento);
        form.getSenha().ifPresent(usuario::setSenha);
        form.getEndereco().ifPresent(usuario::setEndereco);

        if (usuario instanceof Medico) {
            UnidadeAtendimento unidadeAtendimento = ControladorUnidadeAtendimento.getInstance().
            getByNameMapeador(form.getUnidadeAtendimento().get());
            if (form.getUnidadeAtendimento().isPresent()) {
                ((Medico) usuario).setUnidadeAtendimento(unidadeAtendimento);
            }

            form.getCompetencia().ifPresent(((Medico) usuario)::setCompetencia);
        }

        this.mapeadorUsuario.put(usuario);
    }

    private Usuario formToUser(FormularioCadastro form) {
        if (form.getTipoUsuario().equals(TipoUsuario.MEDICO)) {
            return new Medico(form.getNome(),
                    form.getSexo(),
                    form.getNascimento(),
                    form.getCpf(),
                    form.getSenha(),
                    form.getEndereco(),
                    ((FormularioCadastroMedico) form).getCrm(),
                    ((FormularioCadastroMedico) form).getCompetencia(),
                    ControladorUnidadeAtendimento.getInstance().getByNameMapeador(((FormularioCadastroMedico) form).getUnidadeAtendimento()));
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

    public List<String> getAllSpecialties() {
        return this.mapeadorUsuario.getAllSpecialties();
    }

    public List<Usuario> getMedicosBySpecialty(String competencia) {
        return this.mapeadorUsuario.getMedicosBySpecialty(competencia);
    }

    public Usuario getMedicoDisponivel(String competencia) {
        return mapeadorUsuario.getMedicosBySpecialty(competencia).stream()
                .filter();
        //pegar o historico de consulta de cada medico e filtrar os que tiverem uma consulta em StatusConsulta.PENDING
    }
}
