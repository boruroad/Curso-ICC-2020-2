/**
 * Bonilla Ruiz Roberto Adrian
 * Tarea 7 ICC "Recursion"
 */

public class Comprobacion{
	
	//En mi caso yo decidi solamente comprobar los ejercicios 1 y 2 
	public void funcion1 (int x){
		System.out.println(x);
		funcion1(x-1);

	}

	public static void funcion2(int x){
		if(x>0){
			System.out.println(x);
			funcion2(x-1);
		}
	}

	public static void main(String [] args){
		Comprobacion c1 = new Comprobacion();
		System.out.println("La primera funcion, devuelve");
		//c1.funcion1(5);
		//Lo comenté porque sino no podria ver que pasaba con la segunda función
		
		System.out.println("La segunda funcion, devuelve");
		 c1.funcion2(5);

	}
}
