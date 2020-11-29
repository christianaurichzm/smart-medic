package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.excecoes.NoDoctorAvailableException;
import br.ufsc.smartmedic.model.excecoes.UserNotLoggedException;
import br.ufsc.smartmedic.model.formularios.FormularioAlteracaoDeDados;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.model.formularios.FormularioCadastroMedico;
import br.ufsc.smartmedic.model.*;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.persistencia.MapeadorUsuario;

import javax.swing.*;
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
        Usuario usuario = this.formToUser(form);
        mapeadorUsuario.put(usuario);
        if (usuario.getTipoUsuario() == TipoUsuario.MEDICO) {
            UnidadeAtendimento unidadeAtendimento = ControladorUnidadeAtendimento.getInstance().getByNameMapeador(((FormularioCadastroMedico) form).getUnidadeAtendimento());
            ControladorUnidadeAtendimento.getInstance().adicionaMedicoNaUnidadeDeAtendimento((Medico) usuario, unidadeAtendimento);
        }
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

    public void logout() throws UserNotLoggedException {
        this.validateUsuarioSessao();
        setUsuarioSessao(null);
    }

    private void validateUsuarioSessao() throws UserNotLoggedException {
        if (this.usuarioSessao == null) {
            throw new UserNotLoggedException("Não há usuário em sessão");
        }
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

    public Usuario getUsuarioSessao() throws UserNotLoggedException {
        Optional<Usuario> usuarioSessao = Optional.ofNullable(this.usuarioSessao);
        if (usuarioSessao.isPresent()) {
            return usuarioSessao.get();
        } else {
            throw new UserNotLoggedException("Não há usuário em sessão");
        }
    }

    public List<String> getAllSpecialties() {
        return this.mapeadorUsuario.getAllSpecialties();
    }

    private Optional<Consulta> getUltimaConsulta(List<Consulta> consultas) {
        if (!consultas.isEmpty()) {
            return Optional.of(consultas.get(consultas.size() - 1));
        }
        return Optional.empty();
    }

    public Optional<Medico> getMedicoDisponivel(String competencia) {
        List<Medico> medicosBySpecialty = this.mapeadorUsuario.getMedicosBySpecialty(competencia);

        for (Medico medico : medicosBySpecialty) {
            Optional<Consulta> ultimaConsulta = this.getUltimaConsulta(medico.getHistoricoDeConsultas());
            if (ultimaConsulta.isPresent() && !ultimaConsulta.get().getStatus().equals(StatusConsulta.PENDING)) {
                return Optional.of(medico);
            }
            if (!ultimaConsulta.isPresent()) {
                return Optional.of(medico);
            }
        }
        return Optional.empty();
    }

    public Medico getMedicoDisponivelNaUnidadeBySpecialty(UnidadeAtendimento unidadeAtendimento, String competencia) throws NoDoctorAvailableException {
        Optional<Medico> medicoDisponivel = unidadeAtendimento.getMedicos()
                .stream()
                .filter(medico -> {
                    try {
                        return medico.getCompetencia().equals(competencia) && !medico.getCpf().equals(ControladorUsuario.getInstance().getUsuarioSessao().getCpf());
                    } catch (UserNotLoggedException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    return false;
                })
                .findFirst();

        if (medicoDisponivel.isPresent()) {
            return medicoDisponivel.get();
        } else {
            throw new NoDoctorAvailableException("Não há médico com essa especialidade disponível na unidade selecionada");
        }
    }

    public MapeadorUsuario getMapeadorUsuario() {
        return this.mapeadorUsuario;
    }

}
