/**
 * Clase Nodo.
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristobal Morales Karen.
 * @version 1.0
 */

public class Nodo{


// ATRIBUTOS

	/** Valor del nodo. */
	private Object elemento;

	/** Nodo siguiente. */
	private Nodo siguiente;


// CONSTRUCTOR

	/**
	 * Construye un nuevo Nodo.
	 * @param valor el valor del nodo.
	 */
	public Nodo(Object valor){
		this.elemento = valor;
		siguiente = null;
	}


// MÉTODOS DE ACCESO

	/** Permite acceder al valor del nodo.
	 * @return el valor del nodo.
	 */
	public Object getElemento(){
		return this.elemento;
	}


	/** Permite acceder al nodo siguiente.
	* @return el nodo siguiente.
	*/
	public Nodo getSiguiente(){
		return this.siguiente;
	}


// MÉTODO DE MODIFICACIÓN

	/** Permite modificar la referencia de un nodo siguiente.
	* @param nuevo el nuevo nodo siguiente.
	*/
	public void setSiguiente(Nodo nuevo){
		this.siguiente = nuevo;
	}
}
