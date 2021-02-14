/**
 * BuscaMinas
 * @author Bonilla Ruiz Roberto Adrian
 * @author Cristobal Morales Karen
 * @version 9.0  Mayo 2020
 */

//----------------------------------------------------------------------
/**Antes de evaluar este código asi como la realización de esta tarea, es bueno 
   mencionar que trabajé en compañia de mi compañera Karen, debido al grado de dificultad que nos 
   llevo hacer esto y puesto que al tener las mismas dudas en ciertas ocasiones, tomamos el consejo de ayudarnos entre 
   computologos y empezar a "codear" juntos. Haciendo incapie en esto puesto que aunque nuestros códigos pueden ser similares
   NO FUERON COPIADOS pero si fueron hechos al mismo tiempo ya que entre los dos podiamos explicarnos las 
   dudas o problemas que surgian al compilar, es por ello que añado su nombre en la lista de autores asi como la 
   version 9 de este trabajo debido a la gran cantidad de pruebas que tuvimos que realizar para obtener lo que seria
   el final de este trabajo */
//----------------------------------------------------------------------

import java.util.Scanner;
import java.util.Random;


public class BuscaMinas{
	public char[][]  tablero;
	public char[][]  tableroJugado;
	private int descubre;
	private Random rand = new Random();
	private boolean perdio = false;

	public BuscaMinas(int dificultad){
	 Scanner lector = new Scanner(System.in);

		switch (dificultad){
			case 1: //principiante
				this.tablero = new char[8][8];
				this.tableroJugado = new char[8][8];
				this.descubre = 2; 
				this.setMinas(10);
				this.setNumMinas();
				break;
			case 2:
				this.tablero = new char[16][16];
				this.descubre = 3;

				this.tableroJugado = new char[16][16]; 
				this.setMinas(40);
				this.setNumMinas();
				
				break;
		}
		if(dificultad == 3){

				this.tablero = new char[16][30];
				this.descubre = 4;

				this.tableroJugado = new char[16][30];
				this.setMinas(99);
				this.setNumMinas();
		} 

		if(dificultad == 4){ 
			int e1 = 0;
			int e2 = 0;
			int m = 0;

				//personalizado
			System.out.print("Dimensiones del tablero" );
		   	do{     
		   	    System.out.print("Filas: ");
		   	    while(!lector.hasNextInt()){
					System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");
					lector.next();
					System.out.print("filas: ");
				}
				 e1 = lector.nextInt();

				if(e1<=0){
				System.out.println("\nJOVEN, ESO NO SE PUEDE (No hay dimensiones cero o negativas) ʕ •́ ᴥ •̀ ʔっ");
				}

			}while(e1<=0);	

			do{ 
		   	    System.out.print("Columnas: ");
		   	    while(!lector.hasNextInt()){
					System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");
					lector.next();
					System.out.print("columnas: ");}
		   	    e2 = lector.nextInt();

		   	    if(e2<=0){
				System.out.println("\nJOVEN, ESO NO SE PUEDE (No hay dimensiones en cero o negativas) ʕ •́ ᴥ •̀ ʔっ");

				}


		   	}while(e2<=0);

		   	do{ 

		   	    System.out.print("minas: ");
		   	    while(!lector.hasNextInt()){
					System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");
					lector.next();
					System.out.print("Cantidad de minas: ");}
		   	     m = lector.nextInt();

		   	    if(m<=0){
				System.out.println("\n :c (No puedes jugar sin minas) ʕ •́ ᴥ •̀ ʔっ");
		   	    }


		   	}while(m<=0);

		   	    int mMax = e1 * e2 -1;
		   	    while(m < 1 || m > mMax){
					System.out.println("\nMínimo puedes ingresar 1 mina y máximo " + mMax + " minas");		
					System.out.print("minas: ");
					while(!lector.hasNextInt()){	
						System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");
						lector.next();
						System.out.print("minas: ");
					}
						m = lector.nextInt();
				}

				this.tablero = new char[e1][e2]; 
				this.descubre = 2;

				this.tableroJugado = new char[e1][e2];
				this.descubre = 2; 
				this.setMinas(m);
				this.setNumMinas();
		}
		
	}


//No olvides que las minas y el numero de minas en vecinos van en "tablero"
	public void setMinas(int minas){
		int contadorDeMinas = 0;
		int x,y;
		do{
			x = rand.nextInt(tablero.length);
			y = rand.nextInt(tablero[0].length);
			
			while( tablero[x][y] != ' ' && tablero[x][y] != 'x'){ 
					tablero[x][y] = 'x';
					contadorDeMinas ++;
				
				minas+= -1;
			}


			//Verificamos si la posicion (x,y) esta vacia en terminos de caracteres
			//Si esta vacia, entonces colocamos una mina en la posicion x y recuerda que la mina esta representada por 'x'
			//Ya pusimos una mina, entonces ya casi terminamos, no olvides revisar que el while no se cicle.
			
		}while(minas != 0);
		System.out.println("\nLa cantidad de minas en este nivel es de: " + contadorDeMinas+"\n");
	}


