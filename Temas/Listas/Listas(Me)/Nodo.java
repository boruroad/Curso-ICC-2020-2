/**
 * Estoy parcticando listas
 * Para ello crearemos un nodo antes
 * @author Bonilla Ruiz Roberto Adrián
 * @version 1.0  
 **/


public class Nodo {
	/** Haremos una lista de enteros */

	/** Para ver lo que tiene el nodo */
	private Object elemento;

	/** Tener un nodo siguiente */
	private Nodo siguiente;


	/**
	* Creamos un nodo  (Método constructor)
	* @param valor el valor del nodo
	*/
	public Nodo(Object valor){
		this.elemento = valor;
		siguiente = null;
	}

	/**
	* Acceder al elemento del nodo, es decir su valor
	* @return el valor del nodo
	*/
	public Object getElemento(){
		return this.elemento;
	}


	/**
	* Acceder al nodo siguiete
	* @return el nodo siguiente 
	*/
	public Nodo getNodoSiguiente(){
		return this.siguiente;
	}

	/**
	* Modificar la referencia de un nodo siguiete
	* @param nuevo el nuevo nodo que esta siguiente 
	*/
	public void setNodoSiguiente(Nodo nuevo){
		this.siguiente = nuevo;
	}




	


	
}