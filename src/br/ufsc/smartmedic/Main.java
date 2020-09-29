package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorGeral;

public class Main {

    public static void main(String[] args) {
        // ControladorGeral.getInstance().abreTelaInicial();
        String s = "asdfasdf";
        System.out.println(s.matches("^[a-zA-Z0-9]{12}$"));
    }

}
