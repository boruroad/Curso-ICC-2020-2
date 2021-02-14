/**
 * Práctica 4: Listas.
 * Clase que implementa la interfaz ListaInterfaz.
 * Usamos también la clase Nodo.
 * @author Bonilla Ruíz Roberto Adrián.
 * @version 1.0
 */
public class ListaLigada implements ListaInterfaz{


	/** Cabeza de la lista. */
	private Nodo cabeza;

	/** Atributo que guarda el tamaño de nuestra lista. */
	private int tamanio;



	/**
    * Actividad 1.
    * Devuelve el tamaño de la lista.
    *
    * @return El tamaño de la lista. Si está vacía devuelve cero.
    */
	public int tamanio(){
		return tamanio;
	}


    /**
    * Actividad 2.
    * Devuelve la cola de la lista.
    *
    * @return Una lista con todos los elementos de le invocante menos el primero.
    */
    public ListaInterfaz cola(){
        ListaLigada nueva = new ListaLigada();
        cabeza = cabeza.getSiguiente();
        Nodo aux = cabeza;
        while(aux != null){
            aux = aux.getSiguiente();
        }
        tamanio--;
        return nueva;
    }


    /**
     * Actividad 3.
     * Inserta un elemento al principio de la lista, desplazando todos los
     * demás elementos.
     *
     * @param objeto El elemento a insertar.
     */
    public void insertaPrimero(Object objeto){
    	Nodo aux = cabeza;
    	Nodo nuevo = new Nodo(objeto);
    	nuevo.setSiguiente(aux);
    	cabeza = nuevo;
        tamanio++;
    }


