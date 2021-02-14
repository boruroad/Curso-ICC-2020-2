import java.util.Random;

public class Sirena extends Personaje {

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
	/* Contador para saber cuántas veces se ha usado el método hipnotizar */
	private int numHipnotizar;
	/* Contador para saber cuántas veces se ha usado el método enamorar */
	private int numEnamorar;


	// (CONSTRUCTOR)
	public Sirena(String nombre){
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
	 * El personaje "Sirena" podrá atacar (ESPECIALMENTE) con un método llamado "hipnotizar" y otro llamado "enamorar".
	 */


	// (MÉTODOS PROPIOS DE LA CLASE)

	private int hipnotizar(Personaje x){
		this.numHipnotizar++;
		//cambiar de 10 a 20.
		int ataque = rn.nextInt(11) + 10;
		x.disminuyeVida(ataque);
		return ataque;
	}


	private int enamorar(Personaje x){
		this.numEnamorar++;
		int ataque = 30;
		x.disminuyeVida(ataque);	
		return ataque;
	}

	@Override
	public void atacar(Personaje x){
		System.out.println(green + "\n***** Está atacando " + this.getNombre() + " *****"+ reset);
		/* línea de código que nos permiirá saber qué tipo de ataque hará la Sirena. */
		int ataque_A_Elegir = rn.nextInt(2);
		if(ataque_A_Elegir == 0){
			int ataque = this.hipnotizar(x);
			System.out.println("\nSe atacó hipnotizando, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		} else {
			int ataque = this.enamorar(x);
			System.out.println("\nSe atacó enamorando, se resta -" + ataque + " a la vida del contrincante");
			System.out.println("\nACTUALIZACIÓN DE LA INFORMACIÓN");
		}
		this.recuperarse();
	}

	@Override
	public void recuperarse(){
		if(numHipnotizar == 4){
			System.out.println("\nLa Sirena " + this.getNombre() + " recupera 25 puntos de vida por atacar 4 veces con \"hipnotizar\" ");
			this.aumentaVida(25);
			numHipnotizar = 0;
		}

		if(numEnamorar == 4){
			System.out.println("\nLa Sirena " + this.getNombre() + " recupera 25 puntos de vida por atacar 4 veces con \"enamorar\" ");
			this.aumentaVida(25);
			numEnamorar = 0;
		}
		if(rn.nextInt(11) == 5){
			int vida10Porciento = (10*vida)/100;
			System.out.println("\nLa Sirena " + this.getNombre() + " recupera " + vida10Porciento + "% de vida");
			this.aumentaVida(vida10Porciento);
		}
	}
	
}