/**
 * Automovil clasico.
 * @author Emmanuel Cruz
 * @version 1.0 Abril 2020
 */
public class AutoClasico extends Automovil{

    /**
     * Crea un nuevo auto clasico.
     * @param modelo el modelo del auto.
     */
    public AutoClasico(String modelo){
	super(modelo);
    }

    @Override
    public void tipo(){
	System.out.println("Soy un auto clasico");
    }
}
