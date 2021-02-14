/**
 *Practica2 del curso de ICC. 
 * @author Bonilla Ruiz Roberto Adrián
 * @version 1.0
 */
	
		
public class Mascota{

	//ACTIVIDAD 1

	/** Tipo de animal, atributo privado  */
	private String perro; 

	// A partr del anterior atributo, seleccionare otros de la misma rama para delimitar el tipo de mascota

	/** Nombre de la mascota, atributo publico */
	public String nombre;

	//** Raza de la mascota, atributo publico */
	public String raza;

	/** Edad de la mascota, atributo privado */
	private String edad;

	/** Descendencia de la mascota (para saber si la mascota se ha cruzado), atributo privado */
	private boolean cruzado;

	/** Etapa del canino */
	private String etapa;

	/** Alimento de la mascota */
	public  String comida;

	/** Variable final, refente al tipo de animal (perro) */
	public final int COLA = 1;

	/** Creamos una variable que cuente cuantas mascotas tenemos */
	public static int NumeroDeMascotas;

	//ACTIVIDAD 2

	 /**
	 * Construye una nueva mascota con sus atributos.
	 * @param perro  Tipo de mascota.
	 * @param nombre Nombre de la mascota.
	 * @param raza   Raza de la mascota.
	 * @param edad   Edad de la mascota en años humano.
	 * @param cruzado Si ha procreado
	 * @param etapa  Etapa de la mascota
	 * @param comida Comida de la mascota
	 */

	public Mascota(String perro, String nombre, String raza,
				   String edad, boolean cruzado, String etapa, String comida){

		/* 'this' se refiere a los atributos de la clase.
		 * las variables sin 'this' se refiere a los parámetros
		 * del metodo. */

		this.perro=perro;
		this.nombre=nombre;
		this.raza=raza;
		this.edad=edad;  
		this.cruzado=cruzado;
		this.etapa=etapa;   
		this.comida=comida;
		this.NumeroDeMascotas++;

	}

	/** Construimos una nueva mascota con su
	 * Se sobreescribe el metodo constructor.
	 * Cambiamos los parametros
	 * @param perro  Tipo de mascota.
	 * @param nombre Nombre de la mascota.
	 * @param raza   Raza de la mascota.
	 * @param adora  LO que la mascota adora más de su dueño.
	 */

	public Mascota(String perro, String nombre, String raza, 	
				   String adora){

		this.perro=perro;
		this.nombre=nombre;
		this.raza=raza;
		this.adora=adora; 
		this.recuerdos="";
		this.NumeroDeMascotas++;
	}	

	/**
	 * Permite accesar al tipo de mascota
	 * @return tipo de mascota
	 */
	public String getPerro(){
		return this.perro;
	}	


	/**
	 * Permite accesar al nombre de la mascota
	 * @return nombre de la mascota 
	 */
	public String getNombre(){
		return this.nombre;
	}	


	/*
	 *Permite modificar el nombre de la mascota
	 */
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	

	/**
	 * Permite accesar a la raza de la mascota
	 * @return raza de la mascota
	 */
	public String getRaza(){
		return this.raza;
	}

	/**
	 * Permite accesar a la edad de la mascota
	 * @return edad de la mascota
	 */
	public String getEdad(){
		return this.edad;
	}

	/*
	 *Permite modificar la edad de la mascota
	 */
	public void setEdad(String edad){
		this.edad = edad;
	}

	/**
	 * Permite saber si la mascota ha procreado
	 * @return true o false 
	 */
	public boolean getCruzado(){
		return this.cruzado;
	}


	/*
	 *Permite modificar si la mascota ha procreado
	 */
	public void setCruzado(boolean cruzado){
		this.cruzado = cruzado;
	}


	/**
	 * Permite accesar a la etapa de la mascota
	 * @return etapa de la mascota
	 */
	public String getEtapa(){
		return this.etapa;
	}


	/*
	 *Permite modificar la etapa de la  mascota 
	 */
	public void setEtapa(String etapa){
		this.etapa=etapa;
	}

	/**
	 * Permite accesar a la comida de la mascota
	 * @return tipo de comida
	 */
	public String getComida(){
		return this.comida;
	}

