/**
 * Interfaz que define acciones
 * sobre matrices.
 * @author Emmanuel Cruz Hernandez.
 * @version 1.0 Abril 2020.
 */
public interface InterfazArreglos{
	
    /**
     * Regresa el espejo de una matriz.
     * @param arreglo el arreglo a calcular su espejo.
     * @return Un arreglo con la representación de la
     * matriz espejo del parámetro.
     */
    public int[][] espejo(int[][] arreglo);

    /**
     * Verifica si un tablero del juego gato tiene una partida ganada.
     * Los caracteres permitidos para almacenar en este arreglo son:
     * 'O' para el jugador 1
     * 'X' para el jugador 2
     * '-' para las casillas vacías.
     * @param tablero el tablero con la partida de gato.
     * @return O si el jugador 1 tiene una partida ganada.
     * X si el jugador 2 tiene una partida ganada
     * E en caso de empate
     * N en caso de no existir ganador
     */
    public char gato(char[][] tablero);

    /**
     * Crea una cadena a partir de un arreglo bidimensional de caracteres
     * Cada subarreglo será una palabra en la frase.
     * Cada palabra estará separada por un espacio.
     * @param frase el arreglo con la frase.
     * @return la frase formada a partir de caracteres.
     */
    public String construyeFrase(char[][] frase);

    /**
     * Separa números impares de pares.
     * @param numeros un arreglo de numeros enteros.
     * @return un arreglo bidimensional con los numeros separados
     */
    public int[][] separaNumeros(int[] numeros);

    /**
     * Encuentre el número más repetido en un arreglo.
     * @param numeros un arreglo de numeros enteros.
     * @return el entero más repetido del arreglo.
     */
    public int masRepetido(int[] numeros);

    /**
     * Permite saber si todos los elementos de un arreglo están contenidos en otro.
     * @param contenido un arreglo de numeros enteros
     * @param contenedor un arreglo donde verificar si el arreglo
     * contiene todos los elementos de contenido.
     * @return true si contiene todos los elementos, false en otro caso.
     */
    public boolean estaContenido(int[] contenido, int[] contenedor);

    /**
     * Construye tantos niveles del triángulo de Pascal como se soliciten.
     * @param n la cantidad de niveles del triangulo a construir.
     * @return un arreglo con la representación del tríangulo de pascal
     * con n niveles.
     */
    public int[][] pascal(int n);

    /**
    * Elimina los elementos repetidos de un arreglo.
    * @param arreglo el arreglo del cual eliminar repetidos.
    * @return un arreglo sin elementos repetidos.
    */
    public int[] colapsa(int[] arreglo);

}
