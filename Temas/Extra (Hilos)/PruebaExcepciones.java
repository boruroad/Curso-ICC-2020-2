
import java.util.Scanner;
import java.util.InputMismatchException;

public class PruebaExcepciones{
	public int a, b;

	public static void main(String[] args)  {

		Scanner sc = new Scanner (System.in);
		boolean comprueba = true;
		
		do{
			comprueba = true;
		try{
			System.out.println("Ingrese dos numeros para dividir"); 
			int a = sc.nextInt();
			int b = sc.nextInt();
			double resultado = a/b;
			System.out.println(resultado);
		}catch(ArithmeticException ae){
			System.out.println("No se puede dividir entre cero");
			comprueba = false;
		}catch(InputMismatchException ime){
			System.out.println("Dato inválido");
			comprueba = false;
			sc.nextLine();
		}catch(Exception e){
			System.out.println("Algo inesperado ocurrió");
			comprueba = false;
		}
		}while(comprueba != true);


	}
	
}