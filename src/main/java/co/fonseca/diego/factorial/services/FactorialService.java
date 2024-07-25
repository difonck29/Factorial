package co.fonseca.diego.factorial.services;

import org.springframework.stereotype.Service;

import co.fonseca.diego.factorial.exception.FactorialException;

@Service
public class FactorialService {

    public long calcularFactorial(long numero){
        if(numero < 0){
            throw new FactorialException("El número debe ser entero positivo");
        }
        long factorial = 0;
        if(numero >= 0){
            factorial = 1;
            if(numero == 0 || numero == 1){
                factorial = 1;
            }else{
                for(int i = 2 ;i <= numero; i++){
                    factorial *= i;
                }
            }
        }
        return factorial;
    }
}
