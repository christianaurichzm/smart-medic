package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.excecoes.UserNotLoggedException;
import br.ufsc.smartmedic.model.formularios.FormularioAlteracaoDeDados;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.view.*;

import java.util.List;

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

    public void abreTelaAlterarCadastro() throws UserNotLoggedException {
        String[] unidadesDeAtendimento = ControladorUnidadeAtendimento.getInstance().getNomesMapeador();

        TipoUsuario tipoUsuario = ControladorUsuario.getInstance().getUsuarioSessao().getTipoUsuario();
        if (tipoUsuario.equals(TipoUsuario.MEDICO)) {
            CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.MEDICO, unidadesDeAtendimento, true);
        } else {
            CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.PACIENTE, unidadesDeAtendimento, true);
        }
    }

    public void salvarAlteracaoDadosCadastrais(FormularioAlteracaoDeDados form) throws UserNotLoggedException {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        Usuario usuarioSessao = controladorUsuario.getUsuarioSessao();
        controladorUsuario.alterarDados(usuarioSessao, form);
    }

    public void realizaLogout() {
        ControladorUsuario.getInstance().logout();
        abreTelaInicial();
    }

    public void abreTelaRealizarNovaChamada() throws UserNotLoggedException {
        Usuario usuario = ControladorUsuario.getInstance().getUsuarioSessao();
        List<String> competencias = ControladorUsuario.getInstance().getAllSpecialties();
        FichaConsultasScreen novaChamadaMainScreen = new FichaConsultasScreen(competencias, usuario);
    }

    public void abreHistoricoConsultas() {
        HistoricoConsultasScreen historicoConsultasScreen = new HistoricoConsultasScreen();
    }

    public void abreTelaResponderChamado() throws UserNotLoggedException {
        ResponderConsultaScreen responderConsultaScreen = new ResponderConsultaScreen(ControladorConsulta.getInstance().getConsultasFinalizadas());
    }
}
