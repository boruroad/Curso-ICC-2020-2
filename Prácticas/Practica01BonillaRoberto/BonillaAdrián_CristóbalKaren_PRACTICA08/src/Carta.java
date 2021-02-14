/**
 * Clase Carta.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Carta {

//ATRIBUTOS

	/** Atributo que represente el símbolo o la figura que tiene la carta. */
	public String simbolo;

	/** Atributo que permite saber si la figura de la carta está visible o no. */
	public boolean esVisible;


//MÉTODOS CONSTRUCTORES

	/**
     * Construye a una Carta.
     * @param simbolo el símbolo de una carta.
     */
	public Carta (String simbolo){
		this.simbolo = simbolo;
		this.esVisible = esVisible;
	}

	/**
     * Construye a una Carta.
     * @param simbolo el símbolo de una carta.
     * @param visible la visibilidad de la carta.
     */
	public Carta (String simbolo, boolean visible){
		this.simbolo = simbolo;
		this.esVisible = visible;
	}

//MÉTODOS DE ACCESO

	/**
     * Permite saber el símbolo de la carta.
     * @return el simbolo de la carta.
     */
    public String getSimbolo(){
        return this.simbolo;
	}

    /**
     * Permite saber el estado de visibilidad de la carta.
     * @return el estado de visibilidad de la carta
     */
    public boolean getEsVisible(){
        return this.esVisible;
	}

//MÉTODOS DE MODIFICACIÓN

	/**
     * Modifica la visibilidad de la carta.
     * @param carta con su respectiva visibilidad.
     */
    public void setEsVisible(boolean esVisible){
	    this.esVisible = esVisible;
	}

	/**
     * Modifica el simbolo  de la carta.
     * @param carta con su respectivo simbolo.
     */
    public void setSimbolo(String simbolo){
	    this.simbolo = simbolo;
	}

	/**
	 * Método que nos permite cambiar el estado de visibilidad del simbolo de una carta.
	 * @return true si la carta es visible, false en otro caso.
	 */
	public boolean cambiaEstado(){
		this.esVisible = !this.esVisible;
		return this.esVisible;
	}

	@Override
	public String toString(){
		String purple = "\033[35m";
   	String reset = "\u001B[0m";
		String cadena;
		if(this.esVisible){
			cadena =  this.simbolo;
		} else {
		cadena = purple + "   oculto   " + reset;
		}
		return cadena;
	}
}
