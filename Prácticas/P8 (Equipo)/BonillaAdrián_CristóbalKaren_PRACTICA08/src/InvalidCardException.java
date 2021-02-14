/**
 * Ésta clase es una excepción la cual será lanzada en caso de que el usuario quiera voltear
 * la misma carta, ó cuando quiera voltear una carta cuyo símbolo ya es visible.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */
public class InvalidCardException extends Exception {
	public InvalidCardException(String causa){
		super(causa);
	}
}
