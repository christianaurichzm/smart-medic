package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUnidadeAtendimento;
import br.ufsc.smartmedic.model.Hospital;
import br.ufsc.smartmedic.model.UnidadeAtendimento;

public class Main {

    public static void main(String[] args) {
        UnidadeAtendimento unidade = new Hospital("hospital", "marte", 23332L);
        ControladorUnidadeAtendimento.getInstance().registraUnidadeAtendimento(unidade);
        ControladorGeral.getInstance().abreTelaInicial();
    }

}
