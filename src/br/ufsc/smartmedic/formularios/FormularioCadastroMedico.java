package br.ufsc.smartmedic.formularios;

import br.ufsc.smartmedic.model.UnidadeDeAtendimento;

public class FormularioCadastroMedico extends FormularioCadastro {
    private final String crm;
    private final String competencia;
    private final UnidadeDeAtendimento unidadeDeAtendimento;

    public FormularioCadastroMedico(String cpf, String nome, String sexo, String senha, Integer idade, String endereco, String crm, String competencia, UnidadeDeAtendimento unidadeDeAtendimento) {
        super(cpf, nome, sexo, senha, idade, endereco);
        this.crm = crm;
        this.competencia = competencia;
        this.unidadeDeAtendimento = unidadeDeAtendimento;
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

    public UnidadeDeAtendimento getUnidadeDeAtendimento() {
        return unidadeDeAtendimento;
    }
}
