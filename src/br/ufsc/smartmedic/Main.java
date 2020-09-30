package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUnidadeAtendimento;
import br.ufsc.smartmedic.model.Hospital;
import br.ufsc.smartmedic.model.UnidadeAtendimento;
import br.ufsc.smartmedic.model.excecoes.FormException;

public class Main {

    public static void main(String[] args) throws FormException {
        UnidadeAtendimento unidade = new Hospital("hospital", "marte", 23332L);
        ControladorUnidadeAtendimento.getInstance().registraUnidadeAtendimento(unidade);
//        String s = "";
//        Optional<String> optS = Optional.ofNullable(s);
//        System.out.println(s.isEmpty() + "\n" + optS.isPresent());
        ControladorGeral.getInstance().abreTelaInicial();
//        System.out.println(ControladorUsuario.getInstance().getUsuarioSessao().getEndereco());
//        ControladorGeral.getInstance().abreTelaCadastroMedico();
//        ControladorGeral.getInstance().abreTelaInicial();
//        String s = "12345678-9/SC";
//        System.out.println(s.matches("^[0-9]{0,8}-[0-9]/[A-Z]{2}$"));
    }

}
