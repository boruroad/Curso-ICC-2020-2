/**
 * Interfaz que define los metodos de
 * un analizador de cadenas.
 * @author Emmanuel Cruz Hernandez.
 * @version 1.0 Marzo de 2020.
 */
public interface AnalizadorDeCadenas{

    /**
     * Busca la primera aparicion de un caracter
     * especifico en una cadena.
     * @param cadena la cadena a recorrer.
     * @param c el caracter a buscar en la cadena.
     * @return el indice de la primera aparicion del
     * cararcter 'c' en la cadena. Si el caracter no
     * esta, se regresa -1.
     */
    public int encuentraPosicion(String cadena, char c);

    /**
     * Verifica si una cadena es un numero.
     * @param cadena la cadena a verificar si es numero.
     * @return true si la cadena es un numero, false el otro caso.
     */
    public boolean esNumero(String cadena);

    /**
     * Reemplaza todas las apariciones de un caracter 
     * en una cadena.
     * @param cadena la cadena a reemplazar los caracteres.
     * @param reemplazado el caracter a reemplazar.
     * @param reemplazador el caracter que va a reemplazar.
     * @return una cadena con todas las apariciones del
     * primer caracter reemplazado por el segundo.
     */
    public String reemplazaCaracter(String cadena, char reemplazado, char reemplazador);

    /**
     * Cuenta todas las apariciones de un caracter en una cadena.
     * @param cadena la cadena donde buscar las apariciones.
     * @param c el caracter a contabilizar en la cadena.
     * @return la cantidad de veces que aparece el caracter 'c'
     * en la cadena.
     */
    public int cuentaCaracter(String cadena, char c);

    /**
     * Verifica si una cadena es palindromo.
     * @param cadena verificar condicion.
     * @return true si la cadena es palindromo, false en otro caso.
     */
    public boolean esPalindromo(String cadena);

    /**
     * Verifica si una cadena contiene a otra.
     * @param cadena la cadena donde buscar la segunda cadena.
     * @param buscada la subcadena a buscar en la cadena.
     * @param true si cadena contiene la subcadena buscada.
     * @return 
     */
    public boolean contiene(String cadena, String buscada);

    /**
     * Verifica si dos cadenas son iguales lexicograficamente.
     * @param cadena1 la primera cadena a comparar.
     * @param cadena2 la segunda cadena a comparar.
     * @return true si ambas cadenas son iguales, false el otro caso.
     */
    public boolean sonIguales(String cadena1, String cadena2);

    /**
     * Da una subcadena de una cadena específica.
     * @param cadena la cadena de la cual obtener la subcadena.
     * @param inicio el indice de inicio de la subcadena.
     * @param fin el indice del final de la subcadena.
     * @return la subcadena desde el indice inicio al indice final.
     * En caso de pasar indices no validos regresar la cadena tal cual.
     */
    public String daSubcadena(String cadena, int inicio, int fin);

}