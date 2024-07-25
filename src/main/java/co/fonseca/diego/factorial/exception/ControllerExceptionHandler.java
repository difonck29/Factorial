package co.fonseca.diego.factorial.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;



@RestControllerAdvice
public class ControllerExceptionHandler {
  

    @ExceptionHandler({ FactorialException.class, MethodArgumentTypeMismatchException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequestException(RuntimeException ex,WebRequest request) {
        ErrorMessage message = new ErrorMessage(
          HttpStatus.BAD_REQUEST.value(),
          new Date(),
          ex.getMessage(),
          request.getDescription(false));
      
      return message;
    }

}