import java.util.Scanner;

/**
 * Proyecto 3: Listas.
 * En ésta clase hacemos uso de todos los métodos creados en la clase
 * "Lista" para que el usuario construya a sus propios alebrijes.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Fabrica{

	/** Método que hace la primera letra de una cadena en Minúscula **/
	 public static String min(String cadena){
	 int p = 0;
	 String c = cadena.substring(p,p+1).toLowerCase();
	 String t = c + cadena.substring(p+1,cadena.length());
	 return t;
	 }
	 
	 /** Método que muestra el menú */
	 public static void muestraMenu(){
    		System.out.println("\n-------- Por favor escoja una de las siguientes opciones -------- \n");
			System.out.println("  [1] -> Crear un alebrije nuevo.");
			System.out.println("  [2] -> Agregar elementos al catálogo.");
			System.out.println("  [3] -> Eliminar elementos del catálogo.");
			System.out.println("  [4] -> Salir del programa.");
			System.out.print("\nOpción: ");
	}

	public static void main(String[] args) {

		/** Atributos que nos servirán para poner color en consola. */
		String black = "\u001B[30m";
   		String red = "\033[31m"; 
   		String green = "\033[32m"; 
   		String yellow = "\033[33m"; 
   		String blue = "\033[34m"; 
   		String purple = "\033[35m"; 
   		String cyan = "\033[36m"; 
   		String reset = "\u001B[0m";

		/** Lista que guarda a todos los alebrijes */
		Lista lista = new Lista();
		
		/**
		 * Lista que guarda solo los colores de los alebrijes 
		 * Es útil cuando la usamos como cátalogo
		 */
		Lista  colores = new Lista();
		
		/**
		 * Lista que guarda a todos los animales
		 * Nos  sirve como auxiliar al momento de mostrar nuestro catálogo de animales.
		 */
		Lista  animales = new Lista();
		
		/** Lista que guarda animales para otorgar al alebrije sus partes del cuerpo. */
		Lista partes = new Lista(); 

		/**
		 * Creamos nuestras partes de Animales con sus debidos parámetros 
		 * dados por el método conctructor para cada uno delos los alebrijes
		 */
		//Alebrije p1 = new Alebrije("gato","perro",yellow + "amarillo" + reset,"rosa");
		//Alebrije p2 = new Alebrije("oso","pez",green + "verde" + reset,"guinda");
		//Alebrije p3 = new Alebrije("ratón","dragón",blue +"azul" + reset,"fosforescente");
		//Alebrije p4 = new Alebrije("conejo","buey","café","violeta");
		//Alebrije p5 = new Alebrije("pinguino","león","negra","morado");
		//Alebrije p6 = new Alebrije("coyote","águila","blanco","coral");
		//Alebrije p7 = new Alebrije("erizo" ,"rana",red + "rojo" + reset,"dorado");
		//Alebrije p8 = new Alebrije("cocodrilo" ,"tucán","blanco","plateado");
		//Alebrije p9 = new Alebrije("jirafa","serpiente","naranja","magenta");
		//Alebrije p10 =new Alebrije("cebra","cobra","blanco","azul rey");

		Alebrije p1 = new Alebrije("gato","perro",yellow + "amarillo canario" + reset,blue+"azul"+reset);
		Alebrije p2 = new Alebrije("oso","pez",green + "verde" + reset,yellow+"amarillo"+reset);
		Alebrije p3 = new Alebrije("ratón","dragón",blue +"azul"+reset,cyan+"cyan"+reset);
		Alebrije p4 = new Alebrije("conejo","buey","blanco diamante",purple+"púrpura"+reset);
		Alebrije p5 = new Alebrije("pinguino","león",purple+"púrpura"+reset,"blanco");
		Alebrije p6 = new Alebrije("coyote","águila",yellow+"amarillo miel"+reset,green+"verde"+reset);
		Alebrije p7 = new Alebrije("erizo" ,"rana",red + "rojo" + reset,"blanco");
		Alebrije p8 = new Alebrije("cocodrilo" ,"tucán",cyan+"cyan"+reset,blue+"azul"+reset);
		Alebrije p9 = new Alebrije("jirafa","serpiente",black+"negro carbón"+reset,purple+"púrpura"+reset);
		Alebrije p10 =new Alebrije("cebra","cobra","blanco marfil",blue+"azul"+reset);
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
		String a1 = p1.getAnimal();
		String a2 = p2.getAnimal();
		String a3 = p3.getAnimal();
		String a4 = p4.getAnimal();
		String a5 = p5.getAnimal();
		String a6 = p6.getAnimal();
		String a7 = p7.getAnimal();
		String a8 = p8.getAnimal();
		String a9 = p9.getAnimal();
		String a10 = p10.getAnimal();

		/** Insertamos tales elementos en nuestra lista "animales" */
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
		String c1 = p1.getColor();
		String c2 = p2.getColor();
		String c3 = p3.getColor();
		String c4 = p4.getColor();
		String c5 = p5.getColor();
		String c6 = p6.getColor();
		String c7 = p7.getColor();
		String c8 = p8.getColor();
		String c9 = p9.getColor();
		String c10=p10.getColor();

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
		String d1 = p1.getAnimal2();
		String d2 = p2.getAnimal2();
		String d3 = p3.getAnimal2();
		String d4 = p4.getAnimal2();
		String d5 = p5.getAnimal2();
		String d6 = p6.getAnimal2();
		String d7 = p7.getAnimal2();
		String d8 = p8.getAnimal2();
		String d9 = p9.getAnimal2();
		String d10 = p10.getAnimal2();

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
		System.out.println("\n\n\t\"La creatividad es la inteligencia divirtiendose -Albert Einstein.\" " );
		
		System.out.println(yellow + "\n **** BIENVENIDO A LA FÁBRICA DE ALEBRIJES **** \n" + reset);
		System.out.println(cyan + "Nuestro catalogo es el siguiente: " + reset);
		System.out.println(purple + "   (Consta de "+ lista.tamanio() + " elementos)\n" + reset );
		lista.imprime();
		muestraMenu();

		/** Robustez del código*/
		while(!sc.hasNextInt()){	
			System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
			sc.next();
			System.out.print("Opción: ");
		}
		int opcion = sc.nextInt();

		/** 
		 * Código que le dice al usuario que ingrese un número válido en caso de haber ingresado un número NO 
		 * establecido en el menú, también si vuelve a ingresar un caracter le dice que ingrese un número 
		 * establecido en el menú.
		 */
		while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 ){
			System.out.println("\n¡¡¡ No hay opciones disponibles con ese número.\n Por favor ingrese una opción válida. !!!\n");	
			System.out.print("Opción: ");
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Opción: ");
			}
			opcion = sc.nextInt();
		}

		System.out.println("____________________________\n");

		do{ 
		switch (opcion){
			/** Opción uno "Crear una Alebrije" */
			case 1:
			System.out.println(cyan + "CREAR UN ALEBRIJE\n" + reset);
			/**
			 * En esta parte inicializamos una parte de alebrije como "Vacio" para despues poderla modificar 
			 * con los datos que nos de el usuario 
			 */
			Alebrije usuario = new Alebrije("Vacio","Vacio","Vacio","Vacio");

			System.out.print("¿Qué cabeza de animal te gustaría que tuviera tú alebrije? \nNuestro catálogo de animales es el siguiente, por favor seleccione el número correspondiente:\n");
			animales.imprime();
			System.out.print("\nOpción: ");

			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Opción: ");
			}
			
			int sAnimal = sc.nextInt();
			while(sAnimal < 1 || sAnimal > 10){
				System.out.println("\n¡¡¡ No hay opciones disponibles con ese número.\n Por favor ingrese una opción válida. !!!\n");	
				System.out.print("Opción: ");
				while(!sc.hasNextInt()){	
					System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
					sc.next();
					System.out.print("Opción: ");
				}
				sAnimal = sc.nextInt();
			}
			
			/**
			 * Dependiendo de la selección númerica dada por el usuario, 
			 * se modificará la cabeza que tendrá nuestro alebrije.
			 */
			switch (sAnimal){
				case 1:
					usuario.setAnimal("Cobra");				
					break;

				case 2:
					usuario.setAnimal("Serpiente");				
					break;

				case 3:
					usuario.setAnimal("Tucán");				
					break;

				case 4:
					usuario.setAnimal("Rana");				
					break;

				case 5:
					usuario.setAnimal("Águila");				
					break;
  
				case 6:
					usuario.setAnimal("León");				
					break;

				case 7:
					usuario.setAnimal("Buey");				
					break;
  
				case 8:
					usuario.setAnimal("Dragón");				
					break; 

				case 9:
					usuario.setAnimal("Pez");				
					break;
				
				case 10:
					usuario.setAnimal("Perro");				
					break;
			}

			System.out.print("\n\n¿Qué color quieres asignarle a la cabeza de tú alebrije? \nNuestro catálogo de colores es el siguiente:\n\n");
			colores.imprime();
			System.out.print("\nOpción: ");

			/** Robustez del código */
			while (!sc.hasNextInt()) {
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Opción: ");
			}

			int cabeColor = sc.nextInt();
			while (cabeColor < 1 || cabeColor > 10) {
				System.out.println(
						"\n¡¡¡ No hay opciones disponibles con ese número.\n Por favor ingrese una opción válida. !!!\n");
				System.out.print("Opción: ");
				while (!sc.hasNextInt()) {
					System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
					sc.next();
					System.out.print("Opción: ");
				}
				cabeColor = sc.nextInt();
			}
			
			/**
			 * Dependiendo de la selección númerica dada por el usuario, 
			 * se modificará el color de la cabeza que tendrá nuestro alebrije.
			 */
			switch (cabeColor) {
				case 1:
					usuario.setColorCabeza("blanco marfil" );
					break;

				case 2:
					usuario.setColorCabeza(black + "negro carbón" + reset);
					break;

				case 3:
					usuario.setColorCabeza(cyan +"cyan"+reset);
					break;

				case 4:
					usuario.setColorCabeza(red + "rojo" + reset);
					break;

				case 5:
					usuario.setColorCabeza(yellow +"amarillo miel "+reset);
					break;

				case 6:
					usuario.setColorCabeza(purple + "púrpura"+reset);
					break;

				
				case 7:
					usuario.setColorCabeza("blanco diamante");
					break;


				case 8:
					usuario.setColorCabeza(blue +"azul"+reset);
					break;

				case 9:
					usuario.setColorCabeza(green + "verde"+ reset);
					break;

				case 10:
					usuario.setColorCabeza(yellow + "amarillo canario" + reset);
					break;

			}

			System.out.println("\n¿Qué cuerpo te gustaria que tenga tú alebrije? \nNuestro catálogo de cuerpos es el siguiente (Escoje el correspondiente a):\n");
			partes.imprime();
			System.out.print("\nOpción: ");

			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Opción: ");
			}
			int body = sc.nextInt();

			/** Robustez del código */
			while (body < 1 || body > 10){
				System.out.println("\n¡¡¡ No hay opciones disponibles con ese número.\n Por favor ingrese una opción válida. !!!\n");	
				System.out.print("Opción: ");
				while(!sc.hasNextInt()){	
					System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
					sc.next();
					System.out.print("Opción: ");
				}
			 body = sc.nextInt();
			}

			/**
			 * Dependiendo de la selección númerica dada por el usuario, 
			 * se modificará el cuerpo que tendrá nuestro alebrije.
			 */
			switch (body) {
				case 1:
					usuario.setAnimal2("cebra");				
					break;
	
				case 2:
					usuario.setAnimal2("jirafa");				
					break;

				case 3:
					usuario.setAnimal2("cocodrilo");				
					break;

				case 4:
					usuario.setAnimal2("erizo");				
					break;

				case 5:
					usuario.setAnimal2("coyote");				
					break;

				case 6:
					usuario.setAnimal2("pinguimo");				
					break;

				case 7:
					usuario.setAnimal2("conejo");				
					break;

				case 8:
					usuario.setAnimal2("ratón");				
					break;

				case 9:
					usuario.setAnimal2("oso");				
					break;

				case 10:
					usuario.setAnimal2("gato");				
					break;
			
			}
			System.out.print("\n\n¿Qué color quieres que tenga tú alebrije? \nNuestro catálogo de colores es el siguiente:\n\n");
			colores.imprime();
			System.out.print("\nOpción: ");

			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Opción: ");
			}

			int sColor = sc.nextInt();

			while(sColor < 1 || sColor > 10){
				System.out.println("\n¡¡¡ No hay opciones disponibles con ese número.\n Por favor ingrese una opción válida. !!!\n");	
				System.out.print("Opción: ");
				while(!sc.hasNextInt()){	
					System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
					sc.next();
					System.out.print("Opción: ");
				}
				sColor = sc.nextInt();
			}
			
			/**
			 * Dependiendo de la selección númerica dada por el usuario, 
			 * se modificará el color que tendrá nuestro alebrije.
			 */
			switch (sColor) {
				case 1:
					usuario.setColor("blanco marfil");
					break;

				case 2:
					usuario.setColor(black+ "negro carbón" + reset);
					break;

				case 3:
					usuario.setColor(cyan +"cyan"+reset);
					break;

				case 4:
					usuario.setColor(red+"rojo"+reset);
					break;

				case 5:
					usuario.setColor(yellow+"amarillo miel"+reset);
					break;

				case 6:
					usuario.setColor(purple+"púrpura"+reset);
					break;

				case 7:
					usuario.setColor("blanco diamante" );
					break;

				case 8:
					usuario.setColor(blue+"azul"+reset);
					break;

				case 9:
					usuario.setColor(green + "verde"+ reset);
					break;

				case 10:
					usuario.setColor(yellow+"amarillo canario"+reset);
					break;
					
				
			}
			/**Creamos e imprimimos al nuevo alebrije creado por el usuario. */ 
			System.out.println("\nEnhorabuena !!! \nTu alebrije se ha creado:");
			System.out.print("Tiene... ");
			System.out.println(usuario);
			System.out.println("\n¿Deseas guardar tu alebrije para que se añada a nuestro catálogo?\n \n[1]---> •Si \n[2]---> •No");
			System.out.print("\nRespuesta: ");
			//int eleccion = sc.nextInt();

			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos ");
				sc.next();
				System.out.print("\nRespuesta: ");
			}
			int eleccion = sc.nextInt();
			while(eleccion != 1 && eleccion != 2){
				System.out.println("\nPor favor ingrese una opción válida. ");	
				System.out.print("\nRespuesta: ");
				while(!sc.hasNextInt()){	
				System.out.println("\nPor favor ingrese una opción válida. ");	
					sc.next();
					System.out.print("\nRespuesta: ");
				}
				eleccion = sc.nextInt();
			}

			if(eleccion == 1){
				System.out.println("\n\t¡¡¡ Tu Alebrije se ha guardado en nuestro catálogo con éxito !!! ");
				lista.insertaFinal(usuario);
				lista.imprime();
				System.out.println("\n   (Nuestro catálogo consta de "+ lista.tamanio() + " elementos)\n");

			}
			if(eleccion ==2){
			}
			muestraMenu();
			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos ");
				sc.next();
				System.out.print("\nOpción: ");
			}
			 opcion = sc.nextInt();
			while(opcion < 1 || opcion > 4){
				System.out.println("\nPor favor ingrese una opción válida. ");	
				System.out.print("\nOpción: ");
				while(!sc.hasNextInt()){	
				System.out.println("\nPor favor ingrese una opción válida. ");	
					sc.next();
					System.out.print("\nOpción: ");
				}
				opcion = sc.nextInt();
			}
			break;
			
			/** Opción dos "Agregar elementos al catálogo" */
			case 2:
			System.out.println(cyan + "\nAGREGAR ELEMENTOS AL CATÁLOGO\n" + reset);
			System.out.println("(Puedes agregar una cabeza de un nuevo animal, su parte del cuerpo, asi como sus respectivos colores)");
			System.out.println("Ingrese la cabeza de animal que deseas añadir:");
			String cabe = sc.next();
			System.out.println("\nIngrese algún color para la cabeza del animal:");
			String colorC = sc.next();
			System.out.println("\nIngrese el cuerpo del animal que deseas añadir:");
			String ani2 = sc.next();
			System.out.println("\nIngrese el color del cuerpo para animal:");
			String color = sc.next();
			System.out.println("Felicidades !!! Tu nuevo alebrije se ha añadido al catálogo: \n");
			Alebrije parDeAnim = new Alebrije(ani2,cabe,color,colorC);
			lista.insertaFinal(parDeAnim);
			lista.imprime();
			System.out.println("\n   (Nuestro catálogo consta de "+ lista.tamanio() + " elementos)\n");
			muestraMenu();
			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos ");
				sc.next();
				System.out.print("\nOpción: ");
			}
			 opcion = sc.nextInt();
			while(opcion < 1 || opcion > 4){
				System.out.println("\nPor favor ingrese una opción válida. ");	
				System.out.print("\nOpción: ");
				while(!sc.hasNextInt()){	
				System.out.println("\nPor favor ingrese una opción válida. ");	
					sc.next();
					System.out.print("\nOpción: ");
				}
				opcion = sc.nextInt();
			}
			break;

			/** Opción tres "Quitar elementos al catálogo" */
			case 3:
			System.out.println(cyan + "\nQUITAR ELEMENTOS AL CATÁLOGO\n" + reset);
			System.out.println("Puedes eliminar alguna parte de animal con su repectivo color del catálogo\n");
			lista.imprime();
			System.out.print("\nElemento a eliminar del catálogo: ");

			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
				sc.next();
				System.out.print("Elemento a eliminar del catálogo: ");
			}
			
			int elimina = sc.nextInt();
			while(elimina < 1 || elimina > lista.tamanio()){
				System.out.println("\n¡¡¡ No hay opciones disponibles con ese número.\n Por favor ingrese una opción válida. !!!\n");	
				System.out.print("Elemento a eliminar del catálogo: ");
				while(!sc.hasNextInt()){	
					System.out.println("\n¡¡¡ Los caracteres no son validos !!!\n");
					sc.next();
					System.out.print("Elemento a eliminar del catálogo: ");
				}
				elimina = sc.nextInt();
			}
			lista.quita(elimina,lista);
			System.out.println("\n   (Nuestro catálogo consta de "+ lista.tamanio() + " elementos)\n");
			muestraMenu();
			/** Robustez del código */
			while(!sc.hasNextInt()){	
				System.out.println("\n¡¡¡ Los caracteres no son validos ");
				sc.next();
				System.out.print("\nOpción: ");
			}
			 opcion = sc.nextInt();
			while(opcion < 1 || opcion > 4){
				System.out.println("\nPor favor ingrese una opción válida. ");	
				System.out.print("\nOpción: ");
				while(!sc.hasNextInt()){	
				System.out.println("\nPor favor ingrese una opción válida. ");	
					sc.next();
					System.out.print("\nOpción: ");
				}
				opcion = sc.nextInt();
			}
			break;

			case 4:
			/**  
			 * Opción cuatro cierre del programa con la opción
			 * "Salir del programa"
			 */
			System.out.println("Gracias por usar nuestra Fabrica de Alebrijes.\n Vuelva pronto C:\n");
			break;
			
			default:
        		while(opcion < 1 || opcion > 4){ 
        		System.out.println("\nOpción inválida (Ingrese un número para realizar otra de las opciones o pulsa 4 para salir)");
            	opcion = sc.nextInt();
            	}
			}
		}while(opcion != 4);
		System.out.println("\nGracias por usar nuestra Fabrica de Alebrijes.\n Vuelva pronto C:\n");
		}	
}