public class Avr{

//	public static String [][] crearPiramide(int niveles, String c){
//		if(niveles<=0)
//		return null;
//		
//
//		String [][] piramide = new String [niveles][];
//		for(int i=0;i<niveles;i++){
//
//			/**le ponemos +1 a i para que no sea cero en la primera 
//			 * primera iteracion
//			 */ 
//			  String[] nivel= new String[i+1];
//			 for (int j =0;j<nivel.length;j++)
//			 	nivel[j] = c;
//			 	piramide[i] = nivel;	 
//		}
//		return piramide;
//	}


	/**
	 * El método pascal que construye tantos niveles del triángulo de
	 * Pascal como se soliciten.
	 * @param numero el numero de niveles del triángulo
	 */
	public static int [][] pascal(int numero){
		if(numero<=0)
		return null;

		int [][] arreglo = new int [numero][];
		for(int i=0;i<numero;i++){

			int [] nivel = new int [i+1];
				
			for (int j=0;j<=nivel.length;j++){
				arreglo[i]=nivel;
			
			}
			for(int k=0;k<i;k++){
				if(k==0){  
					arreglo[i][k]=1;
				}else{ 
					System.out.print("");
					arreglo[i][k]=arreglo[i-1][k-1]+arreglo[i-1][k];
					if(arreglo[i][k]==0){
						arreglo[i][k]=1;
					}
				}
						
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
					System.out.print(" "+arreglo[i][j]+" ");
					System.out.print("  ");
				}else{
					System.out.print(" "+arreglo[i][j]+" ");
					System.out.print(" ");


				}

			}
		//System.out.print(arreglo[i][j]+"   ");
		System.out.println();
		}
	} 


	/**
	 * Muestra los elementos de un arreglo bidimensional
	 * @param arreglo el arreglo a mostrar
	 */
	public static void ensenia(char [][] arreglo){
		for(int i=0;i<arreglo.length;i++){
			for(int j=0; j<arreglo[i].length;j++)
		System.out.print(arreglo[i][j]);
		System.out.println();
		}
	} 

	/**
	* Regresa la costrucción de una frase
	* @param palabras es el arreglo de Strings
	* @return la frase construida a partir de las palabras del arreglo 
	*/
	//hacemos estatico el método para no crear elementos de la clase
	public static String crearFrase(char [][] palabras){
		String frase = "";

		/** For normal */
		 for (int i=0;i<palabras.length; i++) {
			frase +=palabras[i]+" \n"; 

		}
		return frase;
	}



	/**
     * Regresa el espejo de una matriz.
     * @param arreglo el arreglo a calcular su espejo.
     * @return Un arreglo con la representación de la
     * matriz espejo del parámetro.
     */
    public static int[][] espejo(int[][] arreglo){
    		int [][]nuevoArreglo = new int [arreglo.length][arreglo.length];
    	for (int i=0;i<arreglo.length;i++){

    		for (int j=arreglo.length;j==0;j++){
    			arreglo[i]= nuevoArreglo[j];	
    		}
    	}
    	return nuevoArreglo;
    }



public static void main(String[] args) {
	//muestra(crearPiramide(3 ,"◢ ◤ "));

	muestra(pascal(10));

	//char [][] test = {{'h','o','l','a'},{'m','u','n','d','o'},{'l','o','c','o'}};
	//crearFrase(test);
	//ensenia(test);
 	

 //	int [][] t3 = {{1,2,3},{5,6,7}};
 //	muestra(espejo(t3));




 }
		
}