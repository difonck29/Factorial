package co.fonseca.diego.factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;

import co.fonseca.diego.factorial.exception.FactorialException;
import co.fonseca.diego.factorial.services.FactorialService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FactorialApplicationTests {

	@InjectMocks
  	private FactorialService factorialService;

	@DisplayName("JUnit para 0 y 1")
	@Test
	void factorial() {
		long factorial = factorialService.calcularFactorial(0);
		System.out.println("Entro");
		assertEquals(1,factorial);
	}

	@DisplayName("JUnit para 6")
	@Test
	void factorial6() {
		long factorial = factorialService.calcularFactorial(6);
		System.out.println("Entro");
		assertEquals(720,factorial);
		
	}

	@DisplayName("JUnit para números negativos")

	@Test
	void factorialNegativo() {
    Exception exception = assertThrows(FactorialException.class, () -> {
        factorialService.calcularFactorial(-2);
    });

    String expectedMessage = "El número debe ser entero positivo";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
}

}
