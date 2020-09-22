package br.ufsc.smartmedic.model;

public class UnidadeDeAtendimento {

    private String nome;
    private String localizacao;
    private Long cnes;

    public UnidadeDeAtendimento(String nome, String localizacao, Long cnes) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.cnes = cnes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Long getCnes() {
        return cnes;
    }

    public void setCnes(Long cnes) {
        this.cnes = cnes;
    }

}
