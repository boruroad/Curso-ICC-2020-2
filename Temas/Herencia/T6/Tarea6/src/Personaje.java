/**
 * Tarea 6: "Herencia y Polimorfismo"
 * Clase que padre que será la que herede a los personajes 
 * del juego (clases hijas) ciertos atributos y métodos.
 * @author Cristobal Morales Karen.
 * @version 1.0 Mayo 2020.
 */


/* Clase Padre */
public abstract class Personaje{

//¿ Qué sabemos que hacen todos los personajes?

	// (ATIBUTOS)

	/* Tienen un nivel de vida inicial */
	protected int vida = 100;

	/* Atributo que representa el porcentaje de incremento en la vida del personaje */
	protected int recompensaVida;

	/* Atributo que representa el nombre del personaje */
	protected String nombre;

	/* Color */
   	String red = "\033[31m"; 
   	String green = "\033[32m"; 
  	String yellow = "\033[33m"; 
 	String blue = "\033[34m"; 
   	String purple = "\033[35m"; 
   	String cyan = "\033[36m"; 
   	String reset = "\u001B[0m";


	// (MÉTODOS DE ACCESO)
	public String getNombre(){
		return this.nombre;
	}

	public int getVida(){
		return this.vida;
	}

	// (MÉTODOS)

	/* Saber si siguen con vida */
	public boolean sigueVivo(){
		return vida > 0;
	}

	/* Atacar (Cada personaje utilizará su PROPIO modo de ataque), por lo tanto éste 
	 * método será implementado por cada una de las clases hijas a su forma.
	 */
	public abstract void atacar(Personaje x);

	
	/* Recuperarse de una herida por ataque (Cada personaje se recuperará a su manera), por lo tanto éste 
	 * método será implementado por cada una de las clases hijas.
	 */
	public abstract void recuperarse();

	/* Método que aumenta vida a la vida total. */
	public void aumentaVida(int vidaMas){
		this.vida = vida + vidaMas;
	}

	/* Método que quita vida a la vida total. */
	public void disminuyeVida(int vidaMenos){
		this.vida = vida - vidaMenos;
	}

	@Override
	public String toString(){
		return "\nNombre: " + this.nombre + "\nVida: " + this. vida +"\n"; 
	}
}