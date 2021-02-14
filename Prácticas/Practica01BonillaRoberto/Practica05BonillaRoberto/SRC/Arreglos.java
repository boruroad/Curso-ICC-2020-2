/**
 * Práctica 5 ARREGLOS
 * Número de Cuenta 31721903-8
 * @author Bonilla Ruiz Roberto Adrián.
 * @version 1.0 Mayo 2020.
 */


/** Creamos nuestra clase Arreglos, la cual va a implemnetar la interfaz InterfazArreglos */
public class Arreglos implements InterfazArreglos{

/**Colocar los override hasta el final**/
//-----------------------------------------
					//ACTIVIDAD 1
@Override
public int[][] espejo(int[][] arreglo){
	int [][] a1 = new int [arreglo.length][arreglo[0].length];

	for (int i=0;i<arreglo.length;i++){
		
		for (int j=arreglo[i].length-1, k=0; k<arreglo[i].length;j--,k++){
				a1[i][k]=arreglo[i][j];
		}	
	}
	return a1;
}
//-----------------------------------------
					//ACTIVIDAD 2

	//Método auxiliar para el gato
	private static int verificaP(char [][] tablero,char c){
		//Verificar renglones 
		int contador=0;
		for(int i =0; i<tablero.length;i++){
			if(tablero[i][0]== c &&
				tablero[i][1] ==c &&
				tablero[i][2] ==c){
				contador ++;
			} 
		}
		//Verificar columnas 
		for(int i =0; i<tablero.length;i++){
			if(tablero[0][i]==c &&
				tablero[1][i] == c &&
				tablero[2][i]== c){
				contador ++;
			} 
		}

		//Verificar diagonales derechas
		if(tablero[0][0] == c &&
			tablero[1][1] == c &&
			tablero[2][2] == c){
			contador ++ ;
		}

		//Verificar diagonales izquierdas
		if(tablero[0][2] == c &&
			tablero[1][1] == c &&
			tablero[2][0] == c){
			contador ++ ;
		}

	  return contador;
	}

	/** Método gato*/
	@Override
	public char gato(char[][] tablero){
		int contadorX= verificaP(tablero,'X');
		int contadorO= verificaP(tablero,'O');
		char a=' ';
		if(contadorX<contadorO){
			a='O';
		}

		if(contadorO<contadorX){
			a='X';
		}

		if(contadorX==0 && contadorO==0){
			a='N';
		}

		if(contadorO==contadorX && contadorO!=0){
			a='E';
		}
		return a;
	}

	//Método que imprime el gato
	/**
	 * Método que muestra los elementos para el método "construyeFrase" 
	 * @param arreglo el arreglo a mostrar
	 */
	public static void has(char [][] arreglo){
		for(int i=0;i<arreglo.length;i++){
			if(i!=0){
				System.out.println(" ");
			}
			for(int j=0; j<arreglo[i].length;j++){
				System.out.print(arreglo[i][j]+" ");
			}	
		}
		System.out.println();
	}  
//-----------------------------------------
					//ACTIVIDAD 3
	
	/** Método construyeFrase*/
	@Override
	public  String construyeFrase(char[][] frase){
		String oracion = "";
		 for (int i=0;i<frase.length; i++) {
			oracion +="\n"+frase[i]; 
		}
		return oracion;
	}

	/**
	 * Método que muestra los elementos para el método "construyeFrase" 
	 * @param arreglo el arreglo a mostrar
	 */
	public static void ensenia(char [][] arreglo){
		for(int i=0;i<arreglo.length;i++){
			if(i!=0){
				System.out.print(" ");
			}
			for(int j=0; j<arreglo[i].length;j++){
				System.out.print(arreglo[i][j]);
			}
		
		}
		System.out.println();
	} 
//---------------------------------------
					//ACTIVIDAD 4
 @Override
 public int[][] separaNumeros(int[] numeros){
        int[][] arreglo = new int [2][numeros.length+1];
        int contadorpar=0;
        int contadorImpar=0;
        for (int i = 0; i<(numeros.length);i++){

            if((numeros[i]%2) == 0){
                arreglo[0][contadorpar+1] = numeros[i];
                contadorpar++;
            
            }else{
                arreglo[1][contadorImpar+1] =numeros[i];
                contadorImpar++;
                
            }
        }
            arreglo[0][0]=contadorpar;
            arreglo[1][0]=contadorImpar;


       return arreglo;
    }

