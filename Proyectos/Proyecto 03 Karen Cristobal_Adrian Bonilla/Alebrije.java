/**
 * Proyecto 3: Listas.
 * Clase Alebrije.
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristobal Morales Karen.
 * @version 1.0
 */

public class Alebrije{

//ATRIBUTOS

	/**Atributo que representa el color del cuerpo del alebrije */
	public String color;
	/**Atributo que representa la cabeza de un animal específico*/ 
	public String animal;
	/**Atributo que representa el color de la cabeza del alebrije-animal */ 
	public String colorCabeza;
	/**Atributo que representa el cuerpo de un animal específico */ 
	public String animal2;


	/**
	 * CONSTRUCTOR. Construye un nuevo Alebrije con la parte del cuerpo de una
	 * animal específico y un color que el usuario eliga.
	 * @param animal saber que tipo de animal es
	 * @param nombre el nombre de la parte del cuerpo del animal.
	 * @param color  color de la parte del cuerpo.
	 */
	public Alebrije(String animal2, String animal, String color, String colorDeCabeza) {
		this.animal = animal;
		this.color = color;
		this.colorCabeza = colorDeCabeza;
		this.animal2 = animal2;
	}




// MÉTODOS DE ACCESO

	/** Permite acceder a la cabeza del animal.
	 * @return la cabeza de un animal específico.
	 */
	public String getAnimal(){
		return this.animal;
	}

	/** Permite acceder al color del cuerpo del animal.
	 * @return el color de la parte del cuerpo del animal.
	 */
	public String getColor(){
		return this.color;
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
	public String getAnimal2(){
		return this.animal2;
	}

 
// MÉTODOS MODIFICADORES

	/** 
	 * Permite modificar el cuerpo del animal escogido  para el alebrije.
	 * @param animal2 el cuerpo que tendrá.
	 */
	public void setAnimal2(String animal2){
		this.animal2 = animal2;
	}

	/**
	 * Permite modificar el color del cuerpo del animal para el alebrije.
	 * 
	 * @param nuevo el nuevo color.
	 */
	public void setColor(String nuevo){
		this.color = nuevo;
	}

	/** 
	 * Permite modificar la cabeza del animal para el alebrije.
	 * @param animal  la cabeza del nuevo animal.
	 */
	public void setAnimal(String animal){
		this.animal = animal;
	}

	/**
	 * Permite modificar el color de la cabeza del animal para el alebrije.
	 * @param colorCabeza el nuevo color.
	 */
	public void setColorCabeza(String colorCabeza){
		this.colorCabeza = colorCabeza;
	}

	/**
	 * Método toString para imprimir Objetos
	 */
	@Override
	public String toString() {
		return "Cabeza de " + this.animal + " color " + this.colorCabeza+ " y cuerpo de " + this.animal2+ " color " + this.color;
	}

	
}