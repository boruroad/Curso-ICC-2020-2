/**
 * Ésta clase es una excepción la cual será lanzada en caso de que el usuario ingrese una
 * opción que está fuera de un rango numérico determinado.
 * @author Bonilla Ruíz Roberto Adrián.
 * @version 1.0
 */
public class InvalidNumberException extends Exception {

	public InvalidNumberException(String causa){
		super(causa);
	}
}
