/**
 * Automovil deportivo.
 * @author Emmanuel Cruz
 * @version 1.0 Abril 2020
 */
public class AutoDeportivo extends Automovil{

    /**
     * Crea un nuevo auto deportivo.
     * @param modelo el modelo del auto.
     */
    public AutoDeportivo(String modelo){
	super(modelo);
    }

    @Override
    public void tipo(){
	System.out.println("Soy un auto deportivo");
    }
}
