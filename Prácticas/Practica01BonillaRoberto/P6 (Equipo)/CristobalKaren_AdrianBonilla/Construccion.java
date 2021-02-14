/**
 * Clase que simula una construcción
 * @author Pedro Ulises Cervantes González
 * @version 1.0
 */

public class Construccion {

//ATRIBUTOS
    /** El precio base de un terreno baldío*/
    protected static double precioBase = 200000;

    /** El precio actual de la construcción*/
    protected double precioActual;

    /** La zona de construcción donde estará*/
    protected ZonaConstruccion zona;



//MÉTODO CONSTRUCTOR.

    /**
     * Crea una nueva construcción.
     * @param zona La zona donde estará
     */
    public Construccion(ZonaConstruccion zona){
	    this.zona = zona;
        this.precioActual = this.precioBase;
    }

//MÉTODOS DE ACCESO

    /**
     * Permite acceder al precio base de una construcción.
	   * @return precio base de la construcción.
	   */
    public double getPrecioBase(){
	    return this.precioBase;
    }

    /**
     * Permite acceder al precio actual de una construcción.
	   * @return precio actual de la construcción.
	   */
    public double getPrecioActual(){
	  	return this.precioActual;
    }


//MÉTODOS DE MODIFICACIÓN
    /**
     * Permite modificar el precio base de una construcción.
	   * @param precio base de la construcción a modificar.
	   */
    public void setPrecioBase(double precioBase){
		  this.precioBase = precioBase;
    }

    /**
     * Permite modificar el precio actual de una construcción.
	   * @param precio actual de la construcción a modificar.
	   */
    public void setPrecioActual(double precioActual){
		  this.precioActual = precioActual;
    }

//MÉTODOS DE LA CLASE.

     /**
     * Devuelve una represetnación de arreglos de cadenas
     * de la construcción.
     *
     * @return Un arreglo de cadenas en el que mientras mayor
     *         es el índice i, más arriba se está en la construcción.
     */
    public String[] toStringArray(){
	    return new String[]{"TTTTTTTTTT"};
    }

    /**
     * Recalcula el precio actual.
     */
    protected void recalculaPrecioActual(){}


    /**
     * Devuelve una cadena que representa el cielo.
     *
     * @return Una cadena de espacios tan larga como el ancho
     *         de la construcción
     */
    public static String cielo(){
	   return "          ";
    }


    @Override
    public String toString() {
            return "Precio base: "+ this.precioBase + "\nCosto devaluado: " + this.precioActual ;
    }
}
