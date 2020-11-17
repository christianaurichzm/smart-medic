package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class Medicamento implements Serializable {
    private static final long serialVersionUID = -5422446535725311749L;
    private int codigo;
    private String principioAtivo;
    private String concentracao;

    public Medicamento(int codigo, String principioAtivo, String concentracao) {
        this.codigo = codigo;
        this.principioAtivo = principioAtivo;
        this.concentracao = concentracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }
}
