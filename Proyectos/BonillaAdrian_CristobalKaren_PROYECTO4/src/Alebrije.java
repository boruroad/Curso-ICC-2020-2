/**
 * Clase Alebrije.
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristobal Morales Karen.
 * @version 1.0
 */

public class Alebrije {

//ATRIBUTOS

	/**Atributo que representa el color del cuerpo del alebrije */
	public String colorCuerpo;
	/**Atributo que representa la cabeza de un animal específico*/
	public String cabeza;
	/**Atributo que representa el color de la cabeza del alebrije-animal */
	public String colorCabeza;
	/**Atributo que representa el cuerpo de un animal específico */
	public String cuerpo;


	/**
	 * CONSTRUCTOR. Construye un nuevo Alebrije.
	 * @param cabeza la cabeza de animal que tendrá el alebrije.
	 * @param cuerpo el cuerpo de animal que tendrá el alebrije.
	 * @param colorCuerpo  color de la parte del cuerpo.
	 * @param colorDeCabeza  color de la cabeza.
	 */
	public Alebrije(String cabeza, String colorCabeza, String cuerpo, String colorCuerpo) {
		this.cabeza = cabeza;
		this.colorCuerpo = colorCuerpo;
		this.colorCabeza = colorCabeza;
		this.cuerpo = cuerpo;
	}

	public void ensenia(){
		System.out.println("\n  Cabeza de: " + cabeza);
		System.out.println("  Color de la cabeza: " + colorCabeza);
		System.out.println("  Cuerpo de: " + cuerpo);
		System.out.println("  Color del cuerpo: " + colorCuerpo);
	}



// MÉTODOS DE ACCESO

	/** Permite acceder a la cabeza del animal.
	 * @return la cabeza de un animal específico.
	 */
	public String getCabeza(){
		return this.cabeza;
	}

	/** Permite acceder al color del cuerpo del animal.
	 * @return el color de la parte del cuerpo del animal.
	 */
	public String getColorCuerpo(){
		return this.colorCuerpo;
	}

	/** Permite acceder al color de la cabeza del animal.
	 * @return el color de la cabeza del animal
	 */
	public String getColorCabeza(){
		return this.colorCabeza;
	}

	/** Permite acceder al cuerpo del animal.
	 * @return el cuerpo específico de un animal.
	 */
	public String getCuerpo(){
		return this.cuerpo;
	}


// MÉTODOS MODIFICADORES

	/**
	 * Permite modificar el cuerpo de animal que tiene el alebrije.
	 * @param cuerpo el cuerpo que tendrá.
	 */
	public void setCuerpo(String cuerpo){
		this.cuerpo = cuerpo;
	}

	/**
	 * Permite modificar el color del cuerpo del animal que tiene el alebrije.
	 * @param nuevo el nuevo color.
	 */
	public void setColorCuerpo(String colorCuerpo){
		this.colorCuerpo = colorCuerpo;
	}

	/**
	 * Permite modificar la cabeza de animal que tiene el alebrije.
	 * @param animal  la cabeza del nuevo animal.
	 */
	public void setCabeza(String cabeza){
		this.cabeza = cabeza;
	}

	/**
	 * Permite modificar el color de la cabeza del animal que tiene el alebrije.
	 * @param colorCabeza el nuevo color.
	 */
	public void setColorCabeza(String colorCabeza){
		this.colorCabeza = colorCabeza;
	}

	/**
	 * Método toString para imprimir Objetos.
	 */
	@Override
	public String toString() {
		return "Cabeza de " + this.cabeza + " color " + this.colorCabeza+ " y cuerpo de " + this.cuerpo + " color " + this.colorCuerpo;
	}
}
