package br.ufsc.smartmedic;

import br.ufsc.smartmedic.controller.ControladorConsulta;
import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUnidadeAtendimento;
import br.ufsc.smartmedic.controller.ControladorUsuario;
import br.ufsc.smartmedic.model.Consulta;
import br.ufsc.smartmedic.model.FichaSintomas;
import br.ufsc.smartmedic.model.Hospital;
import br.ufsc.smartmedic.model.UnidadeAtendimento;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.formularios.FormularioNovaConsulta;

public class Main {

    public static void main(String[] args) {
        UnidadeAtendimento unidade = new Hospital("hospital", "marte", 23332L);
        ControladorUnidadeAtendimento.getInstance().registraUnidadeAtendimento(unidade);
        ControladorGeral.getInstance().abreTelaInicial();
    }

}
