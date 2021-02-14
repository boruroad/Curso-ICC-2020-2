import java.util.Scanner;
/**
 * Practica 6: Herencia.
 * Ésta clase "Constructor" extiende a la clase "Trabajador".
 * El constructor tiene distinta forma de trabajar respecto a los otros trabajadores.
 * Trabaja únicamente en zonas BALDÍAS para crear una construccion en dicha zona.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Constructor extends Trabajador {


	@Override
    public boolean puedeTrabajar(ZonaConstruccion zona, int posicion){
        return !(zona.construcciones[posicion-1] instanceof Casa);
	}


	@Override
    public void trabaja(ZonaConstruccion zona, int numLotes){

		Scanner sc = new Scanner(System.in);
		System.out.println("\nSelecciona la costrucción que deseas instalar: \n\n[1] ---> Casa.  \n[2] ---> Edificio.");;
		System.out.print("\nOpción: ");

		/* Robustez para el programa */
		while(!sc.hasNextInt()){
			System.out.println("\n¡¡ Sólo se acepta números !!\n");
			sc.next();
			System.out.print("Opción: ");
		}
		int op2 = sc.nextInt();

		while(op2 != 1 && op2 != 2){
			System.out.println("\n¡¡¡ Opción inválida !!!\n");
			System.out.print("Opción: ");
			while(!sc.hasNextInt()){
				System.out.println("\n¡¡ Sólo se acepta números !!\n");
				sc.next();
				System.out.print("Opción: ");
			}
			op2 = sc.nextInt();
		}

		switch(op2){
			case 1:
				System.out.println("\nTeclea la posicion de tu casa");
				System.out.print("Posicion: ");
				/* Robustez para el programa */
				while(!sc.hasNextInt()){
					System.out.println("\n¡¡ Sólo se acepta números !!\n");
					sc.next();
					System.out.print("Posicion: ");
				}
				int posicionCasa = sc.nextInt();

				while(posicionCasa < 1 || posicionCasa > numLotes){
					System.out.println("\n¡¡¡ Opción inválida !!!\n");
					System.out.print("Posicion: ");
					while(!sc.hasNextInt()){
						System.out.println("\n¡¡ Sólo se acepta números !!\n");
						sc.next();
						System.out.print("Posicion: ");
					}
					posicionCasa = sc.nextInt();
				}

				System.out.println("\n¿El constructor puede trabajar? ---> " + this.puedeTrabajar(zona, posicionCasa));

				if(this.puedeTrabajar(zona, posicionCasa) == true) {
					System.out.println("\n*** Hay lotes baldíos. El constructor comenzará a trabajar en unos instantes *** \n");

					Casa c1 = new Casa(zona, posicionCasa - 1);
					double pagoC1 = 100000;
					this.ganancias += 1000000;
					System.out.println("El constructor ha cobrado $" + pagoC1 + " por tú casa.");
					System.out.println("Ganacias del constructor: " + this.ganancias +"\n");
					pagoC1 += this.ganancias;
					System.out.println("\nDATOS DE LA CASA: ");
					c1.recalculaPrecioActual();
				System.out.println(c1);

					System.out.println(zona);
				}else{
					System.out.println("El constructor no puede trabajar aqui porque ya hay una construcción :C");
				}
			break;
			case 2:
			System.out.println("\nTeclea la posicion del edificio");
			System.out.print("Posicion: ");
			/* Robustez para el programa */
			while(!sc.hasNextInt()){
				System.out.println("\n¡¡ Sólo se acepta números !!\n");
				sc.next();
				System.out.print("Posicion: ");
			}
			int posicionEdificio = sc.nextInt();

			while(posicionEdificio < 1 || posicionEdificio > numLotes){
				System.out.println("\n¡¡¡ Opción inválida !!!\n");
				System.out.print("Posicion: ");
				while(!sc.hasNextInt()){
					System.out.println("\n¡¡ Sólo se acepta números !!\n");
					sc.next();
					System.out.print("Posicion: ");
				}
				posicionEdificio = sc.nextInt();
			}



			if(this.puedeTrabajar(zona, posicionEdificio) == true) {
				System.out.println("\n*** Hay lotes baldíos. El constructor comenzará a trabajar en unos instantes *** \n");

				Edificio e1 = new Edificio(zona, posicionEdificio - 1);
				double pagoE1 = 200000;
				this.ganancias += 2000000;
				System.out.println("El constructor ha cobrado $" + pagoE1 + " por el edificio.");
				System.out.println("Ganacias del constructor: " + this.ganancias +"\n");
				pagoE1 += this.ganancias;
				System.out.println("\nDATOS DEL EDIFICIO: ");
				e1.recalculaPrecioActual();
				System.out.println(e1);
				System.out.println(zona);
			}else{
				System.out.println("\nEl constructor no puede trabajar aqui porque ya hay una construcción :C");
			}
			break;
		}
	}

}
