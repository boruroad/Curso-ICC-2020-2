

/** 
Su implementación debe servir para dos jugadores (dos usuarios/personas que ingresen los datos por turno), con robustes en entrada y verificación de ganador. La entrada serán las cadenas "o" y "x". El juego terminara hasta que haya un ganador o no haya más espacios libres para tirar.
Les adjunto un archivo Gato.java en el cual pueden encontrar la creación del tablero, el llenado de inicio del tablero, la impresión con formato del tablero y un caso de validación de ganador (La diagonal de izquierda superior a derecha inferior).
Por lo que les queda implementar:
-Validar verticales.
-Validar horizontales.
-Validar diagonal derecha superior a izquierda inferior.
-Validar si quedan espacios libres.
-La entrada de datos.
Pueden modificar todos los metodos a su conveniencia, cambiar firmas de metodos, nombres, etc. No cambiar el nombre del archivo ni el arreglo "gato" instanciado en el main. Recuerden que hay más de 1 forma de implementar soluciones.
Tienen hasta el viernes 11:59 pm, el ejercicio les repondrá 3 puntos en cualquiera de sus tareas pasadas.*/

import java.util.Scanner;
public class Gato{
	
		//Para imprimir el gato
	public static void imprime(String [][] gato){
		for(int i = 0; i < gato.length; i++){
				System.out.println("  ------------");// formato

			for(int j = 0; j < gato[i].length; j++){
				System.out.print(" | "+gato[i][j]);
			}
			System.out.print(" |"); //Solo es formato. 
			System.out.println();
		}

	}

	public static void imprimePlantilla(String [][]plantilla){
		System.out.println("    0   1   2");
		System.out.println("0 | "+"-"+" | "+"-"+" | "+"-"+" | ");
		System.out.println("  ------------");
		System.out.println("1 | "+"-"+" | "+"-"+" | "+"-"+" | ");
		System.out.println("  ------------");
		System.out.println("2 | " +"-"+" | "+"-"+" | "+"-"+" | ");
			
	} 

	//Método hayGanador
	/*public static boolean hayGanador(String [][] gato){
		String diagIzqDer = revisaDialogalIzqDer(gato);
		if(!diagIzqDer.equals("")){
			System.out.println(diagIzqDer);
			return true;
			}

		return false;
	}*/


	//Método para revisar diagonal a la izquierda
	public static String revisaDialogalIzqDer(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 0; i < gato.length && j < gato[i].length; i++, j++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";

	}


	public static String tache(String [][]arreglo , int renglon,int casilla  ){
		return arreglo [renglon][casilla]="X";		
	}

	public static String circulo(String [][]arreglo , int renglon,int casilla  ){
		return arreglo[renglon][casilla]="O";		
	}	



	//Método que indica si una casilla esta disponible o no
	public static boolean disponible(String [][]arreglo , int renglon,int casilla){
		boolean libre;
		if(arreglo[renglon][casilla].equals("-")){
			//System.out.println("Esa casilla está ocupada");
			libre = true;
		}else{
			libre = false;
		}
		return libre;
	}

//MÉTODOS PARA VALIDAR LA JUGADA 

