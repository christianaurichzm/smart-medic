package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorGeral;

public class Main {

    public static void main(String[] args) {
        ControladorGeral.getInstance().abreTelaCadastroMedico();
        //         ControladorGeral.getInstance().abreTelaInicial();
//        String s = "12345678-1/SC";
//        System.out.println(s.matches("^[0-9]{0,8}-[0-9]{1}/[A-Z]{2}$"));
    }

}
