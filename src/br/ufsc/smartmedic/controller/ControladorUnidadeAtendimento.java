package br.ufsc.smartmedic.controller;

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

    public MapeadorUnidadeAtendimento getMapeadorUnidadeAtendimento() {
        return this.mapeadorUnidadeAtendimento;
    }
}
