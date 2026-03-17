package org.example.exception;

public class ConsultaException extends RuntimeException {
    public ConsultaException(String message) {
        super(message);
    }

    public ConsultaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}

