/**
 * @author Bonilla Ruiz Roberto Adrián
 * @version 1.0 Mayo 2020
 */

 public class ArreglosB{
 	/**
	* Regresa la costrucción de una frase
	* @param palabras es el arreglo de Strings
	* @return la frase construida a partir de las palabras del arreglo 
	*/
	//hacemos estatico el método para no crear elementos de la clase
	public static String crearFrase(String [] palabras){
		String frase = "";
		/** For normal */
		/// for (int i=0;i<palabras.length; i++) {
		//	frase +=palabras[i]+" "; 
		//}
		//return frase;
		
		/** For each **/
		for (String elementos:palabras){
			frase+= elementos+" ";
		}
		return frase;
	}

	/**
	* Crea una pirámide de caracterese
	* @param niveles la cantidad de niveles
	* @param c el caracter a ahacer la piramide
	* @return el arreglo con representación de pirámide 
	*/
	
	public static String [][] crearPiramide(int niveles, String c){
		if(niveles<=0)
		return null;
		

		String [][] piramide = new String [niveles][];
		for(int i=0;i<niveles;i++){

			/**le ponemos +1 a i para que no sea cero en la primera 
			 * primera iteracion
			 */ 
			  String[] nivel= new String[i+1];
			 for (int j =0;j<nivel.length;j++)
			 	nivel[j] = c;
			 	piramide[i] = nivel;	 
		}
		return piramide;
	}


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
					//System.out.print("  ");
				}
				if(arreglo[i][j]>126){
					System.out.print(arreglo[i][j]);
					//System.out.print("  ");	
				}
			}
		System.out.println();
		}
	} 

	/**
	 * Suma los elementos de un arreglo bidimensional
	 * @param arreglo el arreglo de enteros
	 * @return
	 */
	public static int suma(int [][] arreglo){
		if(arreglo == null){
			return 0;
		}
		int sumador=0;
		/**Necesitamos acceder a cada uno de nuestros elementos
		en el arreglo*/
		for (int i=0;i<arreglo.length;i++){
			for (int j = 0;j<arreglo[i].length;j++) {
				sumador+=arreglo[i][j];
			}
		}
		return sumador;
	} 

 public static void main(String[] args) {
 	System.out.println(2%4);
 }

}