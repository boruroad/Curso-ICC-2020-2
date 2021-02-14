//Bonilla RUiz Roberto Adrián
public class Tarea3{
	
	static String cadenaOriginal = "    Hola ComPutologOs, No S&lG&n en Cu&rEnteN&    ";
	String cadenaDelObjeto = "Soy una cadena del objeto";

	public String copiarCadena(String original){
		String nuevacadena = original;
		return nuevacadena;
	}

	public int longitud(String cadena){
		return cadena.length();
	}

	public String reemplaza(String cadena, String aCambiar, String cambio){
		return cadena.replaceAll(aCambiar, cambio);
	}

	public String quitaEspaciosInicialesFinales(String cadena){
		return cadena.trim();
	}

	public char caracterEnIndice(String cadena, int indice){
		return cadena.charAt(indice);

	}
	public boolean sonIgualesSinDistincion(String cadena1, String cadena2){
		return cadena1.equalsIgnoreCase(cadena2);
	}

	public int indiceDeSubcadena(String cadena, String subcadena){
		return cadena.indexOf(subcadena);
	}

	public String[] subCadenas(String cadena, String delimitador){
		return cadena.split(delimitador);
	}

	public String valorDelCaracterACadena(char a){
		return String.valueOf(a);
	}

	public static void main(String [] args){

		/*			Pruebas para los metodos implementados
		*/
		Tarea3 prueba = new Tarea3();
		String cadena1, cadena2, cadena3;
		int index1;

	/*0*///System.out.println(cadenaOriginal.charAt(cadenaOriginal.length()));
	/*1*/cadena1 = prueba.quitaEspaciosInicialesFinales(cadenaOriginal);
	/*2*/cadena2 = prueba.reemplaza(cadena1, "&", prueba.valorDelCaracterACadena(prueba.caracterEnIndice(cadena1,3)));
	/*3*/System.out.println(prueba.sonIgualesSinDistincion("HOLA COMPUTOLOGOS, NO SALGAN EN CUARENTENA",cadena2));
			//Esta impresion debe devolver true;
	/*4*/index1 = prueba.indiceDeSubcadena(cadena2, "ComPutologOs");
	/*5*/System.out.println(prueba.subCadenas(cadena2, " ")[index1] +" == CuarEnteNa");	
			//Esta impresion debe devolver "CuarEnteNa == CuarEnteNa"

   		 System.out.println("");


	/*				RECORDANDO 
	*/

	/*6*/prueba.cadenaDelObjeto = cadena2;
	/*7*/cadenaOriginal = cadena2;
	/*8*/Tarea3 prueba2 = new Tarea3();
		//Revisemos cual es el valor de la variable _cadenaOriginal_ de los objetos prueba y prueba1
	/*9*/System.out.println("Cadena original en prueba " + prueba.cadenaOriginal);
   /*10*/System.out.println("Cadena original en prueba2 " + prueba2.cadenaOriginal);
		//Revisemos cual es el valor de la variable _cadenaDelObjeto_ de los objetos prueba y prueba1
   		 System.out.println("");
   /*11*/System.out.println("Cadena del objeto en prueba " +prueba.cadenaDelObjeto);
   /*12*/System.out.println("Cadena del objeto en prueba2 " +prueba2.cadenaDelObjeto);

	}
}