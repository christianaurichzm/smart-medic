package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.view.LoginScreen;

import javax.swing.*;

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

    public void realizaLogin(String cpf, String senha) throws FormException {
             ControladorUsuario.getInstance().login(cpf, senha);
             Usuario usuarioSessao = ControladorUsuario.getInstance().getUsuarioSessao();
             if (usuarioSessao.getTipoUsuario() == TipoUsuario.MEDICO) {
                 System.out.println("Abre tela medico");
             } else {
                 System.out.println("Abre tela paciente");
             }
    }
}
