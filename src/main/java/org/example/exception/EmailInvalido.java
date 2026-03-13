package org.example.exception;

public class EmailInvalido extends RuntimeException {
    public EmailInvalido(String message) {

      super(message);
    }
}
