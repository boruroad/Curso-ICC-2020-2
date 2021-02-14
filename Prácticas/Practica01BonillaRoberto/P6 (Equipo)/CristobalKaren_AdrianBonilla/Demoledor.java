import java.util.Scanner;
/**
 * Practica 6: Herencia.
 * Ésta clase "Demoledor" extiende a la clase "Trabajador".
 * El demoledor tiene distinta forma de trabajar respecto a los otros trabajadores.
 * Trabaja únicamente en zonas NO baldías para quitar a la construccion en dicha zona.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */


public class Demoledor extends Trabajador {



    @Override
    public boolean puedeTrabajar(ZonaConstruccion zona, int posicion){
        return zona.construcciones[posicion-1] instanceof Casa;
    }

    @Override
    public void trabaja (ZonaConstruccion zona, int numLotes){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelecciona la  posicion de la costrucción que deseas demoler ");
        System.out.print("Posicion: ");


        /* Robustez para el programa */
		while(!sc.hasNextInt()){
			System.out.println("\n¡¡ Sólo se acepta números !!\n");
			sc.next();
			System.out.print("Posicion: ");
		}
        int posicion = sc.nextInt();
		while(posicion < 1 || posicion > numLotes){
			System.out.println("\n¡¡¡ Opción inválida !!!\n");
			System.out.print("Posicion: ");
			while(!sc.hasNextInt()){
				System.out.println("\n¡¡ Sólo se acepta números !!\n");
				sc.next();
				System.out.print("Posicion: ");
			}
			posicion = sc.nextInt();
		}


        if(this.puedeTrabajar(zona, posicion)){
            System.out.println(zona);
            System.out.println("\n*** Hay construcciones. El demoledor comenzará a trabajar en unos instantes *** \n");


            zona.construcciones[posicion-1] = new Construccion(zona);
            System.out.println(zona);

            double pagoD1 = 50000;
			this.ganancias += 50000;
			System.out.println("\nEl demoledor ha cobrado $" + pagoD1 + " por destruir una planta de la construcción");
			pagoD1 += this.ganancias;
			System.out.println("Ganacias del demoledor: " + this.ganancias +"\n");



        }else{
			System.out.println("\nEl demoledor no puede trabajar aqui :C");
		}


    }


}
