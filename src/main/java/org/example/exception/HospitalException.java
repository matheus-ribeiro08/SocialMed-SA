package org.example.exception;

public class HospitalException extends RuntimeException {
    private static final long seriaVersionUID = 1L;

    public HospitalException(){
        super();
    }

    public HospitalException(String message, Throwable cause){
        super(message, cause);
    }

    public HospitalException(String message){
        super(message);
    }

    public HospitalException(Throwable cause){
        super(cause);
    }
}
