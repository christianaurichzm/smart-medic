package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.excecoes.FormException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioCadastroPaciente extends FormularioCadastro {

    public FormularioCadastroPaciente(String cpf, String nome, String sexo, String senha, Integer idade, String endereco) throws FormException {
        super(cpf, nome, sexo, senha, idade, endereco);
        this.validarCampos();
    }

    //TODO: validacao cpf, endereco, senha
    private void validarCampos() throws FormException {
        this.validarCpf();
        this.validarSenha();
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
}
