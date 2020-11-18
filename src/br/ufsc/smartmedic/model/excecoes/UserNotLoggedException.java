package br.ufsc.smartmedic.model.excecoes;

public class UserNotLoggedException extends Exception {
    public UserNotLoggedException(String message) {
        super(message);
    }
}
