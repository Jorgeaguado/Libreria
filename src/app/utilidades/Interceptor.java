/*	PRACTICA 3 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.utilidades;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class Interceptor.
 */
@Component
@Aspect
public class Interceptor {

	/**
	 * Interceptar alta libro.
	 *
	 * @param jp
	 *            the jp
	 * @param result
	 *            the result
	 */
	@AfterReturning(pointcut = "execution(* app.persistencia.LibroDAO.altaLibro(..))", returning = "result")
	public void interceptarAltaLibro(JoinPoint jp, Object result) {
		if ((Boolean) result == true)
			System.out
					.println("[Clase Interceptor] El libro se ha insertado correctamente en la BBDD");
	}

}
