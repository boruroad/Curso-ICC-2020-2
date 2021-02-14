/**
 * Representacion de una mascota.
 * @author Emmanuel Cruz Hernandez.
 * @version 1.0 Abril 2020.
 */
public class Mascota{
	
    /** Nombre. */
    public String nombre;

    /** Duenio. */
    public String duenio;

    /**
     * Crea una nueva mascota.
     * @param nombre el nombre de la mascota.
     * @param duenio el duenio de la mascota.
     */
    public Mascota(String nombre, String duenio){
	this.nombre = nombre;
	this.duenio = duenio;
    }

    /**
     * Hace hablar a una mascota.
     */
    public String habla(){
	return "Estoy hablando... Yuju!!";
    }

    public static void main(String[] args) {
	Mascota michi = new Gato("Michi", "Luis");
	Mascota scooby = new Chihuahua("Scooby", "Shaggy");
		
	System.out.println(michi.nombre+": "+michi.habla());
	System.out.println(scooby.nombre+": "+scooby.habla());
		
	System.out.println("\n"+scooby.nombre+" es una Mascota? "+(scooby instanceof Mascota));
	System.out.println(scooby.nombre+" es un Perro? "+(scooby instanceof Perro));
	System.out.println(scooby.nombre+" es un Chiuahua? "+(scooby instanceof Chihuahua));
	System.out.println(michi.nombre+" es un Perro? "+(michi instanceof Perro));

	Chihuahua c = (Chihuahua) scooby;
	c.imprimeNombres();
    }
}
