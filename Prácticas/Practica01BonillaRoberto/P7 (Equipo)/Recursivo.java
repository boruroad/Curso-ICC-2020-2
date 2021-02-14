import java.util.Scanner;

/**Implementar la clase Recursivo con su interfaz InterfazRecursion
 * @author Bonilla Ruiz Roberto Adrián.
 * @author Cristobal Morales Karen
 * @version 1.0 Junio 2020
 */

public class Recursivo implements InterfazRecursion {

	/**
	 * ACTIVIDAD 1.
	 * Método que define si una palabra es palndrome
	 * @param cadena la cadena que va a recibir
	 */
	@Override
    public boolean esPalindromo(String cadena){
		cadena = cadena.trim().toUpperCase();
		//caso base 
    	if(cadena.length() == 0 || cadena.length() == 1){
    		return true;
    	} else { 
	    	if(cadena.charAt(0) == cadena.charAt(cadena.length()-1))
	    		return esPalindromo(cadena.substring(1,cadena.length()-1));
    	return false;
    	}
	}

	/**
	 * ACTIVIDAD 2.
	 * Método que reemplaza un caracter
	 * @param cadena la cadena con la que se va a trabajar  
	 * @param reemplazado la segunda cadna que va a trabajar dentro de la primera
	 * @param reemplazador la tercer cadena que va a reemplazar a la segunda y va a estar dentro de la primera
	 */
	@Override
	public String reemplazaCaracter(String cadena, String reemplazado, String reemplazador){ 
		char a = reemplazado.charAt(0);
		char b = reemplazador.charAt(0);
		//caso base
		if(cadena.length() < 1){
			return cadena;
		} else {
			char nuevo;
			if(cadena.charAt(0) == a){
				nuevo = b;
			} else {
				nuevo = cadena.charAt(0);
			}
			return nuevo + reemplazaCaracter(cadena.substring(1), reemplazado, reemplazador);
		}
	}

	/**
	 * ACTIVIDAD 3.
	 * Método que nos devuelve el número de veces que un caracter aparece en una cadena,
	 * @param cadena la cadena que va a recibir.
	 * @param c el caracter a contar sus repeticiones en la cadena.
	 */
	@Override
    public int cuentaCaracter(String cadena, char c){
		int contador = 0;
		//Caso base
	    if (cadena.length() == 0){  
	    	return 0; 
	    }	
	    return (cadena.charAt(0) == c ? ++contador : contador) + cuentaCaracter(cadena.substring(1), c); 
    }

	/**
	 * ACTIVIDAD 4.
	 * Método que realiza la secuencia fibonacci 
	 * @param n el numero con el que se va a realizar la función
	 */	
	@Override
	public int fibonacci(int n){
		//Caso base: con cero --> 0
		if(n == 0){
			return 0;
	 	//Caso base: con 1 --> 1
		} else if(n == 1){
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}	

	public static void main(String[] args) {

		Recursivo r1 = new Recursivo();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n**** FUNCIONES RECURSIVAS ****\n");
    	System.out.println("-------- Por favor escoja una de las siguientes opciones -------- \n");
		System.out.println("  [1] -> Es palindromo.");
		System.out.println("  [2] -> Reemplaza caracter.");
		System.out.println("  [3] -> Cuenta caracter.");
		System.out.println("  [4] -> Fibonacci.");
		System.out.print("\nOpción: ");

		if(!sc.hasNextInt()){
			System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
			sc.next();
			System.out.print("Opción: ");
		}
		int opcion = sc.nextInt();
		
		if(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4){
			System.out.println("\nNo hay funciones disponibles con ese número.\nPor favor ingrese una opción válida. !!!\n");	
			System.out.print("Opción: ");
			if(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Opción: ");
			}
			opcion = sc.nextInt();
		}

		switch(opcion){
			case 1:
				System.out.println("\nSeleccionó la función \"Es palindromo\"");
				System.out.print("Ingrese palabra / oración: ");
				sc.nextLine();
				String cadena = sc.nextLine();
				System.out.println("¿Es palindromo? --> " + r1.esPalindromo(cadena) + "\n");
				break;

			case 2:
				System.out.println("\nSeleccionó la función \"Reemplaza caracter\"");
				System.out.print("Ingrese palabra / oración: ");
				sc.nextLine();
				String cad1 = sc.nextLine();
				System.out.print("Caracter a reemplazar: ");
				String a1 = sc.nextLine(); 
				System.out.print("Caracter reemplazador: ");
				String a2 = sc.nextLine();
				System.out.println("--> " + r1.reemplazaCaracter(cad1, a1, a2) + "\n");
				break;

			case 3:
				System.out.println("\nSeleccionó la función \"Cuenta caracter\"");
				System.out.print("Ingrese palabra: ");
				String c1 = sc.next().toLowerCase();
				System.out.print("Ingrese caracter a contar: ");
				char c = sc.next().charAt(0); 
				System.out.println("--> El caracter \"" + c + "\" se encuentra "+r1.cuentaCaracter(c1,c)+ " veces\n");
				break;

			case 4:
				System.out.println("\nSeleccionó la función \"Fibonacci\"");
				System.out.print("Ingrese número: ");
				if(!sc.hasNextInt()){
					System.out.println("\nLa sucesión de Fibonacci no acepta caracteres");
					sc.next();
					System.out.print("Ingrese número: ");
				}
				int fib = sc.nextInt();
				if(fib < 0){
					System.out.println("\nLa sucesión de Fibonacci no acepta números negatvos");
					System.out.print("Ingrese número: ");
					if(!sc.hasNextInt()){
						System.out.println("\nLa sucesión de Fibonacci no acepta caracteres");
						sc.next();
						System.out.print("Ingrese número: ");
					}
					fib = sc.nextInt();
				}
				System.out.println("Fibonacci de " + fib + " es " + r1.fibonacci(fib) + "\n");
				break;

			default:
	        	if(opcion < 1 || opcion > 4){ 
		        	System.out.println("\nOpción inválida ");
	        	}
		}
	}
}