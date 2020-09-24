package br.ufsc.smartmedic.controller;

import br.ufsc.smartmedic.model.excecoes.FormException;

public class ControladorUsuario {
    public ControladorUsuario() {

    }

    public void RealizarCadastro(FormularioCadastroDTO form) throws FormException {
        this.validateUniqueness(form);


    }

    private void validateUniqueness(FormularioCadastroDTO form) throws FormException {
        if (!unique) {
            throw new FormException("Este cpf já está cadastrado");
        }
    }

//    private void load(){
//        try {
//            FileInputStream fin = new FileInputStream(filename);
//            ObjectInputStream oi = new ObjectInputStream(fin);
//            this.cachePessoas = (HashMap<String, Pessoa>) oi.readObject();
//
//            oi.close();
//            fin.close();
//        } catch (ClassNotFoundException x){
//            System.out.println("Arquivo invalido");
//            persist();
//        } catch (FileNotFoundException ex){
//            System.out.println("Arquivo nao encontrado");
//        } catch (IOException e){
//            System.out.println(e);
//        }
//    }
}
