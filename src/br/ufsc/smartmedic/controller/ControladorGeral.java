package br.ufsc.smartmedic.controller;

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

    public void realizaLogin(String cpf, String senha) {
         ControladorUsuario.getInstance().login(cpf, senha);
    }
}