	public void setNumMinas(){
		for(int i = 0; i < this.tablero.length; i ++){
			for(int j = 0; j < this.tablero[i].length; j++){
				int minas = 0; //son las minas contabilizadas en los vecinos de la posicion i,j
				

				//Codigo: revisamos si la posicion actual es una bomba:
				if(tablero [i][j] == 'x'){
					continue;
				}
				
				//Si si, evitamos hacer el resto del codigo, pero
				//continuamos con las iteraciones.

				//-------------------- DIVIDE Y VENCERAS ------------------------
				/* En cuantos casos ves conveniente dividir este metodo?
				** Propongo lo siguiente:
				** 1) todo el interior del tablero (Si quieres continuar mi codigo, acompleta los casos faltantes)
				** 2) las casillas con i == 0: revisar casos j == 0 y j == j == tablero[i].length-1, y las coordenadas i = 0 pero 0 < j > tablero[i].length-1
				** 3) las casillas con i == tablero.length-1: revisar casos j == 0 y j == j == tablero[i].length-1, y las coordenadas i = 0 pero 0 < j > tablero[i].length-1
				** Si lo analizamos en los casos 2 y 3 ya revisamos (0,0), (0,tam), (tam,0) y (tam, tam) asi que nos queda revisar solo los interiores de j, es decir.
				** 4) las casillas con j == 0
				** 5) las casillas con j == tablero[i].length-1

				** SI MI IMPLEMENTACION NO ES DE TU AGRADO, PUEDES EMPEZARLA DESDE CERO SIN NINGUN PROBLEMA, SOLO
				** REVISANDO QUE NO TE SALGAS DE TU ARREGLO.
				*/

				//caso 1 
				if(i > 0 && j > 0 && i < tablero.length-1 && j < tablero[i].length-1){ //evitamos todo el contorno del tablero
					//revisamos las 8 casillas de vecinos

					/* Posicion i-1 j-1
					** |o |  |  |
					** |  |x |  |
					** |  |  |  |
					*/
					if(tablero[i-1][j-1] == 'x')
						minas++;

					/* Posicion i-1 j
					** |  |o |  |
					** |  |x |  |
					** |  |  |  |
					*/
					if(tablero[i-1][j] == 'x')
						minas++;


					/* Posicion i-1 j-1
					** |  |  |o |
					** |  |x |  |
					** |  |  |  |
					*/
					if(tablero[i-1][j+1] == 'x')
						minas++;

					/* Posicion i j+1
					** |  |  |  |
					** |  |x |o |
					** |  |  |  |
					*/
					if(tablero[i][j+1] == 'x')
						minas++;


					/* Posicion i+1 j+1
					** |  |  |  |
					** |  |x |  |
					** |  |  |o |
					*/
					if(tablero[i+1][j+1] == 'x')
						minas++;

					/* Posicion i j+1
					** |  |  |  |
					** |  |x |  |
					** |  |o |  |
					*/
					if(tablero[i+1][j] == 'x')
						minas++;

					/* Posicion i j+1
					** |  |  |  |
					** |  |x |  |
					** |o |  |  |
					*/
					if(tablero[i+1][j-1] == 'x')
						minas++;

					/* Posicion i j+1
					** |  |  |  |
					** |o |x |  |
					** |  |  |  |
					*/
					if(tablero[i][j-1] == 'x')
						minas++;
					
				}
				//caso 2
				if(i == 0){
					if(j==0){
						if(tablero[i][j+1] == 'x')
						minas++;
						if(tablero[i+1][j] == 'x')
							minas++;
						if(tablero[i+1][j+1] == 'x')
							minas++;
					}else if(j == tablero[i].length-1){
						if(tablero[i][j-1] == 'x')
							minas++;
						if(tablero[i+1][j-1] == 'x')
							minas++;
						if(tablero[i+1][j] == 'x')
							minas++;
					}else{
						if(tablero[i][j-1] == 'x')
							minas++;
						if(tablero[i][j+1] == 'x')
							minas++;
						if(tablero[i+1][j-1] == 'x')
							minas++;
						if(tablero[i+1][j] == 'x')
							minas++;
						if(tablero[i+1][j+1] == 'x')
							minas++;
					}


				}

				//caso 3
				else if(i == tablero.length-1){
					if(j==0){
						if(tablero[i][j+1] == 'x')
						minas++;
						if(tablero[i-1][j] == 'x')
							minas++;
						if(tablero[i-1][j+1] == 'x')
							minas++;
					}else if(j == tablero[i].length-1){
						if(tablero[i][j-1] == 'x')
							minas++;
						if(tablero[i-1][j-1] == 'x')
							minas++;
						if(tablero[i-1][j] == 'x')
							minas++;
					}else{
						if(tablero[i][j-1] == 'x')
							minas++;
						if(tablero[i][j+1] == 'x')
							minas++;
						if(tablero[i-1][j-1] == 'x')
							minas++;
						if(tablero[i-1][j] == 'x')
							minas++;
						if(tablero[i-1][j+1] == 'x')
							minas++;
					}

					
				} 

//--------------------------------------------------------------------------------------------------
				//caso 4
				else if(j == 0){
					if(tablero[i-1][j] == 'x')
						minas++;
					if(tablero[i-1][j+1] == 'x')
						minas++;
					if(tablero[i][j+1] == 'x')
						minas++;
					if(tablero[i+1][j] == 'x')
						minas++;
					if(tablero[i+1][j+1] == 'x')
						minas++;
				}

				//caso 5
				else if(j == tablero[i].length-1 ){
					if(tablero[i-1][j-1] == 'x')
						minas++;

					if(tablero[i-1][j] == 'x')
						minas++;

					if(tablero[i+1][j] == 'x')
						minas++;
	
					if(tablero[i][j-1] == 'x')
						minas++;

					if(tablero[i+1][j-1] == 'x')
						minas++;
				}

				//Descomenta la siguiente linea de codigo y cambia lo que se pide
				tablero[i][j] = (minas >0) ? Character.forDigit(minas,10) : 0;
				//Asignamos 0 en el else para mantener la igualdad del valor por defecto
			}
		}
	}

