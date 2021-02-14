/**
 * Clase Calculadora
 * @author Adriana Sánchez Del Moral.
 * @version 1.0 
 */

import java.util.Scanner;  

public class Calculadora{
	/** Color de la calculadora */
	private String color;

	/** Marca de la calculadora */
	private String marca;

	/** Propietario de la calculadora */
	private  String nombreDuenio;



	/**
     * Constructor de una calculadora.
     * @param color color de la calculadora.
     * @param marca marca de la calculadora.
     * @param nombreDuenio propietario de la calculadora.
     */


	public Calculadora(String color, String tamaño, String marca, String duenio){
		this.color = color;
		this.marca = marca;
		this.nombreDuenio = duenio;
	}

	/**
     * Constructor por default de una calculadora.
     */

	public Calculadora(){
		this.color = "Negro";
		this.marca = "Patito";
		this.nombreDuenio = "Sin dueño";
	}

	/**
     * Metodo toString para representar una calculadora
     */

	@Override
	public String toString(){
		return "Calculadora de: "+ this.getDuenio() + "\nColor: "+ this.getColor() + " \nMarca: "+ this.getMarca();
	}

	/**
     * Modifica el color de la calculadora.
     * @param color color de la calculadora.
     */
	public void setColor(String color){
		this.color=color;
	}

	/**
     * Modifica la marca de la calculadora.
     * @param marca marca de la calculadora.
     */
	public void setMarca(String marca){
		this.marca=marca;
	}

	/**
     * Modifica el duenio de la calculadora
     * @param duenio duenio de la calculadora.
     */
	public void setDuenio(String duenio){
		this.nombreDuenio=duenio;
	}

	/**
     * Regresa el color de la calculadora.
     * @return el color de la calculadora.
     */

	//Métodos de Acceso, permiten ver el estado de una instancia (getters inlcuyen return, no llevan parámetros).
	public String getColor(){ 
		return this.color;
	}

	public String getMarca(){
		return this.marca;
	}

	public String getDuenio(){
		return this.nombreDuenio;
	}


	/**
     * Realiza una suma de dos numeros enteros.
     * @param a primer numero
     * @param b segundo numero
     * @return a+b
     */

	public int sumarBinaria (int a, int b){
		return a+b;
	}

	/**
     * Realiza una resta de dos numeros enteros.
     * @param a primer numero
     * @param b segundo numero
     * @return a-b	
     */

	public int restarBinaria (int a, int b){
		return a-b;
	}

	/**
     * Realiza una multiplicación de dos numeros enteros.
     * @param a primer numero
     * @param b segundo numero
     * @return  a*b		
     */

	public int multiplicar (int a, int b){
		return a*b;
	}

	/**
     * Realiza una división de doa numeros enteros.
     * @param a primer numero
     * @param b segundo numero
     * @return  a/b	
     */

	public int dividir (int a, int b){
		if(b > 0)
			return a/b;
		else 
			return -1000; //Se pudo regresar cualquier otro numero "absurdo"
	}

	/**
     * Obtiene el modulo de dos numeros enteros.
     * @param a primer numero
     * @param b segundo numero
     * @return  a%b		
     */

	public int modular (int a, int b){
		return a%b;
	}


	/**
     * Obtiene la suma de dos numeros enteros haciendo operaciones unarias Postfijo
     * @param a primer numero
     * @param b segundo numero
     * @return  a+b		
     */

	public int sumarPostfijo (int a, int b){
		for(int i= 0; i < b; i++){
			System.out.println("iteracion: " + i + " actual "+ a + " x++ " + a++);
		
		}
		return a;
	}

	/**
     * Obtiene la resta de dos numeros enteros haciendo operaciones unarias Postfijo
     * @param a primer numero
     * @param b segundo numero
     * @return  a-b		
     */

	public int restarPostfijo (int a, int b){
		for(int i = 0; i < b; i++){
			System.out.println("iteracion: " + i + " actual "+ a + " x-- " + a--);
		}
		return a;
	}



	/**
     * Obtiene la suma de dos numeros enteros haciendo operaciones unarias Sufijo
     * @param a primer numero
     * @param b segundo numero
     * @return  a+b		
     */

	public int sumarSufijo (int a, int b){
		for(int i= 0; i < b; i++){
			System.out.println("iteracion: " + i + " actual "+ a + " ++x " + ++a);
		
		}
		return a;
	}

	/**
     * Obtiene la resta de dos numeros enteros haciendo operaciones unarias Sufijo
     * @param a primer numero
     * @param b segundo numero
     * @return  a-b		
     */

	public int restarSufijo (int a, int b){
		for(int i = 0; i < b; i++){
			System.out.println("iteracion: " + i + " actual "+ a + " --x " + --a);
		}
		return a;
	}

