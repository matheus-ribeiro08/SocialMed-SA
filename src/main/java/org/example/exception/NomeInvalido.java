package org.example.exception;

public class NomeInvalido extends RuntimeException {
    public NomeInvalido(String message) {
        super(message);
    }
}