	/*
	 *Permite modificar la comida de la  mascota 
	 */
	public void setComida(String comida){
		this.comida=comida;
	}
	
	//ACTIVIDAD 3

	private String adora;
	private String recuerdos;


	public String getAdora(){
		return this.adora;
	}


	/*
	 *Permite modificar lo que la mascota adora de su dueño
	 */
	public void setAdora(String adora){
		this.adora=adora;
	}


	/*
	 *Permite modificar la memoria de la  mascota 
	 */
	public void setRecuerdos(String recuerdos){
		this.recuerdos=recuerdos;
	}

	public String getRecuerdos(){
		return this.recuerdos;
	}


	//Método platicar
	public void platicar(Mascota mascota){
		this.setRecuerdos(this.recuerdos+" "+mascota.getAdora());
	} 


	/** Creamos la propiedad mejor amigo
	  * con sus métodos modificadores y de acceso
	  */
	private Mascota mejorAmigo;

	public Mascota getMejorAmigo(){
		return this.mejorAmigo; 
	}

	public void setMejorAmigo(Mascota mejorAmigo){
		this.mejorAmigo = mejorAmigo; 
	}


	/** Creamos la propiedad exMejorAmigo
	  * con sus métodos modificadores y de acceso
	  */
	private Mascota exMejorAmigo;

	public Mascota getExMejorAmigo(){
		return this.exMejorAmigo; 
	}

	public void setExMejorAmigo(Mascota exMejorAmigo){
		this.exMejorAmigo = exMejorAmigo; 
	}



	@Override 
    public String toString(){
	return "Tipo de mascota: "+this.perro+
	    "\nNombre: "+this.nombre+
	    "\nRaza: "+this.raza+
	    "\nAdora: "+this.adora+
	    "\nNúmero de cola: "+this.COLA+
	    (this.recuerdos==null?"":"\nRecuerdos: "+this.recuerdos)+
	    (this.mejorAmigo== null ? "" :"\nMejor amigo: "+this.mejorAmigo.nombre)+
	    (this.exMejorAmigo== null ? "" :"\nEx-mejor Amigo: "+this.exMejorAmigo.nombre)+"\n";
   		 }	

	public static void main(String[] args) {

	//(String perro, String nombre, String raza,String adora)
		Mascota perro1 = new Mascota("perro","Bola de nieve", "Chihuahua","Jugar a la pelota");
		Mascota perro2 = new Mascota("perro","Pelusa","Chihuahua", "Cargarlo ");
		Mascota perro3 = new Mascota("perro","Gauss", "Chihuahua","Bañarse ");
		Mascota perro4 = new Mascota("perro","Picafresa", "Husky","Correr ");
		Mascota perro5 = new Mascota("perro","Timmy", "Husky","Dormir ");
		Mascota perro6 = new Mascota("perro","Lucy", "Husky","Echarse en el sillón ");




		perro1.platicar(perro2);
		perro1.platicar(perro3);
		perro1.platicar(perro4);

		perro2.platicar(perro5);
		perro2.platicar(perro6);
		
		perro3.platicar(perro4);
		perro3.platicar(perro5);

		perro4.platicar(perro1);

		perro5.platicar(perro3);

		perro6.platicar(perro5);


		System.out.println("Los recuerdos de perro1 son: "+perro1.recuerdos);
		System.out.println("Los recuerdos de perro2 son: "+perro2.recuerdos);
		System.out.println("Los recuerdos de perro3 son: "+perro3.recuerdos);
		System.out.println("Los recuerdos de perro4 son: "+perro4.recuerdos);
		System.out.println("Los recuerdos de perro5 son: "+perro5.recuerdos);
		System.out.println("Los recuerdos de perro6 son: "+perro6.recuerdos+"\n");

		System.out.println(perro1);
		System.out.println(perro2);
		System.out.println(perro3);
		System.out.println(perro4);
		System.out.println(perro5);
		System.out.println(perro6);

		//ACTIVIDAD4
		System.out.println("El número total de mascotas es "+NumeroDeMascotas);


		
				
		

	}
}