	public void tirar(int x, int y){
		//Los indices que llegan hasta aqui debieron ser verificados de cumplir con los indices validos
		//Si la posicion tiene una bomba, entonces pierde, revisa si la variable global "perdio" te es util

		if (tablero[x][y] == 'x'){
			perdio = true;
			tablero[x][y] = 'x';
		}else {
			if(tableroJugado[x][y] != 'x'){
			tableroJugado[x][y] = 'o';
			tablero[x][y] = 'o';


			}

			
		}
		

		/** Sea la casilla col= 2, fila= 2 la escogida por le usuario (asignada con p de principal) y descubre= 2 */

		/* Decubre 2 hacia abajo
		** |  |  |  |
		** |  |  |p |
		** |  |  |o |
		** |  |  |o |
		** |  |  |  |
		*/
		for(int i = x+1; i <= x+this.descubre && i < tablero.length; i++){
			if(tablero[i][y] == 'x')
				break;
			tableroJugado[i][y] = 'o';
		}


		/* Decubre 2 hacia arriba
		** |  |  |o |
		** |  |  |p |
		** |  |  |  |
		** |  |  |  |
		** |  |  |  |
		*/
		for(int i = x-1; i >=  x-this.descubre && i > 0; i--){
			if(tablero[i][y] == 'x')
				break;
			tableroJugado[i][y] = 'o';
		}

		/* Decubre 2 hacia izquieda 
		** |  |  |  |
		** |o |o |p |
		** |  |  |  |
		** |  |  |  |
		** |  |  |  |
		*/
		for(int i = y-1; i >= y-this.descubre && i >= 0; i--){
			if(tablero[x][i] == 'x')
				break;
			tableroJugado[x][i] = 'o';
		}


		/* Decubre 2 hacia derecha 
		** |  |  |  |
		** |p |o |o |
		** |  |  |  |
		** |  |  |  |
		** |  |  |  |
		*/
		for(int i = y+1; i< y+this.descubre && i < tablero.length; i++){
			if(tablero[x][i] == 'x')
				break;
			tableroJugado[x][i] = 'o';
		}		
	}

