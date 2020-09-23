package ufsc.br;

public class FichaDeSintomas {
    private String corpo;
    private User especialista;

    public FichaDeSintomas(String corpo, User especialista) {
        this.corpo = corpo;
        this.especialista = especialista;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public User getEspecialista() {
        return especialista;
    }

    public void setEspecialista(User especialista) {
        this.especialista = especialista;
    }
}
