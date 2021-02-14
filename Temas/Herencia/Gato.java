/**
 * Representacion de un michi.
 * @author Emmanuel Cruz Hernandez
 * @version 1.0 Abril 2020
 */
public class Gato extends Mascota{
	
    /**
     * Crea un nuevo gato.
     * @param nombre el nombre del gato.
     * @param duenio el duenio del gato.
     */
    public Gato(String nombre, String duenio){
	super(nombre, duenio);
    }

    @Override
    public String habla(){
	return "Meow meow meow";
    }
}
