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
 * En ésta clase hacemos uso de todos los métodos creados en la clase "Lista" para que el usuario
 * construya a sus propios alebrijes. También incluímos la lectura y escritura de archivos para
 * que el usuario pueda recuperar o guardar datos.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Fabrica{

	/**
	 * Método que nos permite escribir en un fichero los alebrijes creados por el usuario durante ejecución.
	 * @param nuevo un objeto de tipo Alebrije.
	 */
	public static void escribirAlebrije(Alebrije nuevo){
		String purple = "\033[35m";
		String reset = "\u001B[0m";
		try{
			File f = new File("archivo.txt");
			FileWriter fw;
			BufferedWriter bw;

			/* Leyéndo el API de Java nos encontramos con el método "exists()" el cual es parte de la
			   clase "File" en Java. Esta función determina si existe o no un archivo o directorio indicado
			   por el nombre de archivo abstracto. La función devuelve verdadero si la
			   ruta del archivo abstracto existe o si no devuelve falso.*/
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(nuevo.cabeza + "," + nuevo.colorCabeza + "," + nuevo.cuerpo + "," + nuevo.colorCuerpo);
			} else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(nuevo.cabeza + "," + nuevo.colorCabeza + "," + nuevo.cuerpo + "," + nuevo.colorCuerpo);
			}
			bw.close();
			fw.close();
		} catch(FileNotFoundException fnfe){
			System.out.println(purple + "   ¡¡¡ NO SE ENCONTRÓ EL FICHERO !!!" + reset);
		} catch (Exception e){
			System.out.println(purple + "   ¡¡¡ ALGO INESPERADO OCURRIÓ !!!" + reset);
		}
	}

	/**
	 * Método que nos permite leer un archivo con los alebrijes creados por el usuario durante ejecución.
	 * @param nombreDelArchivo el archivo a leer.
	 */
	public static void imprimir(String nombreDelArchivo){
		Scanner sc = new Scanner(System.in);
		String purple = "\033[35m";
		String green = "\033[32m";
   		String reset = "\u001B[0m";
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
					String [] c= linea.split(",");
					Alebrije a = new Alebrije(c[0],c[1],c[2],c[3]);
					a.ensenia();
					System.out.println(green + "\n ****************************\n" + reset);
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
	 * Método que nos permite escribir en un fichero los alebrijes creados por el usuario durante ejecución.
	 * @param nuevo un objeto de tipo Alebrije.
	 * @param c nombre con el que se llamará el archivo.
	 * @param a distintivo del método.
	 */
	public static void escribirAlebrije(Alebrije nuevo, String c, char a){
		String purple = "\033[35m";
		String reset = "\u001B[0m";
		try{
			File f = new File(c + ".txt");
			FileWriter fw;
			BufferedWriter bw;
			if(f.exists()){
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(nuevo.cabeza+","+ nuevo.colorCabeza
					+","+nuevo.cuerpo+","+nuevo.colorCuerpo);
			}else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(nuevo.cabeza+","+ nuevo.colorCabeza
					+","+nuevo.cuerpo+","+nuevo.colorCuerpo);
			}
			bw.close();
			fw.close();

		} catch(FileNotFoundException fnfe){
			System.out.println(purple + "   ¡¡¡ NO SE ENCONTRÓ EL FICHERO !!!" + reset);
			muestraMenu();
		}catch (Exception e){
			System.out.println(purple + "   ¡¡¡ ALGO INESPERADO OCURRIÓ !!!" + reset);
			muestraMenu();
		}
	}

	/**
	 * Método que nos permite escribir en un fichero los alebrijes creados por el usuario durante ejecución.
	 * @param nuevo un objeto de tipo Alebrije.
	 * @param c nombre con el que se llamará el archivo.
	 */
	public static void escribirAlebrije(Alebrije nuevo, String c){
		String purple = "\033[35m";
		String reset = "\u001B[0m";
		try{
			File f = new File(c+".txt");
			FileWriter fw;
			BufferedWriter bw;
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(nuevo.cabeza + "," + nuevo.colorCabeza + "," + nuevo.cuerpo + "," + nuevo.colorCuerpo);
			} else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(nuevo.cabeza + "," + nuevo.colorCabeza + "," + nuevo.cuerpo + "," + nuevo.colorCuerpo);
			}
			bw.close();
			fw.close();
		} catch(FileNotFoundException fnfe){
			System.out.println(purple + "   ¡¡¡ NO SE ENCONTRÓ EL FICHERO !!!" + reset);
		}catch (Exception e){
			System.out.println(purple + "   ¡¡¡ ALGO INESPERADO OCURRIÓ !!!" + reset);
		}
	}



	/** Método que hace la primera letra de una cadena en Minúscula **/
	public static String min(String cadena){
		int p = 0;
		String c = cadena.substring(p, p+1).toLowerCase();
		String t = c + cadena.substring(p+1, cadena.length());
		return t;
	}

	/** Método que muestra el menú */
	public static void muestraMenu(){
		String yellow = "\033[33m";
   		String reset = "\u001B[0m";
    	System.out.println(yellow + "\n-------- Por favor escoja una de las siguientes opciones -------- \n" + reset);
		System.out.println("  [1] --> Crear un alebrije nuevo.");
		System.out.println("  [2] --> Agregar elementos al catálogo.");
		System.out.println("  [3] --> Eliminar elementos del catálogo.");
		System.out.println("  [4] --> Ver // Editar archivos.");
		System.out.println("  [5] --> Salir del programa.");
	}

	/**
	 * Método que nos permite verificar la robustez de lo que ingrese el usuario como opción en el menú.
	 * @param sc la opcion que el usuario teclee.
	 * @return una opción correcta (en caso de que el usuario haya tecleado algo mal, ya que se obligará
	 * al usuario a ingresar una opción válida).
	 */
	public static int verificaMenu (Scanner sc){
		String purple = "\033[35m";
		String reset = "\u001B[0m";
		int n;
		while(true){
			try{
				System.out.print("\nOpción: ");
				n = Integer.parseInt(sc.nextLine());
				if(n < 1 || n > 5){
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
   * Método que nos permite verificar la robustez de lo que ingrese el usuario (rango de opciones válidas 1 a 10).
   * @param sc la opcion que el usuario teclee durante la ejecución de la opcion 1 del menú.
   * @return una opción correcta (en caso de que el usuario haya tecleado algo mal, ya que se obligará al usuario a
	 * ingresar una opción válida).
   */
	public static int checa (Scanner sc){
		String purple = "\033[35m";
		String reset = "\u001B[0m";
		int n;
		while(true){
			try{
				System.out.print("\nOpción: ");
				n = Integer.parseInt(sc.nextLine());
				if(n < 1 || n > 10){
					throw new InvalidNumberException("NÚMERO FUERA DE RANGO");
				}
				break;
			} catch(NumberFormatException nfe){
				System.out.print(purple + "\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n" + reset);
				continue;
			} catch(InvalidNumberException ine){
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
   * Método que nos permite verificar la robustez de lo que ingrese el usuario (rango de opciones válidas 1 a 2).
   * @param sc la opcion que el usuario teclee durante la ejecución de la opcion 1 del menú.
   * @return una opción correcta (en caso de que el usuario haya tecleado algo mal, ya que se obligará al usuario a
	 * ingresar una opción válida).
   */
	public static int checa2(Scanner sc){
		String purple = "\033[35m";
		String reset = "\u001B[0m";
		int n;
		while(true){
			try{
				System.out.print("Opción: ");
				n = Integer.parseInt(sc.nextLine());
				if(n < 1 || n > 2){
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


	public static void main(String[] args) throws InvalidNumberException {

		/** Atributos que nos servirán para poner color en consola. */
		String black = "\u001B[30m";
   		String red = "\033[31m";
   		String green = "\033[32m";
   		String yellow = "\033[33m";
   		String blue = "\033[34m";
   		String purple = "\033[35m";
   		String cyan = "\033[36m";
   		String reset = "\u001B[0m";

   		Alebrije usuario = new Alebrije("Vacio","Vacio","Vacio","Vacio");

		/** Lista que guarda a todos los alebrijes */
		Lista lista = new Lista();

		/**
		 * Lista que guarda solo los colores de los alebrijes.
		 * Es útil cuando la usamos como cátalogo
		 */
		Lista  colores = new Lista();

		/**
		 * Lista que guarda a todos los animales.
		 * Nos sirve como auxiliar al momento de mostrar nuestro catálogo de animales.
		 */
		Lista  animales = new Lista();

		/** Lista que guarda animales para otorgar al alebrije sus partes del cuerpo. */
		Lista partes = new Lista();

		/**
		 * Creamos nuestras partes de Animales con sus debidos parámetros
		 * dados por el método conctructor para cada uno delos los alebrijes
		 */
		Alebrije p1 = new Alebrije("perro","azul","gato","amarillo");
		Alebrije p2 = new Alebrije("pez","amarillo","oso","verde");
		Alebrije p3 = new Alebrije("dragón","cyan","ratón","azul");
		Alebrije p4 = new Alebrije("conejo","púrpura","elefante","morado");
		Alebrije p5 = new Alebrije("león","blanco","pingüino","rojo");
		Alebrije p6 = new Alebrije("águila","verde","coyote","anaranjado");
		Alebrije p7 = new Alebrije("rana" ,"blanco","erizo","negro");
		Alebrije p8 = new Alebrije("tucán" ,"azul","cocodrilo","rosa");
		Alebrije p9 = new Alebrije("serpiente","púrpura","jirafa","café");
		Alebrije p10 =new Alebrije("cobra","azul","cebra","gris");

		escribirAlebrije(p1);
		escribirAlebrije(p2);
		escribirAlebrije(p3);
		escribirAlebrije(p4);
		escribirAlebrije(p5);
		escribirAlebrije(p6);
		escribirAlebrije(p7);
		escribirAlebrije(p8);
		escribirAlebrije(p9);
		escribirAlebrije(p10);

		/**
		 * Insertamos los elementos a la lista a partir de los animales
		 * ya pre-cargados que tenemos en nuestro catálogo
		 */
		lista.insertaPrimero(p1);
		lista.insertaPrimero(p2);
		lista.insertaPrimero(p3);
		lista.insertaPrimero(p4);
		lista.insertaPrimero(p5);
		lista.insertaPrimero(p6);
		lista.insertaPrimero(p7);
		lista.insertaPrimero(p8);
		lista.insertaPrimero(p9);
		lista.insertaPrimero(p10);

		/**
		 * Creamos variables de tipo String las cuales nos van a representar unicamente
		 * las cabezas de los alebrijes
		 */
		String a1 = p1.getCabeza();
		String a2 = p2.getCabeza();
		String a3 = p3.getCabeza();
		String a4 = p4.getCabeza();
		String a5 = p5.getCabeza();
		String a6 = p6.getCabeza();
		String a7 = p7.getCabeza();
		String a8 = p8.getCabeza();
		String a9 = p9.getCabeza();
		String a10 = p10.getCabeza();

		/** Insertamos tales "cabezas" en nuestra lista "animales" */
		animales.insertaPrimero(a1);
		animales.insertaPrimero(a2);
		animales.insertaPrimero(a3);
		animales.insertaPrimero(a4);
		animales.insertaPrimero(a5);
		animales.insertaPrimero(a6);
		animales.insertaPrimero(a7);
		animales.insertaPrimero(a8);
		animales.insertaPrimero(a9);
		animales.insertaPrimero(a10);

		/**
		 * Creamos variables de tipo string las cuales solo nos dicen
		 * el color de cada parte de animal que viene dada en el constructor
		 * y la tomamos a través de su método de acceso
		 */
		String c1 = p1.getColorCuerpo();
		String c2 = p2.getColorCuerpo();
		String c3 = p3.getColorCuerpo();
		String c4 = p4.getColorCuerpo();
		String c5 = p5.getColorCuerpo();
		String c6 = p6.getColorCuerpo();
		String c7 = p7.getColorCuerpo();
		String c8 = p8.getColorCuerpo();
		String c9 = p9.getColorCuerpo();
		String c10=p10.getColorCuerpo();

		/** Insertamos  estos "colores" en nuestra lista "colores" */
		colores.insertaPrimero(c1);
		colores.insertaPrimero(c2);
		colores.insertaPrimero(c3);
		colores.insertaPrimero(c4);
		colores.insertaPrimero(c5);
		colores.insertaPrimero(c6);
		colores.insertaPrimero(c7);
		colores.insertaPrimero(c8);
		colores.insertaPrimero(c9);
		colores.insertaPrimero(c10);


		/**
		 * Creamos variables de tipo string las cuales nos van a servir para guardar
		 * sus valores en una nueva lista pero antes, estos valore nos representan
		 * la parte del cuerpo del alebrije.
		 */
		String d1 = p1.getCuerpo();
		String d2 = p2.getCuerpo();
		String d3 = p3.getCuerpo();
		String d4 = p4.getCuerpo();
		String d5 = p5.getCuerpo();
		String d6 = p6.getCuerpo();
		String d7 = p7.getCuerpo();
		String d8 = p8.getCuerpo();
		String d9 = p9.getCuerpo();
		String d10 = p10.getCuerpo();

		/**  Insertamos éstas partes en nuestra lista "partes" */
		partes.insertaPrimero(d1);
		partes.insertaPrimero(d2);
		partes.insertaPrimero(d3);
		partes.insertaPrimero(d4);
		partes.insertaPrimero(d5);
		partes.insertaPrimero(d6);
		partes.insertaPrimero(d7);
		partes.insertaPrimero(d8);
		partes.insertaPrimero(d9);
		partes.insertaPrimero(d10);

		//////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		Scanner lector = new Scanner(System.in);
		String nombre = "";

		System.out.println("\n  \"La creatividad es la inteligencia divirtiéndose\"  -Albert Einstein." );
		System.out.println(yellow + "\n      **** BIENVENIDO A LA FÁBRICA DE ALEBRIJES **** \n" + reset);
		System.out.println(cyan + "  Nuestro catalogo es el siguiente: " + reset +" (Cargando \"archivo.txt\")");
		System.out.println(purple + "    (Consta de "+ lista.tamanio() + " elementos)" + reset );
		imprimir("archivo");

		muestraMenu();

		/** Robustez del código */
		int opcion = verificaMenu(sc);

		System.out.println(green + "  ___________________________________" + reset);

		do{
			switch (opcion){

			/** Opción uno "Crear una Alebrije" */
			case 1:
			System.out.println(cyan + "   OPCIÓN 1 ----> CREAR UN ALEBRIJE\n" + reset);

			/**
			 * En esta parte inicializamos una parte de alebrije como "Vacio" para despues poderla modificar
			 * con los datos que nos de el usuario
			 */
			System.out.println(" (Nuestro catálogo de animales es el siguiente, por favor seleccione el número correspondiente)");
			System.out.println(yellow + "\n ¿Qué cabeza de animal te gustaría que tuviera tú alebrije?" + reset);
			animales.imprime();

			/** Robustez del código */
			int sAnimal = checa(sc);

			/**
			 * Dependiendo de la selección númerica dada por el usuario,
			 * se modificará la cabeza que tendrá nuestro alebrije.
			 */
			switch (sAnimal){
				case 1:
					usuario.setCabeza("Cobra");
					break;

				case 2:
					usuario.setCabeza("Serpiente");
					break;

				case 3:
					usuario.setCabeza("Tucán");
					break;

				case 4:
					usuario.setCabeza("Rana");
					break;

				case 5:
					usuario.setCabeza("Águila");
					break;

				case 6:
					usuario.setCabeza("León");
					break;

				case 7:
					usuario.setCabeza("Buey");
					break;

				case 8:
					usuario.setCabeza("Dragón");
					break;

				case 9:
					usuario.setCabeza("Pez");
					break;

				case 10:
					usuario.setCabeza("Perro");
					break;
			}

			System.out.println("\n (Nuestro catálogo de colores es el siguiente, por favor seleccione el número correspondiente)");
			System.out.println(yellow + "\n ¿Qué color quieres asignarle a la cabeza de tú alebrije?" + reset);
			colores.imprime();
			int cabeColor = checa(sc);

			/**
			 * Dependiendo de la selección númerica dada por el usuario, se modificará el color de la cabeza que tendrá nuestro alebrije.
			 */
			switch (cabeColor) {
				case 1:
					usuario.setColorCabeza("gris" );
					break;

				case 2:
					usuario.setColorCabeza("café");
					break;

				case 3:
					usuario.setColorCabeza("rosa");
					break;

				case 4:
					usuario.setColorCabeza("negro");
					break;

				case 5:
					usuario.setColorCabeza("anaranjado");
					break;

				case 6:
					usuario.setColorCabeza("rojo");
					break;

				case 7:
					usuario.setColorCabeza("morado");
					break;

				case 8:
					usuario.setColorCabeza("azul");
					break;

				case 9:
					usuario.setColorCabeza("verde");
					break;

				case 10:
					usuario.setColorCabeza("amarillo");
					break;
			}

			System.out.println("\n (Nuestro catálogo de cuerpos es el siguiente, por favor seleccione el número correspondiente)");
			System.out.println(yellow + "\n ¿Qué cuerpo te gustaría que tenga tu alebrije?" + reset);
			partes.imprime();

			/** Robustez del código */
			int body = checa(sc);

			/**
			 * Dependiendo de la selección númerica dada por el usuario,
			 * se modificará el cuerpo que tendrá nuestro alebrije.
			 */
			switch (body) {
				case 1:
					usuario.setCuerpo("cebra");
					break;

				case 2:
					usuario.setCuerpo("jirafa");
					break;

				case 3:
					usuario.setCuerpo("cocodrilo");
					break;

				case 4:
					usuario.setCuerpo("erizo");
					break;

				case 5:
					usuario.setCuerpo("coyote");
					break;

				case 6:
					usuario.setCuerpo("pinguimo");
					break;

				case 7:
					usuario.setCuerpo("conejo");
					break;

				case 8:
					usuario.setCuerpo("ratón");
					break;

				case 9:
					usuario.setCuerpo("oso");
					break;

				case 10:
					usuario.setCuerpo("gato");
					break;
			}

			System.out.println("\n (Nuestro catálogo de colores es el siguiente, por favor seleccione el número correspondiente)");
			System.out.println(yellow + "\n ¿Qué color quieres asignarle al cuerpo de tú alebrije?" + reset);
			colores.imprime();

			/** Robustez del código */
			int sColor = checa(sc);

			/**
			 * Dependiendo de la selección númerica dada por el usuario,
			 * se modificará el color que tendrá nuestro alebrije.
			 */
			switch (sColor) {
				case 1:
					usuario.setColorCuerpo("gris" );
					break;

				case 2:
					usuario.setColorCuerpo("café");
					break;

				case 3:
					usuario.setColorCuerpo("rosa");
					break;

				case 4:
					usuario.setColorCuerpo("negro");
					break;

				case 5:
					usuario.setColorCuerpo("anaranjado");
					break;

				case 6:
					usuario.setColorCuerpo("rojo");
					break;

				case 7:
					usuario.setColorCuerpo("morado");
					break;

				case 8:
					usuario.setColorCuerpo("azul");
					break;

				case 9:
					usuario.setColorCuerpo("verde");
					break;

				case 10:
					usuario.setColorCuerpo("amarillo");
					break;
			}

			/**Creamos e imprimimos al nuevo alebrije creado por el usuario. */
			System.out.println("\n  ¡¡¡ Tu alebrije se ha creado !!!");
			System.out.print(cyan + "\n  Nuevo alebrije ---> " + reset);
			System.out.println(usuario + ".");
			System.out.println(yellow + "\n  ¿Deseas guardar tu alebrije para que se añada a nuestro catálogo? "
				+ reset + "\n \n  [1]---> •Si \n  [2]---> •No");

			/** Robustez del código */
			int eleccion = checa2(sc);

			if(eleccion == 1){
				System.out.print("\nNombre del archivo: ");
				nombre = sc.nextLine();
				escribirAlebrije(usuario,nombre);
				imprimir(nombre);
				System.out.println(cyan + "\n\t¡¡¡ Tu Alebrije se ha guardado en nuestro catálogo con éxito !!! " + reset);
				System.out.println(green + "\n\t     Tu Alebrije se ha guardado en el archivo \"" + nombre + ".txt\"" + reset);
				lista.insertaFinal(usuario);
				lista.imprime();
				System.out.println(cyan + "\n\t(Nuestro catálogo consta de "+ lista.tamanio() + " elementos)\n" + reset);
			}

			if(eleccion == 2){
			}

			muestraMenu();

			/** Robustez del código */
			opcion = verificaMenu(sc);
			break;

			/** Opción dos "Agregar elementos al catálogo" */
			case 2:
			System.out.println(cyan + "\n   OPCIÓN 2 ----> AGREGAR ELEMENTOS AL CATÁLOGO\n" + reset);
			System.out.println("(Puedes agregar una cabeza de un nuevo animal, su parte del cuerpo, asi como sus respectivos colores)");
			System.out.println(yellow + "\n  Ingrese la cabeza de animal que deseas añadir:" + reset);
			String cabe = lector.next();
			System.out.println(yellow + "\n  Ingrese algún color para la cabeza del animal:" + reset);
			String colorC = lector.next();
			System.out.println(yellow + "\n  Ingrese el cuerpo del animal que deseas añadir:" + reset);
			String ani2 = lector.next();
			System.out.println(yellow + "\n  Ingrese el color del cuerpo para animal:" + reset);
			String color = lector.next();
			System.out.println(cyan + "\n  ¡¡¡ Tu nuevo alebrije se ha añadido al catálogo !!! " + reset);
			usuario = new Alebrije (cabe,colorC,ani2,color);
			lista.insertaFinal(usuario);

			System.out.println(yellow + "\n  ¿Deseas añadir tu alebrije al archivo del catálogo principal? "
				+ reset + "\n \n  [1]---> •Si \n  [2]---> •No");

			/** Robustez del código */
			int eleccionArchivo = checa2(sc);

			if(eleccionArchivo == 1){
				escribirAlebrije(usuario,"archivo");
				imprimir("archivo");
				System.out.println(green + "\n\t     Tu Alebrije se ha guardado en el archivo \"archivo.txt\"" + reset);
			}

			if(eleccionArchivo == 2){
			}

			lista.imprime();
			System.out.println(cyan + "\n\t(Nuestro catálogo consta de "+ lista.tamanio() + " elementos)\n" + reset);
			muestraMenu();

			/** Robustez del código */
			opcion = verificaMenu(sc);
			break;

			/** Opción tres "Quitar elementos al catálogo" */
			case 3:
			System.out.println(cyan + "\n   OPCIÓN 3 ---> QUITAR ELEMENTOS AL CATÁLOGO" + reset);
			lista.imprime();
			int elimina;
			while(true){
				try{
					System.out.print(yellow + "\nElemento a eliminar del catálogo: " + reset);
					elimina = Integer.parseInt(sc.nextLine());
					if(elimina < 1 || elimina > lista.tamanio()){
						throw new InvalidNumberException("NÚMERO FUERA DE RANGO");
					}
					break;
				} catch(NumberFormatException nfe){
					System.out.print(purple + "\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n" + reset);
					continue;
				} catch(InvalidNumberException ine){
					System.out.print(purple + "\n ¡¡¡ OPCIÓN FUERA DE RANGO !!!\n" + reset);
					continue;
				} catch(Exception e){
					System.out.print(purple + "\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n" + reset);
					continue;
				}
			}

			lista.quita(elimina,lista);
			System.out.println(cyan + "\n\t(Nuestro catálogo consta de "+ lista.tamanio() + " elementos)\n" + reset);
			muestraMenu();

			/** Robustez del código */
			 opcion = verificaMenu(sc);
			break;

			case 4:
			System.out.println(yellow + "\n ¿Qué deseas hacer? " + reset);
			System.out.println("\n  [1] --> Mostrar archivo precargado (Catálogo completo).");
			System.out.println("  [2] --> Mostrar // Editar  archivos creados (Alebrijes).");
			Scanner entrada = new Scanner(System.in);

			/** Robustez del código */
			int opArchi = checa2(sc);

			if(opArchi == 1){
				imprimir("archivo");
				muestraMenu();
				/** Robustez del código */
				 opcion = verificaMenu(sc);
			}

			if(opArchi == 2){
				System.out.println("\n  [1] --> Mostrar");
				System.out.println("  [2] --> Editar ");

				/** Robustez del código */
				int ele = checa2(sc);
				if(ele ==1){
					System.out.print("\nÚltimo archivo creado: ");
					if((nombre == null) || (nombre == "")){
						System.out.print("(no se han creado archivos recientemente)");
					} else {
						System.out.print(nombre+".txt");
					}
					System.out.println(yellow + "\nIngrese el nombre del archivo a visualizar (sin extención \".txt\"): " + reset);
					String nombreArchivo = sc.nextLine();
					System.out.println("La cantidad de alebrijes dentro de un MISMO ARCHIVO es a elección del usuario");
					imprimir(nombreArchivo);
					muestraMenu();

					/** Robustez del código */
					 opcion = verificaMenu(sc);
				}

				if(ele == 2){
					System.out.print("\nÚltimo archivo creado: ");
					if((nombre == null) || (nombre == "")){
						System.out.print("(no se han creado archivos recientemente)");
					} else {
						System.out.print(nombre+".txt");
					}
					System.out.println(cyan + "\n\n ADVERTENCIA: Al editar un archivo que contiene más de un alebrije, la edición del alebrije será aplicada al último creado y eliminará los anteriores. " + reset);
					System.out.println(yellow + "\nIngrese el nombre del archivo a modificar (sin extención \".txt\"): " + reset);
					String nA = sc.nextLine();
					if(nA.equals("archivo")){
						System.out.println(purple + "\nNo tienes las crededenciales válidas para editar éste archivo" + reset);
						continue;
					}
					File f = new File(nA+".txt");
					if(f.exists()){
						imprimir(nA);
						System.out.println(yellow + "¿Qué deseas modificar? " + reset + "\n\n [1] --> Cabeza.  \n [2] --> Color de cabeza. 	\n [3] --> Cuerpo. \n [4] --> Color del cuerpo.");
						int modifica;

						/** Robustez del código */
						while(true){
							try{
								System.out.print("\nOpción: ");
								modifica = Integer.parseInt(sc.nextLine());
								if(modifica < 1 || modifica > 4){
									throw new InvalidNumberException("NÚMERO FUERA DE RANGO");
								}
								break;
							} catch(NumberFormatException nfe){
								System.out.print(purple + "\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n" + reset);
								continue;
							} catch(InvalidNumberException ine){
								System.out.print(purple + "\n ¡¡¡ OPCIÓN FUERA DE RANGO !!!\n" + reset);
								continue;
							} catch(Exception e){
								System.out.print(purple + "\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n" + reset);
								continue;
							}
						}

						switch(modifica){
							case 1:
								System.out.println(yellow + "\n¿Qué cabeza de animal desea para su alebrije?" + reset);
								String nuevaCabeza = entrada.next();
								usuario.setCabeza(nuevaCabeza);
								escribirAlebrije(usuario,nA,'s');
								imprimir(nA);
							break;

							case 2:
							System.out.println(yellow + "\n¿Qué color desea para la cabeza de su alebrije?" + reset);
								String head = entrada.next();
								usuario.setColorCabeza(head);
								escribirAlebrije(usuario,nA,'s');
								imprimir(nA);
							break;

							case 3:
								System.out.println(yellow + "\n¿Qué cuerpo de animal desea para su alebrije?" + reset);
								String bod = entrada.next();
								usuario.setCuerpo(bod);
								escribirAlebrije(usuario,nA,'s');
								imprimir(nA);
							break;

							case 4:
							System.out.println(yellow + "\n¿Qué color desea para el cuerpo de su alebrije?" + reset);
							String nuevoColorCuerpo = entrada.next();
							usuario.setColorCuerpo(nuevoColorCuerpo);
							escribirAlebrije(usuario,nA,'s');
							imprimir(nA);
							break;
						}

						muestraMenu();
						/** Robustez del código */
						opcion = verificaMenu(sc);

					} else {
						System.out.println(purple + "\n   ¡¡¡ NO EXISTE EL ARCHIVO !!! " + reset);
						muestraMenu();
						/** Robustez del código */
						 opcion = verificaMenu(sc);
					}
				}
			}
			break;

			case 5:
			/**
			 * Opción cuatro cierre del programa con la opción
			 * "Salir del programa"
			 */
			System.out.println(cyan + "\n    Gracias por usar nuestra Fabrica de Alebrijes.\n\t\t Vuelva pronto C:\n" + reset);
			opcion = 6;
			sc.close();
			break;
			}
		} while(opcion != 6);
	}
}
