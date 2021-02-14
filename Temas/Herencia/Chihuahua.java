/**
 * Representacion de un perrito chihuahua.
 * @author Emmanuel Cruz Hernandez
 * @version 1.0 Abril 2020.
 */
public class Chihuahua extends Perro{

    /** Variable nombre en la clase Chiuahua. */
    public String nombre = "Nombre clase Chiuahua";
	
    /**
     * Crea un nuevo chiuahua.
     * @param nombre el nombre del chiuahua.
     * @param duenio el duenio del chiuahua.
     */
    public Chihuahua(String nombre, String duenio){
	super(nombre,duenio);
    }

    public void imprimeNombres(){
	System.out.println("\nNombre: "+this.nombre);
	System.out.println("Nombre (padre): "+super.nombre);
	System.out.println("Nombre (abuelo): "+((Mascota)this).nombre);
    }

}
