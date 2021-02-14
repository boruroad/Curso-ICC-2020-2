public class Recursivo{

	public static int factorial(int n){
		if(n == 0 || n==1)
			return 1;
		int valor= n*factorial(n-1);
		System.out.println(valor);
		return valor;
	}

	/**
	* @param cadena la cadena donde buscar el carcter
	* @param c  el cracter a buscar la posicion
	*/
	public static int encuentraPosicion(String cadena, char c){
	/** Caso base cadena vacía devolvemos 0
	 ó cuando cadena.length() sea = 1 devolvemos
	*/ 
	 return encuentraPosicion(cadena,c,0);
	}

	/**Tenemos un metodo auxiliar el cual añada un contador para que empiece desde la 
	posicion es cero y vaya moviendose hasta encontrar el Caracter
	Ver imagen EjemploRecursion1.jpg*/
	private static int encuentraPosicion(String cadena, char c, int posicion){
		if(cadena.length()==0){
			return -1;
		}
		if(cadena.charAt(0)==c){
			return posicion;
		}

		/**VUelve a llamar al método*/	
		return encuentraPosicion(cadena.substring(1), c, ++posicion);
	}


	public static boolean esIgual(String cadena1, String cadena2){
		/**Casos base:
		1)Con cadenas vacias, devolvemos true
		2)Cuando el primer caracter de ambas cadenas no es el mismo devolvemos false
		3)Cuando una sea vacia y la otra no 
		*/

		//Con este caso te ahorras la recursion :))
		if(cadena1.length()!=cadena2.length()){
			return false;
		}		

		if(cadena1.length()==0 && cadena1.length()==0 ){
			return true;
		}

		if(cadena1.length()==0|| cadena2.length() == 0){
			return false;
		}

		if(cadena1.charAt(0)!=cadena2.charAt(0)){
			return false;
		}
		return esIgual(cadena1.substring(1), cadena1.substring(1));
	}

	public static String crearPalabra(char [] caracteres){
		return crearPalabra(caracteres,0);
	}

	private static String crearPalabra(char [] caracteres, int contador){
		/**Casos base:
		  1) Cuando cel contador sea menor a la longitud del arreglo
		 	 devolvemos cadena vacía.
		*/
		 	 if(contador>=caracteres.length){
				return"";
		 	 }
		 	return caracteres[contador] + crearPalabra(caracteres,++contador); 


	}

	public static void main(String[] args) {
	// Ejemplo 1 y 2 de recursion.jpg
	// System.out.println("Resultado: "+ encuentraPosicion("hola",'p'));	

	//Aqui no hay foto de ejemplo :c 
	//System.out.println("La cadena hola es igual a hola ---> "+ esIgual("hola", "hola"));
	char [] cs = {'h','o','l','a'};//el metodo crear palabra debe devolver "hola"

	//Ejemplo metodo crearPalabra Ver R4 y R5 
	System.out.println("Resultado: "+crearPalabra(cs));
	}
}