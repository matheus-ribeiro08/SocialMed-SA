package org.example.exception;

public class MedicoException extends RuntimeException {

  private static final long seriaVersionUID = 1L;

  public MedicoException(){
     super();
  }

  public MedicoException(String message, Throwable cause){
    super(message, cause);
  }

  public MedicoException(String message){
    super(message);
  }

  public MedicoException(Throwable cause){
    super(cause);
  }

}