	public static void main(String[] args) {

		//Creamos nuestro Scanner
    	Scanner entrada = new Scanner(System.in);
		
		System.out.println("Bienvenido a nuestro menu, por favor escoge una de las siguientes opciones:\n");

		Calculadora calculadora = new Calculadora();
		//String color, String tamaño, String marca, String duenio)
		//Una ayuda para que no hagan tanto uso de System.out.println(), escribe las operaciones faltantes
		System.out.println(" 0- Salir\n"+
						   " 1- Configura los datos de la calculadora \n"+
						   " 2- Obtener datos \n" +
						   " 3- Hacer suma binaria \n"+
						   " 4- Hacer resta binaria\n"+
						   " 5- Hacer multiplicación\n"+
						   " 6- Hacer divicion\n"+
						   " 7- Hacer modulo\n"+
						   " 8- Hacer suma operador incremento postfijo\n"+
						   " 9- Hacer suma operador incremento sufijo\n"+
						   "10- Hacer resta operador incremento postfijo\n"+
						   "11- Hacer resta operador incremento sufijo\n");	

		int opciones = entrada.nextInt();
		
		do{ 
      		//Usamos un switch para ejecutar la opción elegida por el usuario con sus diferentes casos
      		switch(opciones){ 
                    
        		//Si el usuario escoge configurar los datos de la calculadora
       		    case 1:
         		System.out.println("Introduce los datos a modificar\n"+"Color: ");
         		String nuevoColor= entrada.next();
         		calculadora.setColor(nuevoColor);

		      	System.out.println("\nMarca: ");
		      	String nuevaMarca = entrada.next();
		      	calculadora.setMarca(nuevaMarca);

		        System.out.println("\nDueño: ");
		        String nuevoDue = entrada.next();
         		calculadora.setDuenio(nuevoDue);

         		System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;
    		
        

        		//Si el usuario escoge obtener datos
        		case 2:
        		System.out.println(calculadora.toString()+"\n");
        		System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();      
        		break;

        		//Si el usuario escoge hacer suma binaria
        		case 3:
				System.out.println("\nEscogiste la función \"suma binaria\" \nIngrese primer número:");
				int n1 = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int n2 = entrada.nextInt();

				int resultado = calculadora.sumarBinaria(n1,n2);
				System.out.println("\nResultado -> " +resultado);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
       		    break;

       		    //Si el usuario escoge hacer resta binaria
       			case 4:
       			System.out.println("\nEscogiste la función \"resta binaria\" \nIngrese primer número:");
				int nu1 = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int nu2 = entrada.nextInt();

				int r = calculadora.restarBinaria(nu1,nu2);

				System.out.println("\nResultado -> " +r);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

        		//Si el usuario escoge hacer multiplicacion 
        		case 5:
        		System.out.println("\nEscogiste la función \"multiplicación\" \nIngrese primer número:");
				int num1 = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int num2 = entrada.nextInt();

				int m = calculadora.multiplicar(num1,num2);
				System.out.println("\nResultado -> " +m);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

        		//Si el usuario escoge hacer division
        		case 6:
        		System.out.println("\nEscogiste la función \"división\" \nIngrese primer número:");
				int nume1 = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int nume2 = entrada.nextInt();

				int d = calculadora.dividir(nume1,nume2);
				System.out.println("\nResultado -> " +d);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

				//Si el usuario escoge hacer modulo
        		case 7:
        		System.out.println("\nEscogiste la función \"modulo\" \nIngrese primer número:");
				int numer1 = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int numer2 = entrada.nextInt();

				int mo = calculadora.modular(numer1,numer2);
				System.out.println("\nResultado -> " +mo);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

        		//Si el usuario escoge hacer suma operador incremento postfijo
        		case 8:
        		System.out.println("\nEscogiste la función \"suma operador incremento postfijo\" \nIngrese primer número:");
				int numero1 = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int numero2 = entrada.nextInt();

				int sum = calculadora.sumarPostfijo(numero1,numero2);
				System.out.println("\nResultado -> " +sum);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

        		//Si el usuario escoge hacer suma operador incremento sufijo
        		case 9:
        		System.out.println("\nEscogiste la función \"suma operador incremento sufijo\" \nIngrese primer número:");
				int  p1= entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int p2= entrada.nextInt();

				int rP= calculadora.sumarSufijo(p1,p2);
				System.out.println("\nResultado -> " +rP);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

        		//Si el usuario escoge hacer resta operador incremento postfijo
        		case 10:
        		System.out.println("\nEscogiste la función \"resta operador incremento postfijo\" \nIngrese primer número:");
				int uno= entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int dos = entrada.nextInt();

				int solucion= calculadora.restarPostfijo(uno,dos);
				System.out.println("\nResultado -> " +solucion);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
        		break;

        		//Si el usuario escoge hacer resta operador incremento sufijo
        		case 11:
        		System.out.println("\nEscogiste la función \"resta operador incremento sufijo\" \nIngrese primer número:");
				int primer = entrada.nextInt();

				System.out.println("\nInserte segundo número");
				int segundo = entrada.nextInt();

				int resp = calculadora.restarSufijo(primer,segundo);
				System.out.println("\nResultado -> " +resp);

				System.out.println("\n¿Continuar? (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
            	break;
  		
        		default:
        		while(opciones != 0){ 
        		System.out.println("\nOpción inválida (Ingrese un número para realizar otra de las opciones o pulsa 0 para salir)");
            	opciones = entrada.nextInt();
            	}

       		}//Fin del switch
       			if (opciones==0){

         		entrada.close();
         	 	System.out.print("Calculadora de "+ calculadora.getDuenio()+ " fuera\n" );
				}		

   		}while(opciones != 0);

		

	

	}
}