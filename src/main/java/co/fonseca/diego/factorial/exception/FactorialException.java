package co.fonseca.diego.factorial.exception;

public class FactorialException extends RuntimeException{
    private static final long serialVersionUID = 1L;
  
    public FactorialException(String msg) {
      super(msg);
    }
}
