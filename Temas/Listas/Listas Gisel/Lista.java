import java.util.Iterator;
import java.lang.Exception;
import java.lang.Object;

/**
 * <p>
 * Clase concreta para modelar la estructura de datos Lista
 * </p>
 * <p>
 * Esta clase implementa una Lista genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 */
public class Lista<T> implements Listable<T>, Iterable<T> {

    /* Clase interna para construir la estructura */
    private class Nodo {
        /* Referencias a los nodos anterior y siguiente */
        public Nodo anterior, siguiente;
        /* El elemento que almacena un nodo */
        public T elemento;

        /* Unico constructor de la clase */
        public Nodo(T elemento) {
            this.elemento = elemento;
        }

        public boolean equals(Object o) {
            Nodo n = (Lista<T>.Nodo) o;
            return elemento.equals(n.elemento);
        }
    }

    private class IteradorLista<T> implements Iterator<T> {
        /* La lista a recorrer */
        /* Elementos del centinela que recorre la lista */
        private Lista<T>.Nodo siguiente;

        public IteradorLista() {
            siguiente = (Lista<T>.Nodo) cabeza;
        }

        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        @Override
        public T next() {
            T elemen = siguiente.elemento;
            siguiente = siguiente.siguiente;
            return elemen;
        }

        @Override
        public void remove() {
            Iterator.super.remove(); // To change body of generated methods, choose Tools | Templates.
        }
    }

    /* Atributos de la lista */
    private Nodo cabeza, cola;
    private int longitud;

    /**
     * Constructor por omisión de la clase, no recibe parámetros. Crea una nueva
     * lista con longitud 0.
     **/
    public Lista() {
        longitud = 0;
        cabeza = null;
        cola = null;
    }

    /**
     * Constructor copia de la clase. Recibe una lista con elementos. Crea una nueva
     * lista exactamente igual a la que recibimos como parámetro.
     **/
    public Lista(Lista<T> l) {
        Lista<T> nueva = l.copia();
        this.longitud = nueva.longitud;
        this.cabeza = nueva.cabeza;
        this.cola = nueva.cola;
    }

    /**
     * Constructor de la clase que recibe parámetros. Crea una nueva lista con los
     * elementos de la estructura iterable que recibe como parámetro.
     **/
    public Lista(Iterable<T> iterable) {
        longitud = 0;
        cabeza = null;
        cola = null;
        for (T elem : iterable)
            agregar(elem);
    }

    /**
     * Método que nos dice si las lista está vacía.
     * 
     * @return <code>true</code> si el conjunto está vacío, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        return longitud == 0;

    }

    /**
     * Método para eliminar todos los elementos de una lista
     */
    public void vaciar() {
        longitud = 0;
        cabeza = null;
        cola = null;
    }

    /**
     * Método para obtener el tamaño de la lista
     * 
     * @return tamanio Número de elementos de la lista.
     **/
    public int longitud() {
        return longitud;

    }

    /**
     * Método para agregar un elemento a la lista.
     * 
     * @param elemento Objeto que se agregará a la lista.
     */
    public void agregar(T elemento) {
        agregarAlInicio(elemento);
    }

