import java.util.Scanner;

/**
 * Clase que simula una zona con cierto número de construcciones.
 * @author Pedro Ulises Cervantes González
 * @version 1.0
 */
public class ZonaConstruccion{

    /** Las construcciones de la zona*/
    protected Construccion[] construcciones;

    /**
     * Crea una nueva zona de construcción.
     *
     * @param nCons El número de construcciones que habrá.
     */
    public ZonaConstruccion(int nCons){
		construcciones = new Construccion[nCons];
		for(int i = 0; i < nCons; i++){
	    	construcciones[i] = new Construccion(this);
		}
    }

    /**
     * Devuelve las construcciones
     *
     * @return Las construcciones
     */
    public Construccion[] getConstrucciones(){
		return construcciones;
	}


    @Override
    public String toString(){
	    String[][] consArray = new String[construcciones.length][];
	    int max = 0;
	    for(int i = 0; i < construcciones.length; i++){
	        consArray[i] = construcciones[i].toStringArray();
	        if(max < consArray[i].length)
	        	max = consArray[i].length;
	    }
	    String cad = "";
	    for(int i = max - 1; i >= 0; i--){
	        for(int j = 0; j < consArray.length; j++){
	    		if(i >= consArray[j].length)
	    			cad += Construccion.cielo();
	    		else
	    			cad += consArray[j][i];
	    		if(j < consArray.length-1)
	    	    	if(i > 0)
	    	    		cad += "  ";
	    	    	else
	    	    		cad += "TT";
	    			else if(i > 0)
	    				cad += "\n";
	        }
	    }
	    return cad;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
      System.out.println("\n*** BIENVENIDO ***");
   		System.out.println("\nTeclea el número de lotes que deses tener \n\nInicia minimo con 5 lotes");
   		System.out.print("Num. Lotes: ");
		/* Robustez para el programa */
		while(!sc.hasNextInt()){
			System.out.println("\n¡¡ Sólo se acepta números !!\n");
			sc.next();
			System.out.print("Num. Lotes: ");
		}
		int numLotes = sc.nextInt();

		while(numLotes < 5){
			System.out.println("\n¡¡¡ Son mínimo 5 lotes !!!\n");
			System.out.print("Num. Lotes: ");
			while(!sc.hasNextInt()){
				System.out.println("\n¡¡ Sólo se acepta números !!\n");
				sc.next();
				System.out.print("Num. Lotes: ");
			}
			numLotes = sc.nextInt();
		}

    System.out.println("\nCada terreno baldío tiene un costo de $200,000.");
    System.out.println("Usted ha comprado " + numLotes + " terenos baldíos.");
    System.out.println("El costo total de los terrenos baldíos es $" +(numLotes * 200000) + ".");



		Constructor cons1 = new Constructor();
		Demoledor dem1 = new Demoledor();
		Remodelador rem1 = new Remodelador();
   		ZonaConstruccion zona = new ZonaConstruccion(numLotes);
		System.out.println("\n");
		System.out.println(zona);

		int opcion;

		do{
			System.out.println("\nCon quién deseas trabajar: ");
			System.out.println("\n[1] ---> Constructor. \n[2] ---> Demoledor. \n[3] ---> Remodelador (sólo trabaja en edificios). \n[4] ---> Salir.");
			System.out.print("\nOpción: ");
			/* Robustez para el programa */
			while(!sc.hasNextInt()){
				System.out.println("\n¡¡ Sólo se acepta números !!\n");
				sc.next();
				System.out.print("Opción: ");
			}
			opcion = sc.nextInt();

			while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4){
				System.out.println("\n¡¡¡ Opción inválida !!!\n");
				System.out.print("Opción: ");
				while(!sc.hasNextInt()){
					System.out.println("\n¡¡ Sólo se acepta números !!\n");
					sc.next();
					System.out.print("Opción: ");
				}
				opcion = sc.nextInt();
			}
			switch (opcion){
					case 1:
						cons1.trabaja(zona, numLotes);
					break;

					case 2:
						dem1.trabaja(zona, numLotes);
					break;

					case 3:
						rem1.trabaja(zona, numLotes);
					break;

					case 4:
						System.out.print("\nHasta pronto C: \n\n");
					break;
			}

		}while(opcion != 4);


	}

}
