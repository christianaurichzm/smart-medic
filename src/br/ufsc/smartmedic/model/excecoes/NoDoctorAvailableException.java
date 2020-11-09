package br.ufsc.smartmedic.model.excecoes;

public class NoDoctorAvailableException extends Exception {
    public NoDoctorAvailableException(String message) {
        super(message);
    }
}
