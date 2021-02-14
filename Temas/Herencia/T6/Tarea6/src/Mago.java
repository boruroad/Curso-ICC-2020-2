import java.util.Random;

public class Mago extends Personaje {

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
	/* Contador para saber cuántas veces se ha usado el método encantar */
	private int numEncantar;
	/* Contador para saber cuántas veces se ha usado el método volar */
	private int numVolar;


	// (CONSTRUCTOR)
	public Mago(String nombre){
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
	 * El personaje "Mago" podrá atacar (ESPECIALMENTE) con un método llamado "encantar" y otro llamado "volar".
	 */


	// (MÉTODOS PROPIOS DE LA CLASE)

	private int encantar(Personaje x){
		this.numEncantar++;
		int ataque = 20;
		x.disminuyeVida(ataque);
		return ataque;
	}


	private int volar(Personaje x){
		this.numVolar++;
		int ataque = rn.nextInt(5) + 5;
		x.disminuyeVida(ataque);
		return ataque;
	}

	@Override
	public void atacar(Personaje x){
		System.out.println(green + "\n***** Está atacando " + this.getNombre() + " *****"+ reset);
		/* línea de código que nos permirá saber qué tipo de ataque hará el Mago. */
		int ataque_A_Elegir = rn.nextInt(2);
		if(ataque_A_Elegir == 0){
			int ataque = this.encantar(x);
			System.out.println("\nSe atacó con encantar, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		} else {
			int ataque = this.volar(x);
			System.out.println("\nSe atacó con volar, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		}
		this.recuperarse();
	}

	@Override
	public void recuperarse(){
		if(numEncantar == 5){
			System.out.println("\nEl Mago " + this.getNombre() + " recupera 30 puntos de vida por atacar 5 veces con \"encantar\" ");
			this.aumentaVida(30);
			numEncantar = 0;
		}

		if(numVolar == 2){
			System.out.println("\nEl Mago " + this.getNombre() + " recupera 10 puntos de vida por atacar 2 veces con \"volar\" ");
			this.aumentaVida(10);
			numVolar = 0;
		}
		if(rn.nextInt(11) == 6){
			int vida15Porciento = (15*vida)/100;
			System.out.println("\nEl Mago " + this.getNombre() + " recupera " + vida15Porciento + "% de vida");
			this.aumentaVida(vida15Porciento);
		}
	}
}