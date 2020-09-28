package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.view.CadastroScreen;

public class ControladorGeral {
    private static ControladorGeral controladorGeral;

    public static ControladorGeral getInstance() {
        if (controladorGeral == null) {
            controladorGeral = new ControladorGeral();
        }
        return controladorGeral;
    }

    public void abreTelaInicial() {
        CadastroScreen cadastroScreen = new CadastroScreen();
    }
}
