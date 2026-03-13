package org.example.exception;

public class CpfInvalido extends RuntimeException {
    public CpfInvalido(String message) {
        super(message);
    }
}
