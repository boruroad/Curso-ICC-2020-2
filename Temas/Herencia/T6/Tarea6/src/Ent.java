import java.util.Random;

public class Ent extends Personaje{

	// (ATIBUTOS)

	/* 
	 * Tiene nivel de vida inicial,
	 * una recompensa que aumenta su vida,  
	 * debe de tener un atributo que nos permita saber cuánta vida tiene, Y
	 * tiene nombre
	 *
	 * COMO ÉSTOS ATRIBUTOS ESTÁN EN LA CLASE PADRE, ENTONCES PODERMOS HEREDARLOS (REUTILIZAR LOS ATRIBUTOS).
	 */


	// (ATRIBUTOS PROPIOS DE LA CLASE)
	private Random rn = new Random();
	/* Contador para saber cuántas veces se ha usado el método aplastar */
	private int numAplastar;
	/* Contador para saber cuántas veces se ha usado el método envolver */
	private int numEnvolver;


	// (CONSTRUCTOR)
	public Ent(String nombre){
		this.nombre = nombre;
	}


	// (MÉTODOS)

	/* 
	 * Puede saber si sigue con vida,
	 * puede atacar, 
	 * puede recuperarse de una herida por ataque,
	 * puede aumentar su vida, y
	 * puede disminuir su vida.
	 *
	 * COMO ÉSTOS MÉTODOS ESTÁN EN LA CLASE PADRE, ENTONCES PODERMOS HEREDARLOS (REUTILIZAR LOS MÉTODOS).
	 */


  	/* NOTA:
	 * El personaje "Ent" podrá atacar (ESPECIALMENTE) con un método llamado "aplastar" y otro llamado "envolver" /
	 */

	
	// (MÉTODOS PROPIOS DE LA CLASE)

	private int aplastar(Personaje x){
		this.numAplastar++;
		int ataque = rn.nextInt(5) + 10;
		x.disminuyeVida(ataque);
		return ataque;
	}


	private int envolver(Personaje x){
		this.numEnvolver++;
		int ataque = 20;
		x.disminuyeVida(ataque);
		return ataque;
	}


	@Override
	public void atacar(Personaje x){
		System.out.println(green + "\n***** Está atacando " + this.getNombre() + " *****"+ reset);
		/* línea de código que nos permiirá saber qué tipo de ataque hará el Ent.*/
		int ataque_A_Elegir = rn.nextInt(2);
		if(ataque_A_Elegir == 0){
			int ataque = this.aplastar(x);
			System.out.println("\nSe atacó con aplastar, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		} else {
			int ataque = this.envolver(x);
			System.out.println("\nSe atacó con envolver, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		}
		this.recuperarse();
	}

	@Override
	public void recuperarse(){
		if(numAplastar == 3){
			System.out.println("\nEl Ent " + this.getNombre() + " recupera 15 puntos de vida por atacar 3 veces con \"aplastar\" ");
			this.aumentaVida(15);
			numAplastar = 0;
		}

		if(numEnvolver == 4){
			System.out.println("\nEl Ent " + this.getNombre() + " recupera 20 puntos de vida por atacar 4 veces con \"envolver\" ");
			this.aumentaVida(20);
			numEnvolver = 0;
		}
		if(rn.nextInt(11) == 3){
			int vida15Porciento = (15*vida)/100;
			System.out.println("\nEl Ent " + this.getNombre() + " recupera " + vida15Porciento + "% de vida");
			this.aumentaVida(vida15Porciento);
		}
	}
}