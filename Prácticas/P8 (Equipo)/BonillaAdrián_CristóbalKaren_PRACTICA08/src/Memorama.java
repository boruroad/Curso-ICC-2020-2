import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Writer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Práctica 8: Manejo de excepciones, lectura y escritura de archivos.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Memorama {

	/** Atributo que es un arreglo bidimensional que almacena objetos de tipo Carta */
	public static Carta[][] arr = new Carta[4][4];

	/** A tributos que nos permitirán dar color al texto en consola. */
	static String green = "\033[32m";
	static String yellow = "\033[33m";
	static String purple = "\033[35m";
	static String cyan = "\033[36m";
	static String reset = "\u001B[0m";

	/**
	 * ACTIVIDAD 7.
	 * Método que nos permite guardar una partida en un archivo (durante ejecución del programa).
	 * @param nuevo un objeto de tipo Carta.
	 * @param nombreDelArchivo el nombre que tendrá el archivo donde se va a guardar la partida.
	 * @param fila la fila donde se encuentre una carta en específico (posición).
	 * @param columna la columna donde se encuentre una carta en específico (posición).
	 */
	public static void escribirPartida(Carta nuevo, String nombreDelArchivo, int fila, int columna){
		try{
			File f = new File(nombreDelArchivo + ".txt");
			FileWriter fw;
			BufferedWriter bw;

			/* Leyéndo el API de Java nos encontramos con el método "exists()" el cual es parte de la
			   clase "File" en Java. Esta función determina si existe o no un archivo o directorio indicado
			   por el nombre de archivo abstracto. Devuelve verdadero si la ruta del archivo abstracto 
			   existe o si no devuelve falso.*/
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(fila + "," + columna + "," + nuevo.getSimbolo() + "," + nuevo.esVisible);
			} else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(fila + "," + columna + "," + nuevo.getSimbolo() + "," + nuevo.esVisible);
			}
			bw.close();
			fw.close();
		} catch(FileNotFoundException fnfe){
			System.out.println(purple + "\n   ¡¡¡ NO SE ENCONTRÓ EL FICHERO !!!" + reset);
		} catch (Exception e){
			System.out.println(purple + "\n   ¡¡¡ ALGO INESPERADO OCURRIÓ !!!" + reset);
		}
	}


	/**
	 * ACTIVIDAD 8.
	 * Método que nos permite leer un archivo con una partida guardada.
	 * @param nombreDelArchivo el archivo a leer.
	 */
	public static void leerPartida(String nombreDelArchivo){
		Scanner sc = new Scanner(System.in);
		int opcion;
		try{
			File f = new File(nombreDelArchivo+".txt");
			if(f.exists()){
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea = br.readLine()) != null ){
					/*Econtramos el método "split()" el cual nos ayuda a dividir una cadena en
					 varias cadenas dado el delimitador que las separa. El objeto devuelto es un
					 arreglo que contiene las cadenas divididas .*/
					String [] c = linea.split(",");
					arr[Integer.parseInt(c[0])] [Integer.parseInt(c[1])] = new Carta(c[2], Boolean.parseBoolean(c[3]));
				}
			} else {
				System.out.println(purple + "\n   ¡¡¡ NO EXISTE EL ARCHIVO !!! " + reset);
			}
		} catch(FileNotFoundException fnfe){
			System.out.println(purple + "\n   ¡¡¡ NO SE ENCONTRÓ EL FICHERO !!! " + reset);
		} catch(Exception e){
			System.out.println(purple + "\n   ¡¡¡ ALGO INESPERADO OCURRIÓ !!! " + reset);
		}
	}

	/**
	 * ACTIVIDAD 4.
	 * Método que permite verificar si dos cartas tienen el mismo símbolo.
	 * @param c1 la primera Carta a comparar.
	 * @param c2 la segunda Carta a comparar.
	 * @return true si las Cartas son iguales, regresa false en caso contrario.
	 */
	public boolean volteaCartas(Carta c1, Carta c2){
		if(c1.getSimbolo().equals(c2.getSimbolo())){
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Método que nos permite verificar la robustez de lo que ingrese el usuario al elegir la FILA y COLUMNA (posición) de una carta.
	 * @param sc la opción que el usuario ingrese.
	 * @param cadena representará la palabra "fila" y "columna" para que el usuario pueda ingresar dichos valores.
	 * @return una opción correcta (ya que en caso de que el usuario haya ingresado letras o un número fuera de rango, se le obligará
	 * a ingresar una opción válida).
	 */
	public static int verifica(Scanner sc, String cadena ) {
		int n;
		while(true){
			try{
				System.out.print("\n"+cadena);
				n = Integer.parseInt(sc.nextLine());
				if(n < 0 || n > 3){
					throw new ArrayIndexOutOfBoundsException();
				}
				break;
			} catch(NumberFormatException nfe){
				System.out.println(purple + "\n   ¡¡¡ NO ACEPTA LETRAS !!!" + reset);
				continue ;
			} catch(ArrayIndexOutOfBoundsException aiobe){
				System.out.println(purple + "\n   ¡¡¡ POSICIÓN FUERA DE RANGO !!! \n\t  (RANGO VÁLIDO 0-3) " + reset);
				continue ;
			} catch(Exception e){
				System.out.print(purple + "\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n" + reset);
				continue;
			}
		}
		return n;
	}


	/**
	 * Método que nos permite mostrar un menú.
	 */
	public static void muestraMenu(){
		System.out.println(cyan + "\n ¿QUÉ DESEA HACER?" + reset);
		System.out.println(yellow+"\n-------- Por favor escoja una de las siguientes opciones -------- \n" + reset);
		System.out.println("  [1] -> Continuar partida.");
		System.out.println("  [2] -> Jugar nueva partida.");
		System.out.println("  [3] -> Guardar partida.");
		System.out.println("  [4] -> Cargar partida.");
	}


	/**
	 * Método que nos permite verificar la robustez de lo que ingrese el usuario como opción en el menú.
	 * @param sc la opción que el usuario teclee.
	 * @return una opción correcta (ya que en caso de que el usuario haya ingresado letras o un número fuera de rango, se le obligará
	 * a ingresar una opción válida).
	 */
	public static int verificaMenu (Scanner sc){
		int n;
		while(true){
			try{
				System.out.print("\nOpción: ");
				n = Integer.parseInt(sc.nextLine());
				if(n < 1 || n > 4){
					throw new InvalidNumberException("NÚMERO FUERA DE RANGO");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print(purple + "\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n" + reset);
				continue;
			}catch(InvalidNumberException ine){
				System.out.print(purple + "\n ¡¡¡ OPCIÓN FUERA DE RANGO !!!\n" + reset);
				continue;
			} catch(Exception e){
				System.out.print(purple + "\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n" + reset);
				continue;
			}
		}
		return n;
	}

	/**
	 * Método que nos permite saber si todas las cartan han sido volteadas.
	 * @return true si las todas las cartas han sido volteadas, regresa false en caso contrario.
	 */
	public static boolean finJuego(){
		boolean fin = true;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(!arr[i][j].getEsVisible()){
					fin = false;
					break;
				}
			}
		}
		return fin;
	}
	

	/**
	 * Método que permite mostrar el tablero inicial (donde todas las cartas tienen su símbolo oculto).
	 */
	public static void tableroInicio(){

   		/* Creamos nuestros objetos de tipo carta, cuyo símbolo son personajes de Bob Esponja */
		Carta c1 = new Carta("Don Cangrejo");
	  	Carta c2 = new Carta("  Arenita   ");
		Carta c3 = new Carta("   Karen    ");
		Carta c4 = new Carta("   Karen    ");
		Carta c5 = new Carta("  Patricio  ");
		Carta c6 = new Carta("  Plankton  ");
		Carta c7 = new Carta("    Gary    ");
		Carta c8 = new Carta("  Plankton  ");
		Carta c9 = new Carta("  Arenita   ");
		Carta c10 = new Carta("  Calamardo ");
		Carta c11 = new Carta("Bob Esponja ");
		Carta c12 = new Carta("    Gary    ");
		Carta c13 = new Carta("Bob Esponja ");
		Carta c14 = new Carta("  Patricio  ");
		Carta c15 = new Carta("Don Cangrejo");
		Carta c16 = new Carta("  Calamardo ");

		/* Agregamos las cartas al arreglo "arr" (claramente éste arreglo tendrá objetos de tipo carta) */
		arr[0][0] =  c1;
		arr[0][1] =  c2;
		arr[0][2] =  c3;
		arr[0][3] =  c4;
		arr[1][0] =  c5;
		arr[1][1] =  c6;
		arr[1][2] =  c7;
		arr[1][3] =  c8;
		arr[2][0] =  c9;
		arr[2][1] = c10;
		arr[2][2] = c11;
		arr[2][3] = c12;
		arr[3][0] = c13;
		arr[3][1] = c14;
		arr[3][2] = c15;
		arr[3][3] = c16;

		/* Agregamos las cartas con su estado inicial al archivo llamado "Memorama.txt" */
		for(int i =0; i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++)
				escribirPartida(arr[i][j], "Memorama", i, j);
		}


		/* Código que nos permite imprimir al arreglo "arr" como tablero. */
		for(int i = 0; i < arr.length; i++){
			System.out.println(green + " -------------------------------------------------------------" + reset);
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(green + " | " + reset + arr[i][j]);
			}
			System.out.print(green + " |" + reset);
			System.out.println();
		}
		System.out.println(green + " -------------------------------------------------------------\n" + reset);
	}


	/**
	 * ACTIVIDAD 5.
	 * Método que permite realizar una partida.
	 * @throws InvalidCardException se lanza cuando se quiere voltear la misma carta ó
	 * cuando se quiere voltear una carta cuyo símbolo ya es visible.
	 */
	public static void juegaPartida() throws InvalidCardException{
		Memorama m1 = new Memorama();
		Scanner sc = new Scanner(System.in);
		String nombre = "";

		System.out.println(yellow + "\n Selecciona las coordenadas de tus dos cartas (RANGO 0-3)" + reset);
		System.out.println(cyan + "\n Coordenadas CARTA 1 " + reset);
		int f1 = verifica(sc," -Fila: ");
		int col1 = verifica(sc," -Columna: ");

		System.out.println( cyan + "\nCoordenadas CARTA 2: " + reset);
		int f2 = verifica(sc," -Fila: ");
		int col2 = verifica(sc," -Columna: ");
		System.out.print("\n");

		/* Casos donde lanzamos la excepción InvalidCardException. */
		if((f1 == f2) && (col1 == col2)){
			throw new InvalidCardException("\n  ¡¡¡ NO SE PUEDE VOLTEAR LA MISMA CARTA !!!");
		}

		if(arr[f1][col1].getEsVisible() == true || arr[f2][col2].getEsVisible() == true){
			throw new InvalidCardException("\n  ¡¡¡ NO SE PUEDE VOLTEAR UNA CARTA YA VISIBLE !!!");
		}

		/* Código que muestra la visibilidad de dos cartas cuyas posiciones fueron dadas por el usuario. */
		arr[f2][col2].cambiaEstado();
		arr[f1][col1].cambiaEstado();

		/* Código que muestra el tablero con las dos cartas seleccionadas por el usuario */
		System.out.println(green + "\t\t\tTABLERO\n" + reset);
		for(int i = 0; i < arr.length; i++){
			System.out.println(green + " -------------------------------------------------------------" + reset);
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(green + " | "+ reset + arr[i][j]);
			}
			System.out.print(green + " |" + reset);
			System.out.println();
		}
		System.out.println(green + " -------------------------------------------------------------\n" + reset);

		/* Si las dos cartas tienen el mismo símbolo, entonces quedan visibles durante el resto de la partida. */
		if(m1.volteaCartas(arr[f1][col1], arr[f2][col2])){
			arr[f1][col1] = arr[f2][col2];
		} else {
			arr[f1][col1].cambiaEstado();
			arr[f2][col2].cambiaEstado();
		}

		muestraMenu();
		int eleccion = verificaMenu(sc);
		switch(eleccion){
			case 1:
				System.out.println(green + "\n\t ***** CONTINUAR PARTIDA ACTUAL *****" + reset);
			break;

			case 2:
				System.out.println(green + "\n\t ***** NUEVA PARTIDA *****" + reset);
				tableroInicio();
			break;

			case 3:
				System.out.println(green + "\n\t ***** GUARDAR PARTIDA ACTUAL *****" + reset);
				System.out.print("\nNombre del archivo: ");
				nombre = sc.nextLine();
				for(int i = 0; i < arr.length; i++){
					for(int j = 0; j < arr[i].length; j++){
						escribirPartida(arr[i][j], nombre, i, j);
					}
				}
				System.out.println(purple + "\n  Tu partida se ha guardado con exito en el archivo \"" + nombre + ".txt\"" + reset);
				System.out.println("\n EL JUEGO CONTINUA");
			break;

			case 4:
				System.out.println(green + "\n\t ***** CARGAR PARTIDA *****" + reset);
				System.out.println(yellow + "\nIngrese el nombre del archivo a cargar (sin extención \".txt\"): " + reset);
				String nombreArchivo = sc.nextLine();
				System.out.println(cyan + "\nLa partida guardada en el archivo " + nombreArchivo + " se ha cargado" + reset);
				leerPartida(nombreArchivo);
				System.out.println("\n EL JUEGO CONTINUA");
			break;
		}
	}


	public static void main(String [] args) throws InvalidCardException{
   		Scanner sc = new Scanner(System.in);
	  	Memorama m1 = new Memorama();
   		boolean comprueba = true;

		System.out.println(yellow + "\n\n **** BIENVENIDO AL MEMORAMA DE BOB ESPONJA **** \n" + reset);
		System.out.println(green + "\tNuestro tablero es el siguiente:\n" + reset);
		tableroInicio();

		do{
			try{
				m1.juegaPartida();

			} catch(InvalidCardException ice){
				System.out.println(purple + ice.getMessage() + reset + "\n");
				continue;
			} catch(Exception e){
				System.out.print(purple + "\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n" + reset);
				continue;
			}

		} while(finJuego() != true);

		System.out.println(cyan + "\n    FELICIDADES HAS VOLTEADO TODAS LAS CARTAS C:\n" + reset);
	}
}
