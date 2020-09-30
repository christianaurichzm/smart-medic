package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.UnidadeAtendimento;
import br.ufsc.smartmedic.persistencia.MapeadorUnidadeAtendimento;

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
}
