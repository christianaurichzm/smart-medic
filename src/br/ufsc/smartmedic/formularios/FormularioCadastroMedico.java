package br.ufsc.smartmedic.formularios;

import br.ufsc.smartmedic.model.UnidadeAtendimento;

public class FormularioCadastroMedico extends FormularioCadastro {
    private final String crm;
    private final String competencia;
    private final UnidadeAtendimento unidadeAtendimento;

    public FormularioCadastroMedico(String cpf, String nome, String sexo, String senha, Integer idade, String endereco, String crm, String competencia, UnidadeAtendimento unidadeAtendimento) {
        super(cpf, nome, sexo, senha, idade, endereco);
        this.crm = crm;
        this.competencia = competencia;
        this.unidadeAtendimento = unidadeAtendimento;
    }
    //TODO: validacao cpf, endereco, crm, senha
    private void validarCampos() {

    }

    public String getCrm() {
        return crm;
    }

    public String getCompetencia() {
        return competencia;
    }

    public UnidadeAtendimento getUnidadeAtendimento() {
        return unidadeAtendimento;
    }
}
