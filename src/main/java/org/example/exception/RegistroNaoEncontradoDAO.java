package org.example.exception;

public class RegistroNaoEncontradoDAO extends RuntimeException {
    public RegistroNaoEncontradoDAO(String message) {
        super(message);
    }
}
