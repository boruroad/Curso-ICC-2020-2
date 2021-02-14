import java.util.Scanner;
import java.util.Random;

public class Jugar{

	/**
     * Regresa un personaje al azar para el jugador "máquina".
     * @param n un número al azar entre 1 a 4.
     * @return un personaje al azar, ya sea de la clase Guerrero, Mago, Ent ó Sirena.
     */
	public static Personaje eligePersonajeAlAzar(int n){
		Random rn = new Random();
		n = rn.nextInt(4)+1;
		Personaje pp = null;

		switch(n){
			case 1:
			pp = new Guerrero("(Guerrero) Ragnar");
			break;

			case 2:
			pp = new Mago("(Mago) Elder");
			break;

			case 3:
			pp = new Ent("(Ent) Jack");
			break;

			case 4:
			pp = new Sirena("(Sirena) Aria");
			break;
		}
		return pp;
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int n = rn.nextInt(4)+1;
	
   		String red = "\033[31m"; 
   		String green = "\033[32m"; 
   		String yellow = "\033[33m"; 
   		String blue = "\033[34m"; 
   		String purple = "\033[35m"; 
   		String cyan = "\033[36m"; 
   		String reset = "\u001B[0m";

		System.out.println(yellow + "\n\n ****** BIENVENIDO ******\n" + reset);
		System.out.println(cyan + "  [1] -> Guerrero." + reset);
		System.out.println(cyan + "  [2] -> Mago." + reset);
		System.out.println( cyan + "  [3] -> Ent." + reset );
		System.out.println( cyan + "  [4] -> Sirena." + reset);
		System.out.print(purple + "\nEliga a su personaje: " + reset);

		// REUTILICÉ CÓDIGO DEL BUSCAMINAS PARA DARLE ROBUSTEZ AL PROGRAMA.
		/* Código que le dice al usuario que ingrese un número válido en caso de haber ingresado un caracer. */
		while(!sc.hasNextInt()){	
			System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
			sc.next();
			System.out.print(purple + "Personaje: " + reset);
		}
		int opcion = sc.nextInt();

		/* Código que le dice al usuario que ingrese un número válido en caso de haber ingresado un número NO establecido
		 * en el menú, también si vuelve a ingresar un caracter le dice que ingrese un número establecido en el menú. */
		while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4){
			System.out.println("\n¡¡¡ No hay personajes disponibles con ese número.\n Por favor ingrese un personaje dentro del menú. !!!\n");	
			System.out.print(purple + "Personaje: " + reset);
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print(purple + "Personaje: " + reset);
			}
			opcion = sc.nextInt();
		}

		switch(opcion){

		case 1:
			System.out.println(red+"\n__________________________________________"+ reset);
			System.out.println(purple + "\n   HAS ESCOGIDO A UN GUERRERO." + reset);
			System.out.print("\nNombra a tu Guerrero: ");
			String nom1 = sc.next();
			Personaje per1 = new Guerrero(nom1);
			Personaje p1 = eligePersonajeAlAzar(n);
			System.out.println(blue + "\n* Lema de " + nom1 + ": \n\"Ve a la batalla con la firme seguridad de la victoria y volverás a casa sin heridas.\"\n\n"+ reset);
			System.out.print(yellow +  nom1 + "  <-- PELEARÁ CONTRA -->  " + p1.getNombre() + "\n\n" + reset);
			while(per1.vida > 0 && p1.vida > 0){
				int turno = rn.nextInt(2);
				if(turno == 0){
					per1.atacar(p1);
				} else {
					p1.atacar(per1);
				}
				System.out.println(per1);
				System.out.println(p1);
				if(per1.vida <= 0){
					System.out.println(yellow + "GANA " + p1.getNombre() + reset + "\n\n");
				} else {
					if(p1.vida <= 0){
						System.out.println(yellow + "GANA " + nom1 + reset + "\n\n");						
					}
				}
			}	
			break;

		case 2:
			System.out.println(red+"\n__________________________________________"+ reset);
			System.out.println(purple + "\n   HAS ESCOGIDO A UN MAGO" + reset);
			System.out.print("\nNombra a tu Mago: ");
			String nom2 = sc.next();
			Personaje per2 = new Mago(nom2);
			Personaje p2 = eligePersonajeAlAzar(n);
			System.out.println(blue + "\n* Lema de " + nom2 + ": \n\"La magia está en cada rincón, sólo hay que observar atentamente.\"\n\n" + reset);
			System.out.print(yellow +  nom2 + "  <-- PELEARÁ CONTRA -->  " + p2.getNombre() + "\n\n" + reset);
			while(per2.vida > 0 && p2.vida > 0){
				int turno = rn.nextInt(2);
				if(turno == 0){
					per2.atacar(p2);
				} else {
					p2.atacar(per2);
				}
				System.out.println(per2);
				System.out.println(p2);
				if(per2.vida <= 0){
					System.out.println(yellow + "GANA " + p2.getNombre() + reset + "\n\n");
				} else {
					if(p2.vida <= 0){
						System.out.println(yellow + "GANA " + nom2 + reset +"\n\n");						
					}
				}
			}	
			break;
		
		case 3:
			System.out.println(red+"\n__________________________________________"+ reset);
			System.out.println(purple + "\n   HAS ESCOGIDO A UN ENT." + reset);
			System.out.print("\nNombra a tu Ent: ");
			String nom3 = sc.next();
			Personaje per3 = new Ent(nom3);
			Personaje p3 = eligePersonajeAlAzar(n);
			System.out.println(blue + "\n* Lema de " + nom3 + ": \n\"Sólo podemos dominar la naturaleza si la obedecemos.\"\n\n" + reset);
			System.out.print(yellow +  nom3 + "  <-- PELEARÁ CONTRA -->  " + p3.getNombre() + "\n\n" + reset);
			while(per3.vida > 0 && p3.vida > 0){
				int turno = rn.nextInt(2);
				if(turno == 0){
					per3.atacar(p3);
				} else {
					p3.atacar(per3);
				}
				System.out.println(per3);
				System.out.println(p3);
				if(per3.vida <= 0){
					System.out.println(yellow + "GANA " + p3.getNombre() + reset +"\n\n");
				} else {
					if(p3.vida <= 0){
						System.out.println(yellow + "GANA " + nom3 + reset +"\n\n");						
					}
				}
			}	
			break;

		case 4:
			System.out.println(red+"\n__________________________________________"+ reset);
			System.out.println(purple + "\n   HAS ESCOGIDO A UNA SIRENA." + reset);
			System.out.print("\nNombra a tu Sirena: ");
			String nom4 = sc.next();
			Personaje per4 = new Sirena(nom4);
			Personaje p4 = eligePersonajeAlAzar(n);
			System.out.println(blue + "\n* Lema de " + nom4 + ": \n\"Tu poder y belleza la defines tú.\"\n\n" + reset);
			System.out.print(yellow +  nom4 + "  <-- PELEARÁ CONTRA -->  " + p4.getNombre() + "\n\n" + reset);
			while(per4.vida > 0 && p4.vida > 0){
				int turno = rn.nextInt(2);
				if(turno == 0){
					per4.atacar(p4);
				} else {
					p4.atacar(per4);
				}
				System.out.println(per4);
				System.out.println(p4);
				if(per4.vida <= 0){
					System.out.println(yellow + "GANA " + p4.getNombre() + reset +"\n\n");
				} else {
					if(p4.vida <= 0){
						System.out.println(yellow + "GANA " + nom4 + reset +"\n\n");						
					}
				}
			}	
			break;
		}
	}
}

