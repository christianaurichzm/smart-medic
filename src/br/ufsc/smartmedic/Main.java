package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUsuario;

public class Main {

    public static void main(String[] args) {
        ControladorGeral.getInstance().abreTelaInicial();
        System.out.println(ControladorUsuario.getInstance().getUsuarioSessao().getEndereco());
//        ControladorGeral.getInstance().abreTelaCadastroMedico();
//        ControladorGeral.getInstance().abreTelaInicial();
//        String s = "12345678-9/SC";
//        System.out.println(s.matches("^[0-9]{0,8}-[0-9]/[A-Z]{2}$"));
    }

}
