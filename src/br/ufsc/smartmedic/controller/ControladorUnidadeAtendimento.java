package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.Medico;
import br.ufsc.smartmedic.model.UnidadeAtendimento;
import br.ufsc.smartmedic.persistencia.MapeadorUnidadeAtendimento;

import java.util.List;

public class ControladorUnidadeAtendimento {
    private static ControladorUnidadeAtendimento controladorUnidadeAtendimento;
    private final MapeadorUnidadeAtendimento mapeadorUnidadeAtendimento;

    public ControladorUnidadeAtendimento() {
        this.mapeadorUnidadeAtendimento = new MapeadorUnidadeAtendimento();
    }

    public static ControladorUnidadeAtendimento getInstance() {
        if (controladorUnidadeAtendimento == null) {
            controladorUnidadeAtendimento = new ControladorUnidadeAtendimento();
        }
        return controladorUnidadeAtendimento;
    }

    public String[] getNomesMapeador() {
        return this.mapeadorUnidadeAtendimento.getNomes();
    }

    public UnidadeAtendimento getByNameMapeador(String nomeUnidadeAtendimento) {
        return this.mapeadorUnidadeAtendimento.getByName(nomeUnidadeAtendimento).get();
    }

    public void registraUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
        mapeadorUnidadeAtendimento.put(unidadeAtendimento);
    }

    public List<UnidadeAtendimento> getTodasUnidadesAtendimento() {
        return this.mapeadorUnidadeAtendimento.getList();
    }

    public void adicionaMedicoNaUnidadeDeAtendimento(Medico medico, UnidadeAtendimento unidadeAtendimento) {
        unidadeAtendimento.getMedicos().add(medico);
        this.mapeadorUnidadeAtendimento.persist();
    }

    public List<Medico> getAllMedicosFromUnidade(UnidadeAtendimento unidadeAtendimento) {
        return this.mapeadorUnidadeAtendimento.get(unidadeAtendimento.getCnes()).getMedicos();
    }
}
