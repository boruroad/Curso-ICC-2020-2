import java.util.Random;

public class Guerrero extends Personaje{
	
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
	/* Contador para saber cuántas veces se ha usado el método combatir */
	private int numCombatir;
	/* Contador para saber cuántas veces se ha usado el método cabalgar */
	private int numCabalagar;



	// (CONSTRUCTOR)
	public Guerrero(String nombre){
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
	 * El personaje "Guerrero" podrá atacar (ESPECIALMENTE) con un método llamado "combatir" y otro llamado "cabalgar" 
	 */


	// (MÉTODOS PROPIOS DE LA CLASE)

	private int combatir(Personaje x){
		this.numCombatir++;
		int ataque = rn.nextInt(11) + 5;
		x.disminuyeVida(ataque);
		return ataque;
	}


	private int cabalgar(Personaje x){
		this.numCabalagar++;
		int ataque = rn.nextInt(5) + 10;
		x.disminuyeVida(ataque);
		return ataque;
	}

	@Override
	public void atacar(Personaje x){
		System.out.println(green + "\n***** Está atacando " + this.getNombre() + " *****"+ reset);
		/* línea de código que nos permirá saber qué tipo de ataque hará el Guerrero. */
		int ataque_A_Elegir = rn.nextInt(2);
		if(ataque_A_Elegir == 0){
			int ataque = this.combatir(x);
			System.out.println("\nSe atacó con combatir, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		} else {
			int ataque = this.cabalgar(x);
			System.out.println("\nSe atacó con cabalgar, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		}
		this.recuperarse();
	}

	@Override
	public void recuperarse(){
		if(numCombatir == 4){
			System.out.println("\nEl Guerrero " + this.getNombre() + " recupera 30 puntos de vida por atacar 4 veces con \"combatir\" ");
			this.aumentaVida(30);
			numCombatir = 0;
		}

		if(numCabalagar == 5){
			System.out.println("\nEl Guerrero " + this.getNombre() + " recupera 10 puntos de vida por atacar 5 veces con \"cabalgar\"");
			this.aumentaVida(10);
			numCabalagar = 0;
		}
		if(rn.nextInt(11) == 8){
			int vida10Porciento = (10*vida)/100;
			System.out.println("\nEl Guerrero " + this.getNombre() + " recupera " + vida10Porciento + "% de vida");
			this.aumentaVida(vida10Porciento);
		}
	}
}