    /**
    * Actividad 4.
    * Inserta un elemento en la posición especificada de la lista, desplazando 
    * todos los demás elementos.
    * 
    * @param objeto El elemento a insertar.
    * @param indice La posición donde se insertará el objeto. La posición debe
    *               ser mayor o igual a cero, y menor o igual al tamaño de la lista.
    */
    public boolean inserta(Object objeto, int indice){
        if(indice >= 0 && indice <= tamanio){  
            Nodo nuevo = new Nodo(objeto);
            if(indice == 0){ //si el elemento va al inicio de la lista.
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;
            } else {
                if(indice == tamanio){ //si el elemento va al final de la lista.
                    Nodo aux = cabeza;
                    while(aux.getSiguiente() != null){ 
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo); 
                } else {
                    Nodo aux = cabeza; //si el elemento a insertar va enmedio de la lista.
                    for(int i = 0; i < (indice -1); i++){
                        aux = aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
            }
            tamanio++;
            return true;
        }
        return false;
    }


    /**
    * Actividad 5.
    * Inserta un elemento al final de la lista.
    *
    * @param objeto el objeto a agregar a la lista.
    */
    public void insertaFinal(Object objeto){
    	Nodo nuevo = new Nodo(objeto);
        Nodo aux = cabeza;
    	if(cabeza== null) {
    		cabeza = nuevo; 
        }else{ 
    		while(aux.getSiguiente() != null){
    			aux = aux.getSiguiente();
    		}
    		aux.setSiguiente(nuevo); 
    	}
        tamanio++;
    }


    /**
     * Actividad 6.
     * Devuelve el primer elemento de la lista.
     * 
     * @return El primer elemento de la lista. Si la lista está vacía, devuelve null.
     */
    public Object obtenPrimero(){
    	if(cabeza == null){
    		return null;
    	}else{
    		Nodo aux = cabeza; 
    		return aux.getElemento();
    	}
    }


    /**
     * Actividad 7.
     * Devuleve el elemento en la posición especificada de la lista.
     * 
     * @param indice La posición donde se encuentra el objeto. La posición debe
     *               ser mayor o igual a cero, y menor al tamaño de la lista.
     * @return El elemento en la posición especificada. Si la posición es inválida
     *         devuelve null.
     */
    public Object obten(int indice){
    	if(indice > tamanio || indice < 0){
          return null;
        }else{
    		Nodo aux = cabeza;
            int contador = 0;
    		while(contador < indice){
                aux = aux.getSiguiente();
                contador++;
            } 
    	return aux.getElemento();
    	}	
	}


	/**
     * Actividad 8.
     * Elimina el primer elemento de la lista y actualiza la cabeza de la lista
     * Este metodo no va a regresar nada y tampoco va a recibir nada con parametros.
     */
    public void eliminaPrimero(){
    	if(cabeza == null)
    		return;
    	cabeza = cabeza.getSiguiente();
    	tamanio--;
    }


    /**
     * Actividad 9.
     * Elimina un elemento en la posición especificada de la lista, desplazando 
     * todos los demás elementos.
     * 
     * @param indice La posición donde se eliminará el objeto. La posición debe
     *               ser mayor o igual a cero, y menor al tamaño de la lista.
     */
    public void elimina(int indice){
    	if(indice == 0){
    		cabeza = cabeza.getSiguiente();
    	}else{
    		int contador = 0;
    		Nodo aux = cabeza;
    		while((contador < indice -1) && indice >= 0 && indice < tamanio){
    			aux = aux.getSiguiente();
    			contador++;
    		}
    		aux.setSiguiente(aux.getSiguiente().getSiguiente());
   		}
        tamanio--;
    }


    /**
     * Actividad 10.
     * Busca un elemento en la lista y devuelve la primera posición donde aparece.
     * 
     * @return El índice del objeto. Si no lo encuentra, devuelve -1.
     */
     public boolean busca(Object objeto){
        Nodo aux = cabeza;
        while(aux != null){
            if (objeto == aux.getElemento()){
                return true;
            }else{
                aux = aux.getSiguiente();
            }
        }
        return false;
    }

    @Override
    public int indice(Object objeto){ 
        if(busca(objeto)){
            Nodo aux = cabeza;
            int contador = 0;
            while(objeto != aux.getElemento()){
            contador++;
            aux = aux.getSiguiente();
            }
            return contador;
        } else {
            return -1;
        }
    }


	/**
     * Actividad 11.
     * Menciona si la lista no tiene elementos
     * 
     * @return true si la lista no tiene elementos, false en otro caso.
     */
    public boolean estaVacia(){
        if(cabeza == null){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Actividad 12.
     * Concatena la lista invocante con una nueva lista.
     * 
     * @param otra La lista con la que se concatenará.
     * @return La lista que resulta de la concatenación. Esta lista es independiente
     *         a las otras dos.
     */
    public ListaInterfaz concatena(ListaInterfaz otra){
        ListaLigada resultado = new ListaLigada();
        Nodo iterador = cabeza;
        while(iterador != null){
            resultado.insertaFinal(iterador.getElemento());
            iterador = iterador.getSiguiente();
        }
        ListaLigada auxiliar = (ListaLigada) otra;
        iterador = auxiliar.cabeza;
        while(iterador != null){
            resultado.insertaFinal(iterador.getElemento());
            iterador = iterador.getSiguiente();
        }
        return resultado;
    }


    /**
     * Actividad 13.
     * Vacia la lista. Elimina todos los elementos.
     */
    public void limpia(){
    	cabeza = null;
        tamanio=0;
    }


    /**
     * Metodo que permite imprimir en pantalla nuestra lista.
     */
    public void muestra(){
    	if(cabeza == null)
    		return;
    	Nodo iterador = cabeza;
        while(iterador != null){
            System.out.println(iterador.getElemento());
            iterador = iterador.getSiguiente();
        }
    }



    public static void main(String[] args) {
    	
    	ListaLigada lista = new ListaLigada();

        //trabajeremos con animales
    	System.out.println("\nPROBAR MÉTODOS CON ANIMALES.\n");

    	System.out.println("\n(Agregamos un nuevo animal al inicio de la lista)");
    	lista.insertaPrimero("Jirafa");
    	lista.muestra();
        System.out.println("\n(Agregamos un nuevo animal al inicio de la lista)");
        lista.insertaPrimero("Ornitorrinco");
        lista.muestra();
        System.out.println("\n(Agregamos un nuevo animal al inicio de la lista)");
        lista.insertaPrimero("Tiburón");
        lista.muestra();

        System.out.println("\n(Agregamos un nuevo animal en el índice 1)");
        lista.inserta("Pingüino", 1);
        lista.muestra();
        System.out.println("\n(Agregamos un nuevo animal en el índice 3)");
        lista.inserta("Cebra", 3);
        lista.muestra();
    
    	System.out.println("\n(Agregamos un nuevo animal al final de la lista)");
    	lista.insertaFinal("Tortuga");
    	lista.muestra();
         System.out.println("\n(Agregamos un nuevo animal al final de la lista)");
        lista.insertaFinal("Águila");
        lista.muestra();
        System.out.println("\n(Agregamos un nuevo animal al final de la lista)");
        lista.insertaFinal("Pijije");
        lista.muestra();

        System.out.println("\nEl tamaño de la lista es -> " + lista.tamanio()+"\n");
        
        System.out.println("\n(Devolveremos a los elementos de la lista menos al primero)\n");
        lista.cola();
        lista.muestra();

        System.out.println("\n(Eliminaremos al primer elemento de la lista)\n");
    	lista.eliminaPrimero();
    	lista.muestra();

    	System.out.println("\n(Eliminaremos un animal del índice 2 de la lista)\n");
    	lista.elimina(2);
    	lista.muestra();
        System.out.println("\nEl tamaño de la lista es -> " + lista.tamanio()+"\n");
    
        System.out.println("\nEl primer elemento de la lista es: " + lista.obtenPrimero());

        System.out.println("\nEl elemento en el índice 2 es: " + lista.obten(2) +"\n");
        System.out.println("\nEl elemento en el índice 4 es: " + lista.obten(4) +"\n");

        System.out.println("\n(Obtendremos el índice de algun elemento de la lista)\n");
        lista.muestra();
        System.out.println("\níndice de \"Ornitorrinco\": " + lista.indice("Ornitorrinco")+ "\n");
        System.out.println("\níndice de \"Águila\": " + lista.indice("Águila")+ "\n");
        System.out.println("\níndice de \"Pingüino\": " + lista.indice("Pingüino")+ "\n");
    

        ListaLigada lista2 = new ListaLigada();
        lista2.insertaPrimero("Karen");
        lista2.insertaPrimero("Juan");
        lista2.insertaPrimero("Lisseth");
        lista2.insertaPrimero("Carlos");
        System.out.println("\n**** Vamos a crear una lista nueva de nombres de personas ****");
        lista2.muestra();

        System.out.println("\nVamos a concatenar a la lista de animales con la lista de nombres de personas: \n");
        ListaLigada concatena = (ListaLigada) lista.concatena(lista2);
        concatena.muestra();

        System.out.println("\nEl tamaño de la lista es -> " + concatena.tamanio()+"\n");
        System.out.println("\n(Vamos a vaciar nuestra lista)\n");
        concatena.limpia();
        
        System.out.println("\n¿La lista está vacía? -> " + concatena.estaVacia()+"\n");
        System.out.println("\nEl tamaño de la lista es -> " + concatena.tamanio()+"\n");
 
    }
}