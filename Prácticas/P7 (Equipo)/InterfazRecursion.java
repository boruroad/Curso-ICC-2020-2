/**
 * Interfaz que define operaciones 
 * para la practica 7 de ICC.
 * @author Emmanuel Cruz Hernandez.
 * @version 1.0 mayo 2020.
 */

public interface InterfazRecursion{

    /**
     * Verifica si una cadena es palindromo.
     * @param cadena verificar condicion.
     * @return true si la cadena es palindromo, false en otro caso.
     */
    public boolean esPalindromo(String cadena);

    /**
     * Reemplaza todas las apariciones de un caracter 
     * en una cadena.
     * @param cadena la cadena a reemplazar los caracteres.
     * @param reemplazado el caracter a reemplazar.
     * @param reemplazador el caracter que va a reemplazar.
     * @return una cadena con todas las apariciones del
     * primer caracter reemplazado por el segundo.
     */
    public String reemplazaCaracter(String cadena, String reemplazado, String reemplazador);

    /**
     * Cuenta todas las apariciones de un caracter en una cadena.
     * @param cadena la cadena donde buscar las apariciones.
     * @param c el caracter a contabilizar en la cadena.
     * @return la cantidad de veces que aparece el caracter 'c'
     * en la cadena.
     */
    public int cuentaCaracter(String cadena, char c);

    /**
     * Calcula un elemento de la serie de fibonacci.
     * @param n el numero de la serie de fibonacci a calcular.
     * @return el resultado de calcular fibonacci de n.
     */
    public int fibonacci(int n);

    /**
     * Construye tantos niveles del triángulo de Pascal como se soliciten.
     * @param n la cantidad de niveles del triangulo a construir.
     * @return un arreglo con la representación del tríangulo de pascal
     * con n niveles.
     */
    //public int[][] pascal(int n);
}
