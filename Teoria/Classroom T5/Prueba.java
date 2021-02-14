public class Prueba{
	public static void main(String[] args) {
		
	char [] arregloCaracteres = new char [1];
	/** Es error de sintaxis */
	//boolean r = arregloCaracteres [0] == ";

	/** Este devuelve error*/
	//boolean r = arregloCaracteres [0] == null;

	/** Este devuelve error*/
	//boolean r = arregloCaracteres [0] == "";

	/** Este es el correcto*/
	boolean r = arregloCaracteres [0] == 0;

	/** Este devuelve false*/
	//boolean r = arregloCaracteres [0] == ' ';

	System.out.println(r);

	arregloCaracteres [0] = 'a';
	System.out.println(arregloCaracteres [0]);
	//devuelve a

	/*Si el indice lo cambiamos por -1, devueve una excepción */


	//Si usamos "maxIndex"
//	int maxIndex = arregloCaracteres.length;
//	System.out.println(arregloCaracteres [maxIndex]);

	//(Devuelve una excepción de nuevo) porque el indice comienza en cero y la longitud en 1, java marca error porque como el 
	//indice maximo es asignado como la longitud del arreglo el cual comienza en uno, pero  el indice máximo en realidad es 0.
	//(1 no es igual a cero)

	/** ¿Qué valor nos regresarı́a  el siguiente código?*/
	
	  int  minas = 4;
      char minasC = Character.forDigit (minas, 10);
      int  minas2 = 11;
      char minasC2 = Character.forDigit (minas2, 10);
      System.out.println(minasC); //Devuelve 4 en tipo primitivo "char"
      System.out.println(minas2); //Devuelve 11 en tipo primitivo "char"



	}


}