	public String imprimir(){ 
		//Metodo ya completo
		String tableroCadena ="";
		for(int i = 0; i < this.tablero.length; i++){
			tableroCadena += "|";
			for(int j = 0; j < this.tablero[i].length; j++){
				if(this.tableroJugado[i][j] == 'o'){
					tableroCadena += (this.tablero[i][j] != 0) ? " " + this.tablero[i][j] +" |" : " - |";
				}else
					tableroCadena += "   |";		
			}
			tableroCadena += "\n";
		}
		return tableroCadena;
	}
	
	
	//Con este metodo pordemos ver el tablero que contiene las bombas y el numero de bombas oculto al usuario
	public String imprimirBack(){
		String tableroCadena ="";
		for(int i = 0; i < this.tablero.length; i++){
			tableroCadena += "|";
			for(int j = 0; j < this.tablero[i].length; j++){
				tableroCadena += (this.tablero[i][j] != 0)? " " + this.tablero[i][j] +" |": "   |";
			}
			tableroCadena += "\n";
		}
		return tableroCadena;
	}
	

	public boolean terminaElJuego(){
		if(perdio){
			System.out.println("Perdio");
		}else{
			boolean lleno = false;

			for(int c=0; c<this.tablero.length; c++){
				for(int f =0; f<this.tablero[c].length; f++){
					//System.out.println("T: " +tablero[c][f] + ",c:  "+ c + ",f: " +f+ ",TJ: "+ this.tableroJugado[c][f]);
					if(this.tableroJugado [c][f] == 0 ){
						if (tablero[c][f] == 'x'){ 
						lleno = true;
									//System.out.println("entra if");
						}else{
							//System.out.println("ENTRA ELSE");
							lleno =false;
							return false;
						}								
					} 
				}


			}
				if(lleno){	
			System.out.println("Ganaste");
			return true;
			}	

		}

	

		//Si el usuario perdio, regresamos true e imprimimos "Perdio"
		/*Si no, revisamos que todo el tablero "tableroJugado" este lleno, recuerda que no se estan llenando las casillas
		**donde originalmente estan las bombas, por lo que esto implica contemplar ese caso. Si el tablero esta lleno
		**(con la exepcion anterior), entonces el usuario gana
		*/
		return perdio;
	}

	

