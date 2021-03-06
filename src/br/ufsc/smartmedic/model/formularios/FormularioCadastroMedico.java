package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.excecoes.FormException;

public class FormularioCadastroMedico extends FormularioCadastro {
    private final String crm;
    private final String competencia;
    private final String unidadeAtendimento;

    public FormularioCadastroMedico(String cpf, String nome, String sexo, String senha, String nascimento, String endereco, String crm, String competencia, String unidadeAtendimento, TipoUsuario tipoUsuario) throws FormException {
        super(cpf, nome, sexo, senha, nascimento, endereco, tipoUsuario);
        this.crm = crm;
        this.competencia = competencia.toLowerCase().trim();
        this.unidadeAtendimento = unidadeAtendimento;
        this.validarCampos();
    }

    private void validarCampos() throws FormException {
        this.validarCpf();
        this.validarSenha();
        this.validarCrm();
    }

    private void validarCpf() throws FormException {
        if (!this.getCpf().matches("^([0-9]){3}\\.([0-9]){3}\\.([0-9]){3}-([0-9]){2}$")) {
            throw new FormException("O CPF inserido é inválido");
        }
    }

    private void validarSenha() throws FormException {
        if (!this.getSenha().matches("^[a-zA-Z0-9]{4,12}$")) {
            throw new FormException("A senha deve ser constituída de 4 à 12 caracteres alfanuméricos");
        }
    }

    private void validarCrm() throws FormException {
        if (!this.getCrm().matches("^[0-9]{0,8}-[0-9]/[A-Z]{2}$")) {
            throw new FormException("O CRM inserido é inválido");
        }
    }

    public String getCrm() {
        return this.crm;
    }

    public String getCompetencia() {
        return this.competencia;
    }

    public String getUnidadeAtendimento() {
        return this.unidadeAtendimento;
    }
}
