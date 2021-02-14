public class TestingArreglos2{
	//Crearemos un método para imprimir arreglos
	public static void imprime(int[] arreglo){
		for(int i=0;i<arreglo.length;i++){
			if(i==arreglo.length-1){
				System.out.print(arreglo[i]);
			}else{
				System.out.print(arreglo[i]+", ");
			}
		}
		System.out.print("\n");
	} 


	public static void imprime(Object[] arreglo){
		for(int i=0;i<arreglo.length;i++){
			if(i==arreglo.length-1){
				System.out.print(arreglo[i]);
			}else{
				System.out.print(arreglo[i]+", ");
			}
		}
		System.out.print("\n");

	}

	//Intercambia dos valores entre arreglos (supongamos que es para el mismo tamaño en arreglos)
	public static void intercambia (int[] arreglo1, int[] arreglo2, int indice1, int indice2){
		int temp = arreglo1[indice1];
		arreglo1[indice1] = arreglo2[indice2];
		arreglo2[indice2] = temp;
	}

	//Intercambia dos valores entre arreglos sin importar el tamaño
	public static void intercambia (int[] arreglo1, int[] arreglo2){
	 	for (int i=0; i<arreglo1.length && i<arreglo2.length; i++){
			intercambia(arreglo1, arreglo2, i, i);
		}
	}




	//Intercambia todos los valores etre arreglos
	/*public static void intercambia(int[] arreglo1, int [] arreglo2){
		for (int i=0; i<arreglo1.length; i++){
			intercambia(arreglo1, arreglo2, i, i);
		}

	}*/


		public static void main(String[] args) {
			int [] enteros = new int [14];
			enteros [4] = 1234;
			//TestingArreglos2.imprime(enteros);

			Integer [] arreglo1 = new Integer[5];
			Double [] arreglo2 = {5.0,2.0,5.0,6.0,8.0};

			System.out.println();
			TestingArreglos2.imprime(arreglo2);

			String [] arreglo3 = {"hola","xD",":D"};
			TestingArreglos2.imprime(arreglo3);	

			TestingArreglos2.imprime(arreglo1);			
			System.out.println("\n\n\n\n\n");


			int [] a1 = new int[10];
			int [] a2 = {5,2,5,6,8,100,200,300};

			System.out.println("Antes del intercambio");
			TestingArreglos2.imprime(a1);
			TestingArreglos2.imprime(a2);

			TestingArreglos2.intercambia(a1,a2);

			System.out.println("\nDespués del intercambio");
			TestingArreglos2.imprime(a1);
			TestingArreglos2.imprime(a2);
			System.out.println("\n");
	
	
		}
}