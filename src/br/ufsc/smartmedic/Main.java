package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.*;
import br.ufsc.smartmedic.model.*;

public class Main {

    public static void main(String[] args) {
        UnidadeAtendimento unidade = new Hospital("hospital", "marte", 23332L);
        Medicamento medicamento = new Medicamento(1, "paracetamol", "500mg");
        ControladorMedicamentos.getInstance().setMedicamento(medicamento);
        ControladorUnidadeAtendimento.getInstance().registraUnidadeAtendimento(unidade);
        ControladorGeral.getInstance().abreTelaInicial();
    }

}
