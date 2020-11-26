package br.ufsc.smartmedic.model;

import java.io.Serializable;

public abstract class UnidadeAtendimento implements Serializable {
    private static final long serialVersionUID = 1374618232371221467L;
    private String nome;
    private String localizacao;
    private Long cnes;

    public UnidadeAtendimento(String nome, String localizacao, Long cnes) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.cnes = cnes;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Long getCnes() {
        return this.cnes;
    }

    public void setCnes(Long cnes) {
        this.cnes = cnes;
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getCnes();
    }
}