    /**
     * Método para agregar al inicio un elemento a la lista.
     * 
     * @param elemento Objeto que se agregará al inicio de la lista.
     */
    public void agregarAlInicio(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (esVacia()) {
            cabeza = cola = nuevo;
        } else {
            cabeza.anterior = nuevo;
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
        longitud++;
    }

    /**
     * Método para agregar al final un elemento a la lista.
     * 
     * @param elemento Objeto que se agregará al inicio de la lista.
     */
    public void agregarAlFinal(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (esVacia()) {
            cabeza = cola = nuevo;
            longitud++;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
            longitud++;
        }
    }

    /**
     * Método para buscar el nodo que contiene un elemento
     * 
     * @param elem objeto que contiene el nodo
     * @return el nodo donde se encuentra el elemento que le pasamos como parametro
     */
    public Nodo buscaNodo(T elem) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.elemento.equals(elem))
                return aux;
            aux = aux.siguiente;
        }
        return null;
    }

    /**
     * Método para verificar si un elemento pertenece a la lista.
     * 
     * @param elemento Objeto que se va a buscar en la lista.
     * @return <code>true</code> si el elemento esta en el lista y false en otro
     *         caso.
     */
    public boolean contiene(T elemento) {
        return buscaNodo(elemento) != null;
    }

    /**
     * Método para eliminar un elemento de la lista.
     * 
     * @param elemento Objeto que se eliminara de la lista.
     */
    public void eliminar(T elemento) {
        Nodo n = buscaNodo(elemento);
        if (n != null) {
            if (longitud == 1) {
                vaciar();
                return;
            } else {
                if (n == cabeza) {
                    cabeza = cabeza.siguiente;
                    cabeza.anterior = null;
                } else if (n == cola) {
                    cola = cola.anterior;
                    cola.siguiente = null;
                } else {
                    n.anterior.siguiente = n.siguiente;
                    n.siguiente.anterior = n.anterior;
                }
                longitud--;
            }
        }
    }

    /**
     * Método que devuelve la posición en la lista que tiene la primera aparición
     * del <code> elemento</code>.
     * 
     * @param elemento El elemnto del cuál queremos saber su posición.
     * @return i la posición del elemento en la lista, -1, si no se encuentra en
     *         ésta.
     */
    public int indiceDe(T elemento) {
        if (contiene(elemento) != false) {
            Nodo aux = new Nodo(elemento);
            int contador = 0;
            for (T elem : this) {
                while (elem.equals(aux.elemento) == false) {
                    contador++;
                }
            }
            return contador;
        }
        return -1;
    }

    /**
     * Método que nos dice en qué posición está un elemento en la lista
     * 
     * @param i La posición cuyo elemento deseamos conocer.
     * @return <code> elemento </code> El elemento que contiene la lista,
     *         <code>null</code> si no se encuentra
     * @throws IndexOutOfBoundsException Si el índice es < 0 o >longitud()
     */
    public T getElemento(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("Indice invalido.");
        }
        int contador = 0;
        for (T elem : this) {
            if (contador++ == i)
                return elem;
        }
        return null;
    }

    /**
     * Método que devuelve una copia de la lista, pero en orden inverso
     * 
     * @return Una copia con la lista l revés.
     */
    public Lista<T> reversa() {
        Lista<T> nueva = new Lista<>();
        Nodo aux = cola;
        while (cola != null) {
            nueva.agregarAlFinal(cola.elemento);
            cola = cola.anterior;
        }
        return nueva;
    }

    /**
     * Método que devuelve una copi exacta de la lista
     * 
     * @return la copia de la lista.
     */
    public Lista<T> copia() {
        Lista<T> nueva = new Lista();
        for (T elem : this)
            nueva.agregarAlFinal(elem);
        return nueva;
    }

    /**
     * Método que nos dice si una lista es igual que otra.
     * 
     * @param o objeto a comparar con la lista.
     * @return <code>true</code> si son iguales, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object o) {
        Lista l = (Lista<T>) o;
        if (longitud != l.longitud)
            return false;
        Nodo aux = cabeza;
        Nodo aux1 = l.cabeza;
        while (aux != null) {
            if (!aux.elemento.equals(aux1.elemento))
                return false;
            aux = aux.siguiente;
            aux1 = aux1.siguiente;
        }
        return true;
    }

    /**
     * Método que devuelve un iterador sobre la lista
     * 
     * @return java.util.Iterador -- iterador sobre la lista
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new IteradorLista();

    }

    public <T extends Comparable> Lista<T> merge(Lista<T> l1, Lista<T> l2) {
        Lista<T> l = new Lista<>();
        Lista<T>.Nodo aux = l1.cabeza;
        Lista<T>.Nodo aux1 = l2.cabeza;
        while (aux != null && aux1 != null) {
            if ((aux.elemento).compareTo(aux1.elemento) < 0) {
                l.agregarAlFinal(aux.elemento);
                aux = aux.siguiente;
            } else {
                l.agregarAlFinal(aux1.elemento);
                aux1 = aux1.siguiente;
            }
        }
        while (aux != null) {
            l.agregarAlFinal(aux.elemento);
            aux = aux.siguiente;
        }
        while (aux1 != null) {
            l.agregarAlFinal(aux1.elemento);
            aux1 = aux1.siguiente;
        }
        return l;
    }

    /**
     * Método que devuelve una copia de la lista.
     * 
     * @param <T> Debe ser un tipo que extienda Comparable, para poder distinguir el
     *            orden de los elementos en la lista.
     * @param l   La lista de elementos comparables.
     * @return copia de la lista ordenada.
     */
    public static <T extends Comparable<T>> Lista<T> mergesort(Lista<T> l) {
        if (l.longitud < 2) {
            return l;
        }
        int contador = 0;
        Lista l1 = new Lista<>();
        Lista l2 = new Lista<>();
        for (T elem : l) {
            if (contador++ < l.longitud / 2) {
                l1.agregarAlFinal(elem);
            } else {
                l2.agregarAlFinal(elem);
            }
        }
        return l.merge(mergesort(l1), mergesort(l2));
    }

    @Override
    public String toString() {
        String cadena = new String("[");
        for (T elem : this) {
            cadena += elem.toString();
            if (elem != cola.elemento) {
                cadena += ", ";
            }
        }
        cadena = cadena + "]";
        return cadena;
    }

}
