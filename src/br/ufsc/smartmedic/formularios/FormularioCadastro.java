package br.ufsc.smartmedic.formularios;

public class FormularioCadastro implements Formulario{
    private final String cpf;
    private final String nome;
    private final String sexo;
    private final String senha;
    private final Integer idade;
    private final String endereco;

    public FormularioCadastro(String cpf, String nome, String sexo, String senha, Integer idade, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.senha = senha;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSenha() {
        return senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

}
