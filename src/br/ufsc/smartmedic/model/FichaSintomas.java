package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class FichaSintomas implements Serializable {
    private static final long serialVersionUID = 2122154773643395716L;
    private String corpo;
    private String especialidade;

    public FichaSintomas(String corpo, String especialidade) {
        this.corpo = corpo;
        this.especialidade = especialidade;
    }

    public String getCorpo() {
        return this.corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
