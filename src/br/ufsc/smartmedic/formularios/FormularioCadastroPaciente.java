package br.ufsc.smartmedic.formularios;

public class FormularioCadastroPaciente extends FormularioCadastro {

    public FormularioCadastroPaciente(String cpf, String nome, String sexo, String senha, Integer idade, String endereco) {
        super(cpf, nome, sexo, senha, idade, endereco);
        this.validarCampos();
    }

    //TODO: validacao cpf, endereco, senha
    private void validarCampos() {

    }
}
