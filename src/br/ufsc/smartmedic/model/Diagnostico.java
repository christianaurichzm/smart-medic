package br.ufsc.smartmedic.model;

import java.util.Optional;

public class Diagnostico {
    private UnidadeDeAtendimento encaminhamento;
    private String corpo;

    public Diagnostico(UnidadeDeAtendimento encaminhamento, String corpo) {
        this.encaminhamento = encaminhamento;
        this.corpo = corpo;
    }

    public Optional<UnidadeDeAtendimento> getEncaminhamento() {
        return Optional.ofNullable(encaminhamento);
    }

    public void setEncaminhamento(UnidadeDeAtendimento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
