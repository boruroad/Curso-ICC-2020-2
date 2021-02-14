/**
 * Representacion de un perrito.
 * @author Emmanuel Cruz Hernandez
 * @version 1.0 Abril 2020.
 */
public class Perro extends Mascota{

    /** Variable nombre en la clase Perro. */
    public String nombre = "Nombre clase Perro";

    /**
     * Crea un nuevo perro.
     * @param nombre el nombre del perro.
     * @param duenio el duenio del perro.
     */
    public Perro(String nombre, String duenio){
	super(nombre, duenio);
    }

    @Override
    public String habla(){
	return "Wau wau wau";
    }
}
