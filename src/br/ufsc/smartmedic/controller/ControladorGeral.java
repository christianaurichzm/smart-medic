package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.view.CadastroMainScreen;
import br.ufsc.smartmedic.view.CadastroScreen;
import br.ufsc.smartmedic.view.LoginScreen;

public class ControladorGeral {
    private static ControladorGeral controladorGeral;

    public static ControladorGeral getInstance() {
        if (controladorGeral == null) {
            controladorGeral = new ControladorGeral();
        }
        return controladorGeral;
    }

    public void abreTelaInicial() {
        LoginScreen loginScreen = new LoginScreen();
    }

    public void abreTelaCadastro() {
        CadastroScreen cadastroScreen = new CadastroScreen();
    }

    public void realizaLogin(String cpf, String senha) throws FormException {
             ControladorUsuario.getInstance().login(cpf, senha);
             Usuario usuarioSessao = ControladorUsuario.getInstance().getUsuarioSessao();
             if (usuarioSessao.getTipoUsuario().equals(TipoUsuario.MEDICO)) {
                 System.out.println("Abre tela medico");
             } else {
                 System.out.println("Abre tela paciente");
             }
    }

    public void realizaCadastro(FormularioCadastro form) throws FormException {
        ControladorUsuario.getInstance().realizarCadastro(form);
    }

    public void abreTelaCadastroMedico() {
        String[] unidadesDeAtendimento = ControladorUnidadeAtendimento.getInstance().getMapeadorUnidadeAtendimento().getNomes();
        CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.MEDICO, unidadesDeAtendimento);
    }

    public void abreTelaCadastroPaciente() {
        String[] unidadesDeAtendimento = ControladorUnidadeAtendimento.getInstance().getMapeadorUnidadeAtendimento().getNomes();
        CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.PACIENTE, unidadesDeAtendimento);
    }
}
