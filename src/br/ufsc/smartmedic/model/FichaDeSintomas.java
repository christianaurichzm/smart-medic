package br.ufsc.smartmedic.model;

import java.util.List;

public class FichaDeSintomas {
    private String corpo;
    private List<String> sintomas;

    public FichaDeSintomas(String corpo, List<String> sintomas) {
        this.corpo = corpo;
        this.sintomas = sintomas;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }
}
