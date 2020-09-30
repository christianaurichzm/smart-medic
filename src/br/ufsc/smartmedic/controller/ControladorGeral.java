package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.formularios.FormularioAlteracaoDeDados;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.view.CadastroMainScreen;
import br.ufsc.smartmedic.view.CadastroScreen;
import br.ufsc.smartmedic.view.LoginScreen;
import br.ufsc.smartmedic.view.MainMenuScreen;

public class ControladorGeral {
    private static ControladorGeral controladorGeral;
    private static ControladorUnidadeAtendimento controladorUnidadeAtendimento;

    public static ControladorGeral getInstance() {
        if (controladorGeral == null) {
            controladorGeral = new ControladorGeral();
            controladorUnidadeAtendimento = ControladorUnidadeAtendimento.getInstance();
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
        abreTelaPrincipal();
    }

    public void abreTelaPrincipal() {
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
    }

    public void realizaCadastro(FormularioCadastro form) throws FormException {
        ControladorUsuario.getInstance().realizarCadastro(form);
    }

    public void abreTelaMainCadastro(TipoUsuario tipoUsuario) {
        String[] unidadesDeAtendimento = ControladorUnidadeAtendimento.getInstance().getNomesMapeador();

        CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(tipoUsuario, unidadesDeAtendimento, false);
    }

    public void abreTelaAlterarCadastro() {
        String[] unidadesDeAtendimento = ControladorUnidadeAtendimento.getInstance().getNomesMapeador();

        TipoUsuario tipoUsuario = ControladorUsuario.getInstance().getUsuarioSessao().getTipoUsuario();
        if (tipoUsuario.equals(TipoUsuario.MEDICO)) {
            CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.MEDICO, unidadesDeAtendimento, true);
        } else {
            CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.PACIENTE, unidadesDeAtendimento, true);
        }
    }

    public void salvarAlteracaoDadosCadastrais(FormularioAlteracaoDeDados form) {

    }
}
