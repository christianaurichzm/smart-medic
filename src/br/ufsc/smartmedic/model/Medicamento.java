package br.ufsc.smartmedic.model;

import java.io.Serializable;

public class Medicamento implements Serializable {
    private static final long serialVersionUID = -5422446535725311749L;
    private Long codigo;
    private String principioAtivo;

    public Medicamento(Long codigo, String principioAtivo) {
        this.codigo = codigo;
        this.principioAtivo = principioAtivo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    @Override
    public String toString() {
        return this.getCodigo() + " - " + this.getPrincipioAtivo();
    }
}
