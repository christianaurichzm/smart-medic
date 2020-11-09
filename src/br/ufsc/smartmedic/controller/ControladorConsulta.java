package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.*;
import br.ufsc.smartmedic.model.excecoes.NoDoctorAvailableException;
import br.ufsc.smartmedic.model.formularios.FormularioNovaConsulta;
import br.ufsc.smartmedic.persistencia.MapeadorConsulta;

import java.util.Optional;

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

    public MapeadorConsulta getMapeadorConsulta() {
        return this.mapeadorConsulta;
    }

    public void criarNovaConsulta(FormularioNovaConsulta form) throws NoDoctorAvailableException {
        String competencia = form.getCompetencia();
        FichaSintomas fichaSintomas = new FichaSintomas(form.getCorpo(), competencia);
        Optional<Medico> optMedico = ControladorUsuario.getInstance().getMedicoDisponivel(competencia);

        if (!optMedico.isPresent()) {
            throw new NoDoctorAvailableException("Não há médicos com essa especialidade disponíveis no momento.");
        }

        Medico medico = optMedico.get();

        Consulta consulta = new Consulta(fichaSintomas, form.getPaciente(), medico, form.getId());
        consulta.setStatus(StatusConsulta.PENDING);

        form.getPaciente().getHistoricoDeConsultas().add(consulta);
        medico.getHistoricoDeConsultas().add(consulta);

        ControladorUsuario.getInstance().getMapeadorUsuario().persist();
        this.mapeadorConsulta.put(consulta);
    }

}