	//MÉTODO PARA REVISAR DIAGONAL IZQ-DER.
	public static String revisaDiagoIzqDer(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 0; i < gato.length && j < gato[i].length; i++, j++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR DIAGONAL DER-IZQ.
	public static String revisaDiagoDerIzq(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 2; i < gato.length && j < gato[i].length; i++, j--){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR VERTICAL SUPERIOR.
	public static String revisaVerticalSup(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 0; i < gato.length && j < gato[i].length; j++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR VERTICAL DE ENMEDIO.
	public static String revisaVerticalEnmedio(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 1, j = 0; i < gato.length && j < gato[i].length; j++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR VERTICAL DE INFERIOR.
	public static String revisaVerticalInf(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 2, j = 0; i < gato.length && j < gato[i].length; j++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR HORIZONTAL DE LA IZQUIERDA.
	public static String revisaHorizontalIzq(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 0; i < gato.length && j < gato[i].length; i++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR HORIZONTAL DE ENMEDIO.
	public static String revisaHorizontalEnmedio(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 1; i < gato.length && j < gato[i].length; i++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//MÉTODO PARA REVISAR HORIZONTAL DE LA DERECHA.
	public static String revisaHorizontalDer(String [][] gato){
		int cruz = 0, circulo = 0;
		for(int i = 0, j = 2; i < gato.length && j < gato[i].length; i++){
			if(gato[i][j].equals("O"))
				circulo++;
			if(gato[i][j].equals("X"))
				cruz++;
		}
		if(cruz == gato.length)
			return "Gana cruz";
		else if(circulo == gato.length)
			return "Gana circulo";
		else
			return "";
	}

	//Método que define al ganador.
	public static boolean posibleGanador(String [][] gato){
		String diagIzqDer = revisaDiagoIzqDer(gato);
		if(!diagIzqDer.equals("")){
			System.out.println(diagIzqDer);
			return true;
			}

		String diagDerIzq = revisaDiagoDerIzq(gato);
		if(!diagDerIzq.equals("")){
			System.out.println(diagDerIzq);
			return true;
			}

		String verticalSup = revisaVerticalSup(gato);
		if(!verticalSup.equals("")){
			System.out.println(verticalSup);
			return true;
			}

		String verticalEnmedio = revisaVerticalEnmedio(gato);
		if(!verticalEnmedio.equals("")){
			System.out.println(verticalEnmedio);
			return true;
			}

		String verticalInf = revisaVerticalInf(gato);
		if(!verticalInf.equals("")){
			System.out.println(verticalInf);
			return true;
			}

		String horizontalIzq = revisaHorizontalIzq(gato);
		if(!horizontalIzq.equals("")){
			System.out.println(horizontalIzq);
			return true;
			}

		String horizontalEnmedio = revisaHorizontalEnmedio(gato);
		if(!horizontalEnmedio.equals("")){
			System.out.println(horizontalEnmedio);
			return true;
			}

		String horizontalDer = revisaHorizontalDer(gato);
		if(!horizontalDer.equals("")){
			System.out.println(horizontalDer);
			return true;
			}

		return false;
	}

	public static String verificarMovimiento(String [][] arreglo, int renglon,int casilla ){
		if(disponible(arreglo,renglon,casilla)!=true){
			
		}
		return"No sea tramposo! (≖_≖ )";
	}


	
///////////////////////////////

	public static void main(String arg []){
		Scanner entrada = new Scanner(System.in);
		String gato [][] = new String [3][3];
		String plantilla [][] = new String [3][3];

		System.out.println("\t\t\t*** JUGUEMOS ****");
		System.out.println("\t**** Gato // Tic Tac Toe // Tres en Raya **** \n ");


       	System.out.println("Ingresa el nombre del jugador 1");
       	String player1 = entrada.next();

   		System.out.println("\nAhora el del jugador 2");
		String player2 = entrada.next();   

		for(int i = 0; i < gato.length; i++){
			for(int j = 0; j < gato.length; j++){
				gato[i][j] = "-";
			}
		}


		System.out.println("\n¿Preparados? (¬‿¬)✌ \nAqui la plantilla de muestra para el tablero. Uwu\n");
		imprimePlantilla(plantilla);//tablero



		System.out.println("\nPara tirar, escriba el número de reglón y de casilla donde desea poner "+ "\"X\" ó \"O\"");
		System.out.println("\n\t****  Que gane el más habil 【 ͡❛ʖ ❛】 ****");

		for(int i = 0; i < gato.length; i++){
			for(int j = 0; j < gato.length; j++){
				gato[i][j] = "-";
			}
		}

		//TURNO JUGADOR 1(numero 1)
		System.out.println("\nComienza "+player1+ " \"x\"");
		System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
		char verPlantilla = entrada.next().charAt(0);
			
			if(verPlantilla=='p'){
				imprimePlantilla(gato);

				System.out.println("\nRenglon: ");
				int ren =  entrada.nextInt();

				System.out.println("\nCasilla: ");
				int col =  entrada.nextInt();

				tache(gato,ren,col);
				imprime(gato);

				}else{
				System.out.println("\nRenglon: ");
				int ren =  entrada.nextInt();

				System.out.println("\nCasilla: ");
				int col =  entrada.nextInt();

				tache(gato,ren,col);
				imprime(gato);
			}




		//TURNO JUGADOR 2 (numero 2)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player2);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			 char verPlantilla1 = entrada.next().charAt(0);
			
			if(verPlantilla1=='p'){
				imprimePlantilla(gato);
			}

			System.out.println("\nRenglon: ");
			int a = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b = entrada.nextInt();

			
			while(disponible(gato,a,b)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b = entrada.nextInt();

			}

				circulo(gato,a,b);
				imprime(gato);
			
				
		
	

		//TURNO JUGADOR 1 (numero 3)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player1);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla2 = entrada.next().charAt(0);
			
			if(verPlantilla2=='p'){
				imprimePlantilla(gato);
			}

			System.out.println("\nRenglon: ");
			int a3 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b3 = entrada.nextInt();
			
			while(disponible(gato,a3,b3)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a3 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b3 = entrada.nextInt();

			}
				tache(gato,a3,b3);
				imprime(gato);
				
				
		

		//TURNO JUGADOR 2 (numero 4)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player2);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla3 = entrada.next().charAt(0);
			
			if(verPlantilla3=='p'){
				imprimePlantilla(gato);
			}
			System.out.println("\nRenglon: ");
			int a4 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b4 = entrada.nextInt();
			
			while(disponible(gato,a4,b4)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a4 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b4 = entrada.nextInt();

			}
				circulo(gato,a4,b4);
				imprime(gato);
				
				
		


		//TURNO JUGADOR 1 (numero 5)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player1);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla4 = entrada.next().charAt(0);
			
			if(verPlantilla4=='p'){
				imprimePlantilla(gato);
			}
			System.out.println("\nRenglon: ");
			int a5 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b5 = entrada.nextInt();
			
			while(disponible(gato,a5,b5)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a5 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b5 = entrada.nextInt();

			}
				tache(gato,a5,b5);
				imprime(gato);
				
				


		//TURNO JUGADOR 2 (numero 6)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player2);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla5 = entrada.next().charAt(0);
			
			if(verPlantilla5=='p'){
				imprimePlantilla(gato);
			}
			System.out.println("\nRenglon: ");
			int a6 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b6 = entrada.nextInt();
			
			while(disponible(gato,a6,b6)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a6 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b6 = entrada.nextInt();

			}
				circulo(gato,a6,b6);
				imprime(gato);
				
				
		


		//TURNO JUGADOR 1 (numero 7)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player1);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla6 = entrada.next().charAt(0);
			
			if(verPlantilla6=='p'){
				imprimePlantilla(gato);
			}
			System.out.println("\nRenglon: ");
			int a7 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b7 = entrada.nextInt();
			
			while(disponible(gato,a7,b7)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a7 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b7 = entrada.nextInt();

			}
				tache(gato,a7,b7);
				imprime(gato);
				
				
		

		//TURNO JUGADOR 2 (numero 8)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player2);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla7 = entrada.next().charAt(0);
			
			if(verPlantilla7=='p'){
				imprimePlantilla(gato);
			}
			System.out.println("\nRenglon: ");
			int a8 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b8 = entrada.nextInt();
			
			while(disponible(gato,a8,b8)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a8 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b8 = entrada.nextInt();

			}
				circulo(gato,a8,b8);
				imprime(gato);
				
				
		



		//TURNO JUGADOR 1 (numero 9)
		if(posibleGanador(gato)==false){
			System.out.println("\nTira "+player1);
			System.out.print("(Si no recuerdas la platilla teclea \"p\" para mostrarla \n pulsa cualquier tecla + ENTER para continuar )\n");
			char verPlantilla8 = entrada.next().charAt(0);
			
			if(verPlantilla8=='p'){
				imprimePlantilla(gato);
			}
			System.out.println("\nRenglon: ");
			int a9 = entrada.nextInt();
	
			System.out.println("\nCasilla: ");
			int b9 = entrada.nextInt();
			
			while(disponible(gato,a9,b9)==false){ 
				System.out.println("No sea TRAMPOSO !!! (≖_≖ ) (Mire la plantilla para saber las posiciones).");
				imprimePlantilla(plantilla);

				System.out.println("\nRenglon: ");
				a9 = entrada.nextInt();

				System.out.println("\nCasilla: ");
				b9 = entrada.nextInt();

			}
				tache(gato,a9,b9);
				imprime(gato);
				
				
		


		System.out.println("\nNADIE GANA (ง︡'-'︠)ง\n");
	posibleGanador(gato);
		
		}}}}}}}}









		
	}	


}


	


	
