package br.ufsc.smartmedic.model;

import java.util.Optional;

public class Diagnostico {
    private UnidadeAtendimento encaminhamento;
    private String corpo;

    public Diagnostico(UnidadeAtendimento encaminhamento, String corpo) {
        this.encaminhamento = encaminhamento;
        this.corpo = corpo;
    }

    public Optional<UnidadeAtendimento> getEncaminhamento() {
        return Optional.ofNullable(this.encaminhamento);
    }

    public void setEncaminhamento(UnidadeAtendimento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getCorpo() {
        return this.corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
