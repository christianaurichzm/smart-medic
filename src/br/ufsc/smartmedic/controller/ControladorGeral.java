package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.TipoUsuario;
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

    public void realizaLogin(String cpf, String senha) {
         ControladorUsuario.getInstance().login(cpf, senha);
    }

    public void abreTelaCadastroMedico() {
        String[] unidadesDeAtendimento = ControladorUnidadesDeAtendimento.getInstance().mapeadorUnidadeDeAtendimento().getNomes();
        CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.MEDICO, unidadesDeAtendimento);
    }

    public void abreTelaCadastroPaciente() {
        String[] unidadesDeAtendimento = ControladorUnidadesDeAtendimento.getInstance().mapeadorUnidadeDeAtendimento().getNomes();
        CadastroMainScreen cadastroMainScreen = new CadastroMainScreen(TipoUsuario.PACIENTE, unidadesDeAtendimento);
    }
}
