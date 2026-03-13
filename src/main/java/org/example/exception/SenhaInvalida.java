package org.example.exception;

public class SenhaInvalida extends RuntimeException {
    public SenhaInvalida(String message) {

        super(message);
    }
}
