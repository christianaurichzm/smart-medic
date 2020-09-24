package br.ufsc.smartmedic.model;

public class FichaDeSintomas {
    private String corpo;
    private Usuario especialista;

    public FichaDeSintomas(String corpo, Usuario especialista) {
        this.corpo = corpo;
        this.especialista = especialista;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Usuario getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Usuario especialista) {
        this.especialista = especialista;
    }
}
