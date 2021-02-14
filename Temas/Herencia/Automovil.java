/**
 * Clase que representa un coche.
 * @author Emmanuel Cruz Hernandez.
 * @version 1.0 Abril 2020.
 */
public abstract class Automovil{
	
    /** Modelo del automovil. */
    public String modelo;

    /**
     * Crea un nuevo automovil.
     * @param modelo el modelo del automovil.
     */
    public Automovil(String modelo){
	this.modelo = modelo;
    }

    /**
     * Corre el coche.
     */
    public void corre(){
	System.out.println(modelo+": Raaannnnn");
    }

    /**
     * Dice el tipo del coche.
     */
    public abstract void tipo();

    public static void main(String[] args) {
	Automovil auto = new AutoDeportivo("Civic");
	Automovil auto2 = new AutoClasico("Bochito");
	auto.corre();
	auto.tipo();
	auto2.corre();
	auto2.tipo();
    }
}
