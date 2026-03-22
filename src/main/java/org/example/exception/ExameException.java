package org.example.exception;

public class ExameException extends RuntimeException {

    private static final long seriaVersionUID = 1L;

    public ExameException(){
        super();
    }

    public ExameException(String message, Throwable cause){
        super(message, cause);
    }

    public ExameException(String message){
        super(message);
    }

    public ExameException(Throwable cause){
        super(cause);
    }
}