	/**
	 * Muestra los elementos de un arreglo bidimensional
	 * @param arreglo el arreglo a mostrar
	 */
	public static void ensenia(int [][] arreglo){
		for(int i=0;i<arreglo.length;i++){
			for(int j=1; j<=arreglo[i][0];j++)
		System.out.print(arreglo[i][j]+"  ");
		System.out.println();
		}
	} 

     /**
	 * Muestra los elementos de un arreglo bidimensional
	 * @param arreglo el arreglo a mostrar
	 */
	public static void dame(int [] arreglo){
		for(int i=0;i<arreglo.length;i++){
		System.out.print(arreglo[i]+" ");
		}
	    System.out.println();
	} 
//---------------------------------------
					//ACTIVIDAD 5

	/**Método masRepetido que encuentra el número más repetido
	en un arreglo.*/
	
	public static int auxVeces(int n,int [] arreglo){
        int veces = 0;
        for (int i=0;i<arreglo.length;i++){
            if(n==arreglo[i])
            veces++;    
        }
        return veces;
    }

    /**Aqui devolvemos el digito que efectivmente tiene mas repeticiones
    es por ello que ocupamos del método auxVeces*/
 	@Override
    public  int masRepetido(int[] numeros){
       int mayor = numeros[0];
       for (int i=0;i<numeros.length;i++){
           if(auxVeces(mayor,numeros)<auxVeces(numeros[i],numeros))
            mayor=numeros[i];
       }    
       return mayor;
   }
//---------------------------------------
					//ACTIVIDAD 6

   //Método auxiliar 
   private static boolean dentro(int n , int [] arreglo){
	for (int i =0;i<arreglo.length;i++){
		if(n==arreglo[i])
			return true;
	}
	return false;

}
	//Método está contenido 
	@Override
    public  boolean estaContenido(int[] contenido, int[] contenedor){
    	boolean f = true;
    	for (int i=0;i<contenido.length;i++){
    		for (int j=0;j<contenedor.length;j++){
    			if(dentro(contenido[i],contenedor) != true)
    				f=false; 			
    		}
    	}
    	return f;
    }
//---------------------------------------
					//ACTIVIDAD 7

	/**método pascal que construye tantos niveles del triángulo de
	Pascal como se soliciten.*/
	@Override
	public int[][] pascal(int n){
		if(n<=0)
		return null;

		int [][] arreglo = new int [n][];
		for(int i=0;i<n;i++){

			int [] nivel = new int [i+1];
			arreglo[i]=nivel;
			
			if(i==0){
				arreglo[i][0]=1;
				continue;
			}

			arreglo[i][0]=1;
			arreglo[i][nivel.length-1]=1;
			for(int j=1; j<nivel.length-1;j++){
				arreglo[i][j] =arreglo[i-1][j-1]+arreglo[i-1][j];
			}
		}
		return arreglo;
	}

