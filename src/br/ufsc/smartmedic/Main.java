package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorGeral;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String s = "";
        Optional<String> optS = Optional.ofNullable(s);
        System.out.println(s.isEmpty() + "\n" + optS.isPresent());
//        ControladorGeral.getInstance().abreTelaInicial();
//        System.out.println(ControladorUsuario.getInstance().getUsuarioSessao().getEndereco());
//        ControladorGeral.getInstance().abreTelaCadastroMedico();
//        ControladorGeral.getInstance().abreTelaInicial();
//        String s = "12345678-9/SC";
//        System.out.println(s.matches("^[0-9]{0,8}-[0-9]/[A-Z]{2}$"));
    }

}
