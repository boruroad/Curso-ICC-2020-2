import java.util.Scanner;
import java.util.Random;

public class C{
	
	//Creamos los atributos de la clase Cifrando	
	private String menCif;
	private String menDescif;
	private static String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; //La Ñ si será un caracter aceptado por mi alfabeto
	private String cadena1;
	private String sinC;
	private String conC;
	private String cifradoK;
	private String nuevoA;
	private String descifradoK;



	//Método de acceso del mensaje cifrado
	public String getMenCif(){
		return this.menCif;
	}

	//Método de acceso del mensaje cifradoK
	public String getCifradoK(){
		return this.cifradoK;
	}

	//Método de acceso del mensaje descifradoK
	public String getDescifradoK(){
		return this.descifradoK;
	}
	//Método de acceso (nuevoA)
	public String getNuevoA(){
		return this.nuevoA;
	}
	//Método de acceso del mensaje descifrado
	public String getMenDescif(){
		return this.menDescif;
	}

	//Método de acceso cadena1
	public String getCadena1(){
		return  this.cadena1;
	}

	//Método de acceso sinC (sin cifrar)
	public String getSinC(){
		return this.sinC;
	}

	//Método de acceso conC (con cifrado)
	public String getConC(){
		return this.conC;
	}	
	


	/* Método que lee la cadena de sc . */
	public String obtenCadena (Scanner sc ){
		String cadena1 = sc.nextLine().replaceAll(" ","").replaceAll(",","").replaceAll("Á","A").replaceAll("É","E").replaceAll("Í","I").replaceAll("Ó","O").replaceAll("Ú","U").replaceAll("á","A").replaceAll("é","E").replaceAll("í","I").replaceAll("ó","O").replaceAll("ú","U").replaceAll("[^ñ,a-z Ñ,A-Z]+","").toUpperCase();
		this.cadena1=cadena1;
		return cadena1;
	}

	/**
	* Trabaja con un atributo de la clase como cadena
	* origen y regresa la cadena cifrada .
	* @param k El de splazami ento que se desea dar .
	* @return La cadena cifrada .
	*/
	public String cifradoDeCesar (int k){
		this.menCif = "";
		for(int i = 0; i<this.cadena1.length(); i++){
			 menCif+=Character.toString(alfabeto.charAt((alfabeto.indexOf(this.cadena1.charAt(i))+k)%alfabeto.length()));
		}
		return menCif;
	}


	/**
	* Trabaja con un atributo donde se encuentra la cadena
	* cifrada y regresa la cadena original.
	*
	* @param k El desplazamiento original.
	* @return La cadena descifrada sin blancos ni caracteres especiales.
	*/
	public String descifradoDeCesar(int k){
		this.menDescif = "";
		for(int i=0; i<this.cadena1.length(); i++){
			menDescif+=Character.toString(alfabeto.charAt((alfabeto.indexOf(this.cadena1.charAt(i))+alfabeto.length()-k)%alfabeto.length()));
		}
			return  menDescif;
	}



	/**
	* Regresa los tres rieles pegados . Trabaja a partir
	* de un atributo donde se encuentra la cadena origen .
	*
	* @return Una cadena con los rieles pegados sin blancos .
	*/
	public String cifraRieles(){
		String todo = "";
		String r1 = "";
		String r2 = "";
		String r3 = "";

		for(int i=0; i<this.cadena1.length(); i++){
			if(i%3 == 0){
				r1+=Character.toString(this.cadena1.charAt(i));
			} 

			if(i%3 == 1){
				r2+=Character.toString(this.cadena1.charAt(i));
			}

			if(i%3 == 2){
				r3+=Character.toString(this.cadena1.charAt(i));
			}

		} 
		todo +=r1+r2+r3;
		this.sinC = todo;
		return this.sinC;
	}
	
	
	/**
	* Trabaja con un atributo donde se encuentra la cadena
	* y regresa la cadena original
	* @return La cadena original, pero sin blancos ni caracteres especiales .
	*/
	public String descifraRieles(){
		String completo = "";
		String riel1 = "";
		String riel2 = "";	
		String riel3 = "";	

		for(int i=0; i<this.cadena1.length();i++){
		
			switch(cadena1.length()%3){
		
				case 0:
				riel1+= Character.toString(this.cadena1.charAt(i));
				continue;
	
				case 1:
				riel2+=Character.toString(this.cadena1.charAt(i));
				continue;
	
				case 2:
				riel3+=Character.toString(this.cadena1.charAt(i));
				continue;
		
			}

		} 
		completo += riel1+ riel2 +riel3;
		this.conC = completo;
		return  this.conC; 
	}

	/**
	* Revuelve el alfabeto . Trabaja a partir del alfabeto , que
	* puede ser est á tico y constante .
	*
	* @return El alfabeto revuelto .
	*/
	public String revuelve (){
	Random rnd = new Random();
		this.nuevoA = "";
		for (int i=0;i<alfabeto.length();){
			char niu = alfabeto.charAt(rnd.nextInt(alfabeto.length()));
			if(this.nuevoA.indexOf(niu)<0){ 
				this.nuevoA+=""+niu;
				i++;
			}
		}
		return this.nuevoA;
	}

	/**
	* Trabaja con un atributo de la clase como cadena origen y
	* regresa la cadena cifrada.
	* @param revuelto El alfabeto revuelto .
	* @return La cadena cifrada.
	*/
	public String cifradoKamaSutra(String revuelto){
		this.cifradoK ="";
		for (int i=0;i<this.cadena1.length();i++){
			this.cifradoK+=Character.toString(this.nuevoA.charAt(alfabeto.indexOf(this.cadena1.charAt(i))));
			
		}
		return this.cifradoK;

	}

	/**
	* Trabaja con un atributo donde se encuentra la cadena
	* cifrada yregresa la cadena original.
	* @param revuelto El alfabeto que se us ó para cifrar .
	* @return La cadena descifrada , aunque sin blancos nicaracteres especiales
	*/
	public String descifraKamaSutra(String revuelto ){
		this.descifradoK ="";
		for (int i=0;i<this.cifradoK.length();i++){
			this.descifradoK+=Character.toString(alfabeto.charAt(this.nuevoA.indexOf(this.cifradoK.charAt(i))));
			
		}
		return  this.descifradoK;

	}



	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		C c2 = new C();

		System.out.print("\nLos tipos de cifrado son \n 1---> César \n 2---> Rieles \n 3---> Kama-sutra");


				System.out.print("\n\nEscribe tu mensaje a cifrar:\n");
				c2.obtenCadena(sc);

				System.out.println("\n \"César\"");
				int posicion = 1;
				System.out.println("Tu mensaje cifrado es: \n"+c2.cifradoDeCesar(posicion));
				posicion+=-posicion;
				System.out.println("De manera descifrada es: \n"+c2.descifradoDeCesar(posicion));
				System.out.println("\n \"Rieles\"");
				System.out.println("Tu mensaje cifrado es: \n"+c2.cifraRieles());
				System.out.println("De manera descifrada es: \n"+c2.descifraRieles());
								
				System.out.println("\n \"Kama-sutra\"");
				//c2.revuelve();

				System.out.print("\nEl alfabeto revuelto es: \n"+c2.revuelve()+"\n");
				System.out.print("\nEl alfabeto ordenado es: \n"+alfabeto);
				System.out.println("\n\nEl mensaje cifrado es: \n"+c2.cifradoKamaSutra(c2.getNuevoA()));
				System.out.println("De manera descifrada es: \n"+c2.descifraKamaSutra(c2.getNuevoA()));
				

				

	}



}