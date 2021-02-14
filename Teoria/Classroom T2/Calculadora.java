/**
 * Representacion de una calculadora. Esta clase define
 * caracteristicas y acciones.
 * @author Roberto Adrián Bonilla Ruiz.
 * @version 1.0 
 */

public class Calculadora{
	
	/** Color de la calculadora */
	public  String color;

	/** Estilo / tamaño de la calculadora */
	private String tamaño;

	/** Marca de la calculadora */
	private static String marca;

	/** Propietario de la calculadora */
	public  String dueño;

	/**
	  * Para realizar las operaciones respectivas de la 
	  * calculadora, requerimos antes inicializar los "numeros" que 
	  * va a utilizar   
	  */

	/** Las operaciones aritméticas son: suma, resta, multiplicación, 
	  * división, modulo, operacion orden (recibe 3 numeros diferentes,
	  * dice cual es mayor, menor y si no hay numeros iguales).
	  */ 
		private int numero1;
		private int numero2;
		private int numero3;
		private boolean a1;
		private boolean a2; 

	/**
     * Construye una nueva calculadora con sus atributos.
     * @param color color de la calculadora.
     * @param tamaño tamaño de la calculadora.
     * @param marca marca de la calculadora.
     * @param dueño propietario de la calculadora.
     */


	public Calculadora(String color, String tamaño, String marca, String dueño){

   	/* 'this' se refiere a los atributos de la clase.
   	 * las variables sin 'this' se refiere a los parámetros
   	 * del metodo. */
		this.color=color;
		this.tamaño=tamaño;
		this.marca=marca;
		this.dueño=dueño;

	}

	/**
     * Modifica el color de la calculadora.
     * @param color color de la calculadora.
     */


	//Métodos Mutantes, permiten cambiar el estado inicial (setters icluyen parámetros, no return).
	public void setColor(String colorAlumno){
		this.color=colorAlumno;
	}

	public void setEstilo(String tamañoAlumno){
		this.tamaño=tamañoAlumno;
	}


	/**
     * Permite accesar al color de la calculadora.
     * @return el color de la calculadora.
     */

	//Métodos de Acceso, permiten ver el estado de una instancia (getters inlcuyen return, no llevan parámetros).
	public String getColor(){ 
		return this.color;
	}

	public String getEstilo(){
		return this.tamaño;
	}

	public String getMarca(){
		return this.marca;
	}

	public String getDueño(){
		return this.dueño;
	}


	/**
     * Realiza una suma de dos numeros enteros.
     * @param numero1 número a sumar.
     * @param numero2 número a sumar.
     * @return suma de número1 + número2
     */

	public int sumarBinaria (int numero1, int numero2){
		return numero1+numero2;
	}

	/**
     * Realiza una resta de dos numeros enteros.
     * @param numero1 número a restar.	
     * @param numero2 número a restar.
     * @return resta de numero1 - numero2 	
     */

	public int restarBinaria (int numero1, int numero2){
		return numero1-numero2;
	}

	/**
     * Realiza una multiplicación de dos numeros enteros.
     * @param numero1 número a multiplicar.	
     * @param numero2 número a multiplicar.
     * @return multiplicación de numero1 por numero2. 	
     */

	public int multiplicar (int numero1, int numero2){
		return numero1*numero2;
	}

	/**
     * Realiza una división de doa numeros enteros.
     * @param numero1 divisor.	
     * @param numero2 dividendo.
     * @return división de numero1 entre numero2. 	
     */

	public int dividir (int numero1, int numero2){
		return numero1/numero2;
	}

	/**
     * Obtiene el modulo de dos numeros enteros.
     * @param numero1 divisor.	
     * @param numero2 dividendo.
     * @return residuo de la división de numero1 entre numero2. 	
     */

	public int modular (int numero1, int numero2){
		return numero1%numero2;
	}


	/**
     * Obtiene la suma para el operador de autoincremento de dos numeros enteros.
     * @param numero1 numero a sumar.	
     * @param numero2 numero a sumar.
     * @return suma de numero1 más numero2. 	
     */

	public int sumarPostfijo (int numero1, int numero2){
		for(int i= 0; i < numero2; i++){
			System.out.println("iteracion: " + i + " actual "+ numero1 + " x++ " + numero1++);
		
		}
		return numero1;

	}

	/**
     * Obtiene la resta para el operador de autodecremento de dos numeros enteros.
     * @param numero1 numero a restar.	
     * @param numero2 numero a restar.
     * @return resta de numero1 menos numero2. 	
     */

	public int restarPostfijo (int numero1, int numero2){
		for(int j = 0; j < numero2; j++){
			System.out.println("iteracion: " + j + " actual "+ numero1 + " x-- " + (numero1--));
		}
		return numero1;
	}

	/**
     * Obtiene la suma para el operador de autodecremento de dos numeros enteros.
     * @param numero1 numero a sumar.	
     * @param numero2 numero a sumar.
     * @return resta de numero1 menos numero2. 	
     */

	public int sumarSufijo (int numero1, int numero2){
		for(int k = 0; k < numero2; k++){
			System.out.println("iteracion: " + k + " actual "+ numero1 + " ++x " + (++numero1));
			
		}
		return numero1;


	}

