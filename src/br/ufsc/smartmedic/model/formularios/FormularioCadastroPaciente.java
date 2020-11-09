package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.excecoes.FormException;

public class FormularioCadastroPaciente extends FormularioCadastro {

    public FormularioCadastroPaciente(String cpf, String nome, String sexo, String senha, String nascimento, String endereco, TipoUsuario tipoUsuario) throws FormException {
        super(cpf, nome, sexo, senha, nascimento, endereco, tipoUsuario);
        this.validarCampos();
    }

    private void validarCampos() throws FormException {
        this.validarCpf();
        this.validarSenha();
        this.validarNascimento();
    }

    private void validarNascimento() throws FormException {
        if (!this.getNascimento().matches("^([0-9]){2}/([0-9]){2}/([0-9]){1,4}$")) {
            throw new FormException("A data de nascimento deve ser formatada como xx/xx/xxxx");
        }
    }

    private void validarCpf() throws FormException {
        if (!this.getCpf().matches("^([0-9]){3}\\.([0-9]){3}\\.([0-9]){3}-([0-9]){2}$")) {
            throw new FormException("O cpf inserido é inválido");
        }
    }

    private void validarSenha() throws FormException {
        if(!this.getSenha().matches("^[a-zA-Z0-9]{4,12}$")) {
            throw new FormException("A senha deve ser constituída de 4 à 12 caracteres alfanuméricos");
        }
    }

}
