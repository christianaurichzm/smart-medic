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

    private static ControladorUsuario controladorUsuario;
    private final MapeadorUsuario mapeadorUsuario;
    private Usuario usuarioSessao;

    public ControladorUsuario(MapeadorUsuario mapeadorUsuario) {
        this.mapeadorUsuario = mapeadorUsuario;
    }

    public static ControladorUsuario getInstance() {
        if (controladorUsuario == null)
            controladorUsuario = new ControladorUsuario(new MapeadorUsuario());
        return controladorUsuario;
    }
    public void realizarCadastro(FormularioCadastro form) throws FormException {
        List<Usuario> usuarios = this.mapeadorUsuario.getList();
        this.validateUniqueness(form, usuarios);
        mapeadorUsuario.put(this.formToUser(form));
    }

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

    public boolean login(String cpf, String senha) {
        Usuario usuario = getUsuario(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            if (usuario instanceof Paciente) {
                System.out.println("Logou como paciente");
            } else {
                System.out.println("Logou como médico");
            }
            this.usuarioSessao = usuario;
            return true;
        }
        return false;
    }
}