	public static void main (String [] args){
		Scanner s = new Scanner(System.in);
		int x, y;

		System.out.println("***** BUSCAMINAS *****\n");
		System.out.println("Por favor seleccione el nivel / dificultad a jugar: \n"+
							"\n  1 -Principiante (8 x 8 casillas y 16 minas)"
							+"\n  2 -Intermedio (16 x 16 casillas y 40 minas)"
							+"\n  3 -Experto (16 x 30 casillas y 99 minas)"
							+"\n  4 -Personalizado (número de casillas y minas a escoger)");

							System.out.print("\n  Opción: ");


		/* Código que le dice al usuario que ingrese un número válido en caso de haber ingresado un caracer. */
		while(!s.hasNextInt()){	
			System.out.println("\nOOOOOOOOOps...【 ͠⊙ 𝆒 ͡ ⊙ 】 Opción Inválida (Prueba de nuevo)");
			s.next();
			System.out.print("Opción: ");
		}
		int usuario = s.nextInt();

		if(usuario>4 || usuario<1 ){
			while(usuario>4 || usuario<1 ){
				System.out.println("\nIngresa un número que sea parte del menú \n\nVamos, tú puedes !! (っ＾▿＾っ) ");	
				System.out.print("Opción: ");
				while(!s.hasNextInt()){	
					System.out.println("\n (ノ ͠⊙ 𝆒 ͡ ⊙)ノ Bro !! Eso ni si quiera juega ");	
					System.out.print("Opción: ");
					s.next();
				}
				usuario = s.nextInt();
			}

		}


		switch(usuario){
				case 1:
					System.out.println("\nHas escogido \"NIVEL 1\" ");
					BuscaMinas b1 = new BuscaMinas(usuario);
					System.out.println(b1.imprimir());
					
					do{
						
						System.out.println("\nIngrese columna -> 0-"+(b1.tablero[0].length-1));	


								while(!s.hasNextInt()){	
									System.out.println("\nJOVEN, ESO NO SE PUEDE ( ╥ ﹏ ╥ )");
									s.next();
									System.out.print("Columna: ");
								}
						y = s.nextInt();

						//if(y<0 || y>(b1.tablero[0].length-1) ){
							while(y<0 || y>(b1.tablero[0].length-1)){
								System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");	
								System.out.print("Columna: ");
									while(!s.hasNextInt()){	
										System.out.println("\n VAMOS !! (Escoge solo un numero que este dentro del rango) ≧ ◉ ◡ ◉ ≦ ");	
										System.out.print("Columna: ");
										s.next();
									}
								y = s.nextInt();
							

						}
					



						if(y>=0 && y<8 ){
							System.out.println("\nIngrese fila -> 0-"+(b1.tablero.length-1));
							
									while(!s.hasNextInt()){	
										System.out.println("\nJOVEN ESO NO SE PUEDE :c ");
										s.next();
										System.out.print("Fila: ");
									}
							x = s.nextInt();

	
							if(x<0 || x>(b1.tablero[0].length-1) ){
								while(x<0 || x>(b1.tablero[0].length-1) ){
									System.out.println("\nLA OPCIÓN SELECCIONADA NO ES VÁLIDA. (Prueba de nuevo) ツ");	
									System.out.print("Fila: ");
										while(!s.hasNextInt()){	
											System.out.println("\n (ノ ͠⊙ 𝆒 ͡ ⊙)ノ BRO !! Eso ni si quiera juega ( ͡ ❛ ⏥ ͡ ❛)");	
											System.out.print("Fila: ");
											s.next();
										}
									x = s.nextInt();
								}
	
							}
							if(x>=0 && x<8){
								b1.tirar(x,y);
								System.out.println(b1.imprimir());
								//System.out.println(b1.imprimirBack());
							}

						}

						
					}while(!b1.terminaElJuego());		
			    break;
				

				//------------------------------------------

				
				case 2:
					System.out.println("\nHas escogido \"NIVEL 2\" ");
					BuscaMinas b2 = new BuscaMinas(usuario);
					System.out.println(b2.imprimir());
					


					do{
						//System.out.println(b.imprimirBack());
						System.out.println("\nIngrese columna -> 0-"+(b2.tablero[0].length-1));	


								while(!s.hasNextInt()){	
									System.out.println("\nJOVEN, ESO NO SE PUEDE ( ╥ ﹏ ╥ )");
									s.next();
									System.out.print("Columna: ");
								}
						y = s.nextInt();

						//if(y<0 || y>(b1.tablero[0].length-1) ){
							while(y<0 || y>(b2.tablero[0].length-1)){
								System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");	
								System.out.print("Columna: ");
									while(!s.hasNextInt()){	
										System.out.println("\n VAMOS !! (Escoge solo un numero que este dentro del rango) ≧ ◉ ◡ ◉ ≦ ");	
										System.out.print("Columna: ");
										s.next();
									}
								y = s.nextInt();
							//}

						}
					



						if(y>=0 && y< 16){
							System.out.println("\nIngrese fila -> 0-"+(b2.tablero.length-1));
							
									while(!s.hasNextInt()){	
										System.out.println("\n JOVEN ESO NO SE PUEDE :c ");
										s.next();
										System.out.print("Fila: ");
									}
							x = s.nextInt();

	
							if(x<0 || x>(b2.tablero[0].length-1) ){
								while(x<0 || x>(b2.tablero[0].length-1) ){
									System.out.println("\nLA OPCIÓN SELECCIONADA NO ES VÁLIDA. (Prueba de nuevo) ツ");	
									System.out.print("Fila: ");
										while(!s.hasNextInt()){	
											System.out.println("\n (ノ ͠⊙ 𝆒 ͡ ⊙)ノ BRO !! Eso ni si quiera juega ( ͡ ❛ ⏥ ͡ ❛)");	
											System.out.print("Fila: ");
											s.next();
										}
									x = s.nextInt();
								}
	
							}
							if(x>=0 && x<16){
								b2.tirar(x,y);
								System.out.println(b2.imprimir());
								//System.out.println(b2.imprimirBack());
							}

						}

						
					}while(!b2.terminaElJuego());		
			    break;
				


				//-----------------------------------------
				case 3:
					System.out.println("\nHas escogido \"NIVEL 3\" ");
					BuscaMinas b3 = new BuscaMinas(usuario);
					System.out.println(b3.imprimir());
					


					do{
						//System.out.println(b.imprimirBack());
						System.out.println("\nIngrese columna -> 0-"+(b3.tablero[0].length-1));	


								while(!s.hasNextInt()){	
									System.out.println("\nJOVEN, ESO NO SE PUEDE ( ╥ ﹏ ╥ )");
									s.next();
									System.out.print("Columna: ");
								}
						y = s.nextInt();

						//if(y<0 || y>(b1.tablero[0].length-1) ){
							while(y<0 || y>(b3.tablero[0].length-1)){
								System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");	
								System.out.print("Columna: ");
									while(!s.hasNextInt()){	
										System.out.println("\n VAMOS !! (Escoge solo un numero que este dentro del rango) ≧ ◉ ◡ ◉ ≦ ");	
										System.out.print("Columna: ");
										s.next();
									}
								y = s.nextInt();
							//}

						}
					



						if(y>=0 && y< 30){
							System.out.println("\nIngrese fila -> 0-"+(b3.tablero.length-1));
							
									while(!s.hasNextInt()){	
										System.out.println("\n JOVEN ESO NO SE PUEDE :c ");
										s.next();
										System.out.print("Fila: ");
									}
							x = s.nextInt();


							if(x<0 || x>(b3.tablero.length-1) ){
								while(x<0 || x>(b3.tablero.length-1) ){
									System.out.println("\nLA OPCIÓN SELECCIONADA NO ES VÁLIDA. (Prueba de nuevo) ツ");	
									System.out.print("Fila: ");
										while(!s.hasNextInt()){	
											System.out.println("\n (ノ ͠⊙ 𝆒 ͡ ⊙)ノ BRO !! Eso ni si quiera juega ( ͡ ❛ ⏥ ͡ ❛)");	
											System.out.print("Fila: ");
											s.next();
										}
									x = s.nextInt();
								}
	
							}
							if(x>=0 && x<16 && y>=0 && y<30 ){
								b3.tirar(x,y);
								System.out.println(b3.imprimir());
								//System.out.println(b3.imprimirBack());
							}

						}

						
					}while(!b3.terminaElJuego());		
			    break;
				//---------------------
			    case 4:
					System.out.println("\nHas escogido \"NIVEL 4\"  Porfavor, personaliza tú cuadricula ");
					BuscaMinas b4 = new BuscaMinas(usuario);
					System.out.println(b4.imprimir());
					


					do{
						//System.out.println(b.imprimirBack());
						System.out.println("\nIngrese columna -> 0-"+(b4.tablero[0].length-1));	


								while(!s.hasNextInt()){	
									System.out.println("\nJOVEN, ESO NO SE PUEDE ( ╥ ﹏ ╥ )");
									s.next();
									System.out.print("Columna: ");
								}
						y = s.nextInt();

						//if(y<0 || y>(b1.tablero[0].length-1) ){
							while(y<0 || y>(b4.tablero[0].length-1)){
								System.out.println("\nJOVEN, ESO NO SE PUEDE ʕ •́ ᴥ •̀ ʔっ");	
								System.out.print("Columna: ");
									while(!s.hasNextInt()){	
										System.out.println("\n VAMOS !! (Escoge solo un numero que este dentro del rango) ≧ ◉ ◡ ◉ ≦ ");	
										System.out.print("Columna: ");
										s.next();
									}
								y = s.nextInt();
							//}

						}
					



						if(y>=0 && y<(b4.tablero[0].length-1)){
							System.out.println("\nIngrese fila -> 0-"+(b4.tablero.length-1));
							
									while(!s.hasNextInt()){	
										System.out.println("\n JOVEN ESO NO SE PUEDE :c ");
										s.next();
										System.out.print("Fila: ");
									}
							x = s.nextInt();


							if(x<0 || x>(b4.tablero.length-1) ){
								while(x<0 || x>(b4.tablero.length-1) ){
									System.out.println("\nLA OPCIÓN SELECCIONADA NO ES VÁLIDA. (Prueba de nuevo) ツ");	
									System.out.print("Fila: ");
										while(!s.hasNextInt()){	
											System.out.println("\n (ノ ͠⊙ 𝆒 ͡ ⊙)ノ BRO !! Eso ni si quiera juega ( ͡ ❛ ⏥ ͡ ❛)");	
											System.out.print("Fila: ");
											s.next();
										}
									x = s.nextInt();
								}
	
							}
								b4.tirar(x,y);
								System.out.println(b4.imprimir());
								//System.out.println(b4.imprimirBack());
							

						}

						
					}while(!b4.terminaElJuego());		
			    break;

				//----------------------
	
				
	
				/**case 4:
				System.out.println("Has escogido \"Nivel 4\"");
				System.out.println(b4.imprimir());
					do{
						//System.out.println(b.imprimirBack());
						System.out.println("Ingrese columna -> 0-"+(b4.tablero[0].length-1));	
						y= s.nextInt();
						System.out.println("Ingrese fila -> 0-"+(b4.tablero.length-1));
						x= s.nextInt();
						b4.tirar(x,y);
						System.out.println(b4.imprimir());
					}while(!b4.terminaElJuego());
				break;*/
					
		}
		


		/**
		//pedimos que el usuario ingrese el nivel de dificultad posible.
		int dificultad = 1; //el valor ingresado
		BuscaMinas b = new BuscaMinas(dificultad);
		System.out.println(b.imprimir());
		System.out.println(b.imprimirBack());

		

		int x, y;
		do{
			//System.out.println(b.imprimirBack());
			System.out.println("Ingrese columna -> 0-"+(b.tablero[0].length-1));	
			y= s.nextInt();
			System.out.println("Ingrese fila -> 0-"+(b.tablero.length-1));
			x= s.nextInt();
			b.tirar(x,y);
			System.out.println(b.imprimir());
		}while(!b.terminaElJuego());
		*/



	}



}





