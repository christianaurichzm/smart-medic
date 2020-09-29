package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.UnidadeDeAtendimento;
import br.ufsc.smartmedic.model.excecoes.FormException;

public class FormularioCadastroMedico extends FormularioCadastro {
    private final String crm;
    private final String competencia;
    private final UnidadeDeAtendimento unidadeDeAtendimento;

    public FormularioCadastroMedico(String cpf, String nome, String sexo, String senha, Integer idade, String endereco, String crm, String competencia, UnidadeDeAtendimento unidadeDeAtendimento) throws FormException {
        super(cpf, nome, sexo, senha, idade, endereco);
        this.crm = crm;
        this.competencia = competencia;
        this.unidadeDeAtendimento = unidadeDeAtendimento;
        this.validarCampos();
    }

    private void validarCampos() throws FormException {
        this.validarCpf();
        this.validarSenha();
        this.validarCrm();
        this.validarIdade();
    }

    private void validarCpf() throws FormException {
        if (!this.getCpf().matches("^([0-9]){3}\\.([0-9]){3}\\.([0-9]){3}-([0-9]){2}$")) {
            throw new FormException("O CPF inserido é inválido");
        }
    }

    private void validarSenha() throws FormException {
        if (!this.getSenha().matches("^[a-zA-Z0-9]{12}$")) {
            throw new FormException("A senha só pode consistir de caracteres alfanuméricos");
        }
    }

    private void validarCrm() throws FormException {
        if (!this.getSenha().matches("^[0-9]{0,8}-[0-9]/[A-Z]{2}$")) {
            throw new FormException("O CRM inserido é inválido");
        }
    }

    private void validarIdade() throws FormException {
        if (this.getIdade() < 1) {
            throw new FormException("Idade inválida");
        };
    }

    public String getCrm() {
        return this.crm;
    }

    public String getCompetencia() {
        return this.competencia;
    }

    public UnidadeDeAtendimento getUnidadeDeAtendimento() {
        return this.unidadeDeAtendimento;
    }
}
