/**
 *Practica1 del curso de ICC. 
 * @author Bonilla Ruiz Roberto Adrián
 * @version 1.0
 */

public class Practica1{
	public static void main(String[] args) {

					// (Actividad 1) Declaracion de variables

		/* Es un tipo primitivo que permite la facilidad
		 * de verificaciones con dos estados "verdadero" ó "falso" (1 bit).
		 */
		boolean  real;
		boolean fake;

		//Es un tipo primitivo que permite usar poca memoria (8 bits)
		byte d1;
		byte d3;

		//Es un tipo primitivo que permite denotar numeros pequeños (16 bits)
		short a13;
		short a07;

		 //Es un tipo primitivo el cual representa al campo de los enteros (32 bits)
		int edad;
		int año;

		// Tipo primitivo que nos ayuda a representar grandes cantidades (64 bits) 
		long billones;
		long segundos;

		// Tipo primitivo que permite representar caracteres
		char a;
		char z;

		// Es un tipo primitivo que permite representar cantidades decimales ocupando menor memoria que un double (32 bits)
		float medida1;
		float medida2;

		 /** Tipo primitivo que permite representar cantidades decimales en  
		  * un rango mayor que el float (64 bits)
	 	  */
		 double decimal1;	
		 double decimal2;

					//(Actividad 2) Ası́gnar un valor a cada variable 
		 real = true;

		 fake = false;

		 d1 = -6;

		 d3 = 7;

		 a13 = 1000;

		 a07 = 8000;

		 edad = 18;

		 año = 2020;

		 billones = 63456787;

		 segundos = 644567865;

		 a = 'a';

		 z = 'z';

		 medida1 = 1545233;

		 medida2 = 172563;

		 decimal1 = 3.1416181232334567876543456;

		 decimal2 = 1.098765456654345;


					//(Actividad 3) Declaracion, asignacion y explicacion de variables

		//Elegi que fuera del tipo booleano por el nombre de la variable (ya que en este tipo solo exite "true o false")
		 boolean booleanTrue = true;

		//Elegi que fuera del tipo byte por el rango de alcance que tiene (-128 a 128)
		 byte cientoVeintisiete = 127;

		//No requiere tanto uso de memoria y al mismo tiempo, el tipo de dato short representa un entero con signo  
		 short treintaYDosMil = 32000;

 		/*A diferencia del short, este entero con signo tiene mayor alcance y uso de memoria al momento de guardar 
 		valores grandes*/
 		int  dosMilMillones = 2000000000;

 		/* Decidi tomar como tipo de dato primitivo long porque al intentar con otros no funcinaba y al investigar me di cuenta de que 
 		 * auque un representa el campo de los enteros, este tipo de dato es el que mas tamaño (en bits) posee, lo cual es util para numeros
 		 * mucho muy grandes
 		 */ 
 		long doscientosMilMillones = 200000000000L;

 		//Al represetar una variable con una letra usamos char, ya que byte es para números 
 		char b = 'a';

 		/*Decidi poner estas dos ultimas variables con el mismo tipo de dato ya que aunque pude colocar un long, el ahorro de memoria es 
 		 * importante a recalcar (uno es de 64 bits y otro de 32), lo importante es que el programa compile
 		 */ 
 		float unoPuntodosMil = 1.2000f;
 		float unoPuntoDoscientosMilMillones = 1.200000000000f;


					//(Actividad 4) Declaracion de variables

 		/*Aunque en la practica se especifica que el valor de "y" es igual a 2 (tipo de dato int)
		 * es necesario que "y" sea de tipo float para ser compatible con las demás variables
 		 */ 
 		float y = 2;
 		System.out.println("y = "+y);

 		
 		double cubi = y*y*y;
 		double dentro = (y/(y*y+1));
 		double equis = cubi*dentro;
 		System.out.println("x = "+equis);

 		double zeta = equis*(equis+30)/(y*y+(equis*equis/y));
 		System.out.println("z = "+zeta);

 		boolean dobleu = true && false || true ||true; 		   	
 		System.out.println("w = "+dobleu);

 		boolean uve = false||dobleu && dobleu||false|| !false;
 		System.out.println("v = "+uve); 			 



 	}
 }

