package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.UnidadeDeAtendimento;
import br.ufsc.smartmedic.model.excecoes.FormException;

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

    //TODO: validacao crm
    private void validarCampos() throws FormException {
        this.validarCpf();
        this.validarSenha();
        this.validarCrm();
    }

    private void validarCpf() throws FormException {
        if (!this.getCpf().matches("^([0-9]){3}\\.([0-9]){3}\\.([0-9]){3}-([0-9]){2}$")) {
            throw new FormException("O cpf inserido é inválido");
        }
    }

    private void validarSenha() throws FormException {
        if(!this.getSenha().matches("^[a-zA-Z0-9]{12}$")) {
            throw new FormException("A senha só pode consistir de caracteres alfanuméricos");
        }
    }

    private void validarCrm() {

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
