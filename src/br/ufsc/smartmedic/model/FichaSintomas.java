package br.ufsc.smartmedic.model;

public class FichaSintomas {
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
