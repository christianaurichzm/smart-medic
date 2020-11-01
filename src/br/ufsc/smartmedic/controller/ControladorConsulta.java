package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Consulta;
import br.ufsc.smartmedic.model.FichaSintomas;
import br.ufsc.smartmedic.model.StatusConsulta;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.formularios.FormularioNovaConsulta;
import br.ufsc.smartmedic.persistencia.MapeadorConsulta;

import java.util.List;

public class ControladorConsulta {
    private static ControladorConsulta controladorConsulta;
    private final MapeadorConsulta mapeadorConsulta;

    public ControladorConsulta() {
        this.mapeadorConsulta = new MapeadorConsulta();
    }

    public static ControladorConsulta getInstance() {
        if (controladorConsulta == null) {
            controladorConsulta = new ControladorConsulta();
        }

        return controladorConsulta;
    }

    public void criarNovaConsulta(FormularioNovaConsulta form) {
        String competencia = form.getCompetencia();
        FichaSintomas fichaSintomas = new FichaSintomas(form.getCorpo(), competencia);
        Usuario medico = ControladorUsuario.getInstance().getMedicoDisponivel(competencia);

        Consulta consulta = new Consulta(fichaSintomas, form.getPaciente(), medico);
        consulta.setStatus(StatusConsulta.PENDING);

        this.mapeadorConsulta.save(consulta);
    }

    public List<Consulta> getHistoricoDeConsultas() {
        Usuario usuario = ControladorUsuario.getInstance().getUsuarioSessao();
        return this.mapeadorConsulta.getAllConsultasByUserCpf(usuario.getCpf());
        //stream de consultas .filter(cpf do usuario)
    }
}
