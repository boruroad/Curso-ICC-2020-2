/**
 * Proyecto 3: Listas.
 * En ésta clase creamos diversos métodos con ayuda de la clase "Nodo",
 * éstos métodos nos permitiran trabajar con nuestros alebrijes.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Lista{
    

//VARIABLES

	/** Cabeza de la lista. */
	private Nodo cabeza;

	/** Tamaño de la lista. */
	private int tamanio;


//CONSTRUCTOR

	/**
     * Constructor por defecto.
     */
	public void Lista(){
		cabeza = null;
		tamanio = 0;
	}



    /**
     * Método que devuelve el tamaño de la lista.
     */
	public int tamanio(){
		return tamanio;
	}


    /**
     * Método que inserta un elemento al principio de la lista
     */
    public void insertaPrimero(Object objeto){
    	if(cabeza== null){
    		cabeza = new Nodo(objeto);
    	} else {
    		Nodo temporal = cabeza;
    		Nodo nuevo = new Nodo(objeto);
    		nuevo.setSiguiente(temporal);
    		cabeza = nuevo;
    	}
    	tamanio++;
    }


    
    /**
     *Método que inserta un elemento en una posición específica de la lista.
     */
    public boolean inserta(Object objeto, int indice){
		boolean esposibleInsertar = false;
    		if(indice >= 0 && indice <= tamanio){  
    			Nodo nuevo = new Nodo(objeto);
    			if(indice == 0){ 
    				nuevo.setSiguiente(cabeza);
    				cabeza = nuevo;
    			} else {
    				if(indice == tamanio){ 
    					Nodo temporal = cabeza;
    					while(temporal.getSiguiente() != null){ 
    						temporal = temporal.getSiguiente();
    					}
    					temporal.setSiguiente(nuevo); 
    				} else {
	    				Nodo temporal = cabeza; 
    					for(int i = 0; i < (indice -1); i++){
    						temporal = temporal.getSiguiente();
    					}
    				   Nodo siguiente = temporal.getSiguiente();
    				    temporal.setSiguiente(nuevo);
                        nuevo.setSiguiente(siguiente);
    				}
    			}
                esposibleInsertar = true;
                tamanio++;
    		}
        return esposibleInsertar;
    }


    /**
     * Método que agrega un elemento al final de la lista.
     */
    public void insertaFinal(Object objeto){
       Nodo nuevo = new Nodo(objeto);
        if(cabeza== null){
            cabeza = nuevo; 
        } else {  
           Nodo temporal = cabeza; 
            while(temporal.getSiguiente() != null){
    			temporal = temporal.getSiguiente();
    		}
            temporal.setSiguiente(nuevo); 
    	}
        tamanio++; 
    }

    /**
     * Método que devuleve el elemento en la posición especificada de la lista.
     */
    public Object obten(int indice){
        if(indice > tamanio && indice < 0){
            return null;
        } else {
            Nodo temporal = cabeza;
            for (int i = 0; i < indice; i++){
    			temporal = temporal.getSiguiente();
    		}
        return temporal.getElemento();
    	}	
	}

    /**
     * Método que elimina un elemento en la posición especificada de la lista.
     */
    public void elimina(int indice){
        if(indice >= 0 && indice < tamanio){
            if(indice == 0){
                cabeza = cabeza.getSiguiente();
            }
            else{
                Nodo temporal = cabeza;
                for(int i = 0; i < indice -1; i++) {
                    temporal = temporal.getSiguiente();
                }
                Nodo siguiente = temporal.getSiguiente();
                temporal.setSiguiente(siguiente.getSiguiente());
            }
            tamanio--;
        }
    }
   
    /**
     * Método que imprime una lista
     */
    public void imprime(){
        if(cabeza== null){
            System.out.println("No hay elementos en la lista");
    		return;
        }
        int contador = 1;
    	for(Nodo iterador = cabeza; iterador != null; iterador = iterador.getSiguiente()){

            System.out.println("\n•[" + contador +"]  " +iterador.getElemento());
            contador++;
        }
    }

    /**
     * Método que elimina un alebrije a partir de un número dado en una lista
     * o catálogo de alebrijes, es decir borra ese elemento.
     */
    public void quita(int numero, Lista catalogo) {
        catalogo.elimina(numero - 1);
        System.out.println("(Se ha eliminado el elemento \""+ numero + "\" del catálogo)");
        catalogo.imprime();

    }
}


