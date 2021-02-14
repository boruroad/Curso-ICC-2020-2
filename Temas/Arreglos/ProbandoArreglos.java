public class ProbandoArreglos{

	public static void main(String[] args) {
		double [] reales;
		reales = new double [15];


		double otrosReales [] = {1,4,5,6,30,8,9};
		System.out.println("Imprimimos la logitud del arreglo \"otros reales\"\n"+otrosReales.length);
		System.out.println("Imprime el elemento en el indice de posicion 4\"\n"+otrosReales[4]); //Imprime 30

		int [] probando = {1,2,3,5};
		 //Imprime 1
		System.out.println("Imprime el elemento en el indice de posicion 0\"\n"+probando[0]);

		//Imprime 3
		System.out.println("Imprime el elemento en el indice de posicion 2\"\n"+probando[2]);
		
		//Formas de crear arreglos
		int [] arreglo = {1,2,3,4,5};
		int [] arre;
		arre = new int [20]; 

		//Volviendo al ejemplo de los reales
		System.out.println("Imprimimos el elemento en el índice del arreglo \'reales\'\n"+reales[4]);//Imprime 0.0 porque es su valor por default
		//Para saber la longitud 
		System.out.println("\nPara saber la longitud del arreglo \"reales\" es con reales.length \n"+reales.length);

		//modificando el valor de un elemento en el arreglo "probando" e imprimiendolo:
		System.out.println("\nAntes, el valor de probando[0]  es "+ probando[0]);
		System.out.println("Accediendo y modificando probando[0]= 1990;");
		probando[0]= 1990;

		System.out.println("imprimiendo el nuevo probando[0] es "+probando[0]);

		arre = new int[2]; 

	}
}