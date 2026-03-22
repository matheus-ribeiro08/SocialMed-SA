package org.example.exception;

public class SecretarioException extends RuntimeException {


  private static final long seriaVersionUID = 1L;

  public SecretarioException(){
    super();
  }

  public SecretarioException(String message, Throwable cause){
    super(message, cause);
  }

  public SecretarioException(String message){
    super(message);
  }

  public SecretarioException(Throwable cause){
    super(cause);
  }
}
