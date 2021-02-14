//ACTIVIDAD5
public class Veterinario{
	
	/** Este atributo almacena el nombre del veterinario */
	public String nombre;


	/** El método constructor se debe llamar igual que la clase */
	public Veterinario(String nombre){
		this.nombre = nombre;

	}


	/** Creamos los métodos modificadores y 
	  * de acceso de la propiedad "nombre"
	  */

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	//Creamos el método "hacer mejores amigos"

	public void hacerMejoresAmigos(Mascota mascota1, Mascota mascota2){
		mascota1.setExMejorAmigo(mascota1.getMejorAmigo());
		mascota1.setMejorAmigo(mascota2);

		mascota2.setExMejorAmigo(mascota2.getMejorAmigo());
		mascota2.setMejorAmigo(mascota1);

	}


	//Creamos el método "revertir amistad"
	public void revertirAmistad(Mascota mascota1){
		mascota1.setMejorAmigo(mascota1.getExMejorAmigo());
		mascota1.setExMejorAmigo(null);
	}

	public static void main(String[] args) {
		

		Veterinario vet1 = new Veterinario ("Yudu");


		//Creando nuestras instancias
		Mascota perro1  = new  Mascota ("perro","Bola de nieve", "Chihuahua","Jugar a la pelota");
		Mascota perro2  = new  Mascota ("perro","Pelusa","Chihuahua", "Cargarlo ");
		Mascota perro3  = new  Mascota ("perro","Gauss", "Chihuahua","Bañarse ");
		Mascota perro4  = new  Mascota ("perro","Picafresa", "Husky","Correr ");
		Mascota perro5  = new  Mascota ("perro","Timmy", "Husky","Dormir ");
		Mascota perro6  = new  Mascota( "perro","Lucy", "Husky","Echarse en el sillón ");

		//Interactuando el veterinario conlas mascotas
		//Primera relacion perro1
		vet1.hacerMejoresAmigos(perro1, perro2);

		//Segunda Realacion perro1
		vet1.hacerMejoresAmigos(perro1, perro3);
	
		System.out.println(perro1+"\n");	

		//Revirtiendo relación perro1
		vet1.revertirAmistad(perro1);

		System.out.println("Revirtiendo la relación \n\n"+perro1+"\n");
			System.out.println("********************");

		//Primera relacion perro2
		vet1.hacerMejoresAmigos(perro2, perro1);

		//Segunda Realacion perro2
		vet1.hacerMejoresAmigos(perro2, perro4);
	
		System.out.println(perro2+"\n");	

		//Revirtiendo relación perro2
		vet1.revertirAmistad(perro2);

		System.out.println("Revirtiendo la relación \n\n"+perro2+"\n");
			System.out.println("********************");


		//Primera relacion perro3
		vet1.hacerMejoresAmigos(perro3, perro4);

		//Segunda Realacion perro3
		vet1.hacerMejoresAmigos(perro3, perro5);
	
		System.out.println(perro3+"\n");	

		//Revirtiendo relación perro3
		vet1.revertirAmistad(perro3);

		System.out.println("Revirtiendo la relación \n\n"+perro3+"\n");
			System.out.println("********************");

		//Primera relacion perro4
		vet1.hacerMejoresAmigos(perro4, perro3);

		//Segunda Realacion perro4
		vet1.hacerMejoresAmigos(perro4, perro6);
	
		System.out.println(perro4+"\n");	

		//Revirtiendo relación perro4
		vet1.revertirAmistad(perro4);

		System.out.println("Revirtiendo la relación \n\n"+perro4+"\n");
			System.out.println("********************");





	}
}