	/**
	 * Muestra los elementos de un arreglo bidimensional
	 * @param arreglo el arreglo a mostrar
	 */
	public static void muestra(int [][] arreglo){
		for(int i=0;i<arreglo.length;i++){
			for(int j=0; j<arreglo[i].length;j++){
				
				if(arreglo[i][j]<=9){
					System.out.print(arreglo[i][j]+" ");
					System.out.print("  ");
				}
				if(arreglo[i][j]>=10){ 
					System.out.print(arreglo[i][j]+"  ");
				}	
			}
			System.out.println();
		}
	} 
//---------------------------------------
				//ACTIVIDAD 8
	/** Colapsa permite eliminar los elementos repetidos de un arreglo.*/
	@Override
	public  int[] colapsa(int[] arreglo){
	        int mayor = arreglo[0];
	       for (int i=0;i<arreglo.length;i++){
	            if(mayor<arreglo[i]){
	                mayor=arreglo[i];
	            }
	       }   
	      //int a = auxVeces(masRepetido(arreglo),arreglo)+1;
	      //System.out.println(mayor);
	
	       int [] arregloAuxiliar = new int [mayor+1];
	       int j=0;
	       while (j<arreglo.length){
	            int r= arreglo[j];
	            arregloAuxiliar[r]=arregloAuxiliar[r]+1;
	            j++;
	       }
	
	       int contador = 0;
	       int k=0;
	       while(k<arregloAuxiliar.length){
	            if(arregloAuxiliar[k] !=0){
	                contador++;
	            }
	            k++;
	       }
	
	       int [] devuleve = new int [contador];
	       int indice =0;
	       for (int l=0;l<arregloAuxiliar.length;l++){
	           if(arregloAuxiliar[l] !=0){
	            devuleve[indice]=l;
	            indice++;
	           }
	       }
	       return devuleve;
	
	    }
//---------------------------------------
		/** Método main */
	public static void main(String[] args) {
		Arreglos a1 = new Arreglos();

		System.out.println("\tPRÁCTICA 5 ARREGLOS \n\tBonilla Ruiz Roberto Adrián ");

		System.out.println("\n\n\t*** Método espejo *** \n(Ejemplo 1) \n-Recibe un arreglo de enteros");
		int [][] t1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		muestra(t1);
		System.out.println("\nDevolvemos:");
		muestra(a1.espejo(t1));
		System.out.println("..........................");
		System.out.println("(Ejemplo 2)");
		int [][] t2 = {{1,2,3},{5,6,7}};
		muestra(t2);
		System.out.println("\nDevolvemos:");
		muestra(a1.espejo(t2));
		System.out.println("..........................");
		System.out.println("(Ejemplo 3)");
		int [][] t3 = {{1,2},{5,6},{6,8}};
		muestra(t3);
		System.out.println("\nDevolvemos:");
		muestra(a1.espejo(t3));
		System.out.println("..........................");


		System.out.println("\n\n\n\n\t*** Método gato *** \n(Ejemplo 1) \n-Recibe un arreglo de caracteres\n");
		char [][] tablero = {{'-','-','-'},
 							 {'X','O','X'},
							 {'-','X','O'}};
		has(tablero);
		System.out.println("\nDevolvemos: \'"+a1.gato(tablero)+"\'");
        System.out.println(".................................");
        System.out.println("(Ejemplo 2)\n");
		char [][] tablero1 = {{'X','-','O'},
 							  {'X','-','O'},
							  {'X','-','O'}};
		has(tablero1);
		System.out.println("\nDevolvemos: \'"+a1.gato(tablero1)+"\'");
        System.out.println(".................................");
		System.out.println("(Ejemplo 3)\n");
		char [][] tablero2 = {{'X','-','-'},
 							  {'X','O','O'},
							  {'X','-','O'}};
		has(tablero2);
		System.out.println("\nDevolvemos: \'"+a1.gato(tablero2)+"\'");
        System.out.println("................................."); 
		System.out.println("(Ejemplo 4)\n");
		char [][] tablero3 = {{'O','-','X'},
 							  {'X','O','O'},
							  {'X','-','O'}};
		has(tablero3);
		System.out.println("\nDevolvemos: \'"+a1.gato(tablero3)+"\'");
        System.out.println(".................................");       
	
		
		char [][] test1 = {{'h','o','l','a'},{'m','u','n','d','o'},{'l','o','c','o'}};
		a1.construyeFrase(test1);
		char [][] test2 = { {'e','s','t','a'},{'e','s'},{'u','n','a'},{'f','r','a','s','e'},{'c','o','n'},{'c','a','r','a','c','t','e','r','e','s'}};
		a1.construyeFrase(test2);
		System.out.println("\n\n\n\n\t*** Método construyeFrase *** \n(Ejemplo 1) \n-Recibe un arreglo de caracteres como el siguiente: \n");
		System.out.println("h o l a \nm u n d o \nl o c o \n\nDevolvemos la cadena: ");
		ensenia(test1);
		System.out.println(".................................");

		System.out.println("(Ejemplo 2)\n");
		System.out.println("e s t a \ne s \nu n a \nf r a s e \nc o n \nc a r a c t e r e s");
		System.out.println("\nDevolvemos la cadena: ");
		ensenia(test2);
		System.out.println(".................................");


		System.out.println("\n\n\n\n\t*** Método separaNumeros *** \n(Ejemplo 1) \n-Recibe un arreglo de enteros como el siguiente: \n");
		int [] prueba1 = {1,2,3,4,5,6,7};
 		System.out.println("Mostramos la entrada: ");
 		dame(prueba1);
 		System.out.println("\nEsta es la salida:");
 		ensenia(a1.separaNumeros(prueba1));
 		System.out.println("·····························");
		System.out.println("(Ejemplo 2)");
		int [] prueba2 = {5,5,2,4,5,8,12};
 		System.out.println("Mostramos la entrada: ");
 		dame(prueba2);
 		System.out.println("\nEsta es la salida:");
 		ensenia(a1.separaNumeros(prueba2));
 		System.out.println("·····························");
 		System.out.println("(Ejemplo 3)");
		int [] prueba3 = {30,8,2,4};
 		System.out.println("Mostramos la entrada: ");
 		dame(prueba3);
 		System.out.println("\nEsta es la salida:");
 		ensenia(a1.separaNumeros(prueba3));
 		System.out.println("·····························");




 		System.out.println("\n\n\n\n\t*** Método masRepetido *** \n(Ejemplo 1) \n-Recibe un arreglo de enteros: ");
 		int [] p1 = {3,3,10,13,24,3};
        dame(p1);
        System.out.print("\nEl numero más repetido es: ");
        System.out.println(a1.masRepetido(p1));
        System.out.println(".................................");


        System.out.println("(Ejemplo 2)");
 		int [] p2 = {1,2,3,4,5,6};
        dame(p2);
        System.out.print("\nEl numero más repetido es: ");
        System.out.println(a1.masRepetido(p2));        
        System.out.println(".................................");


        System.out.print(a1.masRepetido(p2));
        System.out.println("(Ejemplo 3)");
 		int [] p3 = {2,2,4,4};
        dame(p3);
        System.out.print("\nEl numero más repetido es: ");
        System.out.println(a1.masRepetido(p3));
        System.out.println(".................................");



 		System.out.println("\n\n\n\n\t*** Método estaContenido *** \n(Ejemplo 1) \n-Recibe un arreglo de enteros: ");
        int[] d1= {2,7,11,3,5};
		int [] d2 = {5,5,2,4,5,8,12};
		dame(d1);

		System.out.println("\nComparamos si esta contenido dentro de este otro: ");
		dame(d2);
		System.out.println("\nDevolvemos: "+a1.estaContenido(d1,d2));
        System.out.println(".................................");
        System.out.println("(Ejemplo 2)");
		int[] d3= {2,7,5};
		int [] d4 = {7,5,2,4,5};
		dame(d3);
		System.out.println("\nComparamos si esta contenido dentro de este otro: ");
        dame(d4);
		System.out.println("\nDevolvemos: "+a1.estaContenido(d3,d4));
        System.out.println(".................................");
        System.out.println("(Ejemplo 3)");
        int[] d5= {2,7,12,8};
		int [] d6 = {7,5,2,};
		dame(d5);
		System.out.println("\nComparamos si esta contenido dentro de este otro: ");
        dame(d6);
		System.out.println("\nDevolvemos: "+a1.estaContenido(d5,d6));
        System.out.println(".................................");
        System.out.println("(Ejemplo 4)");
   		int[] d7= {2,7,7,7};
		int [] d8 = {7,5,2,};
		dame(d7);
		System.out.println("\nComparamos si esta contenido dentro de este otro: ");
        dame(d8);
		System.out.println("\nDevolvemos: "+a1.estaContenido(d7,d8));
        System.out.println(".................................");



		System.out.println("\n\n\n\n\t*** Método pascal *** \n(Ejemplo 1) \n-Recibe un número: pascal(4) \nDevolvemos:\n");
		muestra(a1.pascal(4));
		System.out.println(".................................");

		System.out.println("(Ejemplo 2) \n-Recibe un número: pascal(5) \nDevolvemos:\n");
		muestra(a1.pascal(5));
		System.out.println(".................................");

		System.out.println("(Ejemplo 3) \n-Recibe un número: pascal(10) \nDevolvemos:\n");
		muestra(a1.pascal(10));
		System.out.println(".................................");



		System.out.println("\n\n\n\n\t*** Método colapsa *** \n(Ejemplo 1) \n-Recibe un arreglo de enteros: ");
       	int []s1 = {2,2,3,3,5};
        dame(s1);
        System.out.println("\nDevolvemos ");
        dame(a1.colapsa(s1));
		System.out.println(".................................");

		System.out.println("\n(Ejemplo 2) \n-Recibe un arreglo de enteros: ");
        int []s2 = {2,1,3,2,5};
 		dame(s2);
        System.out.println("\nDevolvemos ");
        dame(a1.colapsa(s2));
		System.out.println(".................................");
		
		System.out.println("\n(Ejemplo 3) \n-Recibe un arreglo de enteros: ");
        int []s3 = {2,1,2,2,5,1,2,3,2,5,1};
        dame(s3);
        System.out.println("\nDevolvemos ");
        dame(a1.colapsa(s3));
		System.out.println(".................................");


	}



	
}