	/**
     * Obtiene la resta para el operador de autodecremento de dos numeros enteros.
     * @param numero1 numero a restar.	
     * @param numero2 numero a restar.
     * @return resta de numero1 menos numero2. 	
     */

	public int restarSufijo (int numero1, int numero2){
		for(int i= 0; i < numero2; i++){
			System.out.println("iteracion: " + i + " actual "+ numero1 + " x++ " + (--numero1));
		
		}
		return numero1;
		

	}

	/**
     * Operación ”orden” que dados 3 números aleatorios nos diga cual es el mayor,
	 * cual es el menor y cuales son iguales.
     * @param numero1 numero al azar.	
     * @param numero2 numero al azar.
     * @param numero3 numero al azar.
     * @return cual es el mayor, cual es el menor y cuales son iguales. 	
     */

	public void orden (int numero1, int numero2, int numero3){
		if(numero1 > numero2 && numero1 > numero3){
       		System.out.println(numero1+" es el mayor de todos ");
        }
        if(numero2 > numero1 && numero2 > numero3){
        	System.out.println(numero2+" es el mayor de todos ");
        }
        if(numero3 > numero1 && numero3 > numero2){
        	System.out.println(numero3+" es el mayor de todos ");
        }
        if(numero1 == numero2 && numero1==numero3){
        	System.out.println("Todos son iguales"+"\n");	
        }
        if(numero1 < numero2 && numero1 < numero3){
       		System.out.println(numero1+" es el menor de todos," + " no hay números iguales\n");
        }
         if(numero2 < numero1 && numero2 < numero3){
        	System.out.println(numero2+" es el menor de todos," +" no hay números iguales \n");
        }
        if(numero3 < numero1 && numero3 < numero2){
        	System.out.println(numero3+" es el menor de todos," +" no hay números iguales\n");
        }


        return;
	}

	//Para realizar operaciones lógicas 
	public boolean conjuncion(boolean a1, boolean a2){
		return (a1 && a2);
	}
		  
	public boolean disyuncion(boolean a1, boolean a2){
		return (a1 || a2);
	}


	// Método toString 
	@Override
    public String toString(){
	return
		"\nTamaño: "+this.tamaño+
	    "\nColor:  "+this.color+
	    "\nMarca:  "+this.marca+
	    "\nDueño:  "+this.dueño+"\n";
	   
    }
	 
	public static void main(String[] args) {
	
	 /**
	   * Colocamos el "main" porque a partir de aqui, es donde  
	   * empezara a ejecutarse el codigo (asimismo empezamoa acrear nuestras instancias).
	   */
	
	 Calculadora calcu1 = new Calculadora("NEGRA","MEDIANANA","CASIO","Alumno");
	 Calculadora calcu2 = new Calculadora("NEGRA","MEDIANANA","CASIO","Alumno");
	 Calculadora calcu3 = new Calculadora("NEGRA","MEDIANANA","CASIO","Alumno");
	 Calculadora calcu4 = new Calculadora("NEGRA","MEDIANANA","CASIO","Alumno");

	 /**
	   * Decidí crear varias calculadoras "iguales" para que cada alumno si asi lo deseé, pueda cambiar su estilo y color) 
 	   * pero no pueda modificar el propietario ni la marca, ya que al ser calculadoras para la universidad, todas son
 	   * de la misma marca
 	   */

	 //Creando de manera especial la calculadora del director

	 Calculadora calcuDirec = new Calculadora("ROJA","GRANDE","CASIO","Director");

	 //Realizando la muestra con la calculadora del director

	 System.out.println("La calculadora del director es: \n"+calcuDirec);

	 System.out.print("La suma de 3 + 4 es " );
	 System.out.println(calcuDirec.sumarBinaria(3,4)+"\n");

	 System.out.print("La resta de 1532 - 345 es ");
	 System.out.println(calcuDirec.restarBinaria(1532,345)+"\n");

	 System.out.print("La multiplicación de 15 * 4 es ");
	 System.out.println(calcuDirec.multiplicar(15,4)+"\n");

	 System.out.print("La división de 200/40 es ");
	 System.out.println(calcuDirec.dividir(200,40)+"\n");

	 System.out.print("El modulo de 5/2 es ");
	 System.out.println(calcuDirec.modular(5,2)+"\n");

	 System.out.print("La suma postfija de 4 y 3 es ");
	 System.out.println(calcuDirec.sumarPostfijo(4,3)+"\n");

	 
	
	 System.out.print("La resta postfija de 1 y 7 es ");
	 System.out.println(calcuDirec.restarPostfijo(1,7)+"\n");

	
	 System.out.print("La suma sufija de 6 y 8 es ");
	 System.out.println(calcuDirec.sumarSufijo(6,8)+"\n");
	 

	 System.out.print("La resta sufija de 5 y 2 es ");
	 System.out.println(calcuDirec.restarSufijo(5,2)+"\n");

	 System.out.println("De los siguientes 3 números: 8, 8 y 8");
	 calcuDirec.orden(8,8,8);

	 System.out.println("De los siguientes 3 números: 3, 6 y 15 ");
	 calcuDirec.orden(3,6,15);


	 System.out.println("La conjunción de true y false es ");
	 System.out.println(calcuDirec.conjuncion(true,false)+"\n");

	 System.out.println("La disyuncion de false y false es ");
	 System.out.println(calcuDirec.disyuncion(false,false)+"\n");


	}

}