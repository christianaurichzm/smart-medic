package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;

public class FormularioNovaConsulta {
    private final String competencia;
    private final String corpo;
    private final Usuario paciente;

    public FormularioNovaConsulta(String competencia, String corpo, Usuario paciente) throws FormException {
        this.competencia = competencia;
        this.corpo = corpo;
        this.paciente = paciente;
        this.validate();
    }

    private void validate() throws FormException {
        if (this.competencia.isEmpty()) {
            throw new FormException("O usuário deve escolher uma especialidade.");
        }
        if (this.corpo.isEmpty()) {
            throw new FormException("O corpo da ficha de sintomas deve ser preenchido corretamente.");
        }
    }

    public String getCompetencia() {
        return competencia;
    }

    public String getCorpo() {
        return corpo;
    }

    public Usuario getPaciente() {
        return paciente;
    }
}
