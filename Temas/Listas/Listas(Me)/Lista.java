/**
 * Estoy parcticando listas
 * Lista ligada
 * @author Bonilla Ruiz Roberto Adrián
 * @version 1.0  
 **/

public class Lista{


	/**Creamos una cabeza para nuestra lista*/
	private Nodo cabeza;
	private int tamanio;

	/**Añadir un nuevo elemento al comienzo de la lista
	 * @param elemento (lo que va a guardar el Nodo el la posicion cero)
	 **/

	public void agrega(Object elemento){
		Nodo nuevo = new Nodo(elemento);
		nuevo.setNodoSiguiente(cabeza);
		cabeza = nuevo;
		tamanio ++;
		
	}

	/**Eliminar el elemento al comienzo de la lista**/

	public void eliminaPrimero(){
		if(cabeza== null){
			return;
		}
		cabeza=cabeza.getNodoSiguiente();
		tamanio --;
	}

	

	/** Regresa el tamaño de la lista**/
	public int tamanio(){
		return tamanio;
	}



	/**Para determinar si una lista es vacia*/
	public boolean esVacia(){
		boolean a = (cabeza == null) ? true:false;
		return a;
	}


	/**Imprimir los valores de la lista */
	public void muestra(){
		if(tamanio == 0){
			System.out.println("Aqui no hay nada ");
			return;
		}
		
		/**Nodo iterador = cabeza;
		while(iterador != null){
			System.out.println(iterador.getElemento());
			iterador = iterador.getNodoSiguiente();
		}*/

		for(Nodo iterador = cabeza; iterador!= null;iterador =iterador.getNodoSiguiente()){
			System.out.println(iterador.getElemento());
		}
	}


	public static void main(String[] args) {
		Integer a = 5;
		Integer b = 7;
		Integer c = 2;
		Integer d = 1;
		Integer e = 26;

	Lista lista = new Lista();

	System.out.println("La lista es: ");
	/**Agregamos elementos**/
	lista.agrega(a);
	lista.agrega(b);
	lista.agrega(c);
	lista.agrega(d);
	lista.agrega(e);

	lista.muestra();
	System.out.println("\nEL tamaño de la lista es: "+lista.tamanio());

	lista.eliminaPrimero();

	System.out.println("Eliminando el primer elemento y mostarndo de nuevo la lista, tenemos: ");
	lista.muestra();

	System.out.println("\nEl tamaño de la lista eliminando el primero es: "+lista.tamanio());
	System.out.println("La lista es vacia: "+lista.esVacia());


		lista.eliminaPrimero();
			lista.eliminaPrimero();
				lista.eliminaPrimero();
	System.out.println("\nEl tamaño de la lista eliminando los 3 primeros elementos es: "+lista.tamanio());
	lista.muestra();


		


	}











}	
