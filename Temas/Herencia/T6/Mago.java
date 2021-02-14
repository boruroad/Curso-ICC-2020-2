 /**
 * Representacion de un mago.
 * @author Adrian Boilla Ruiz
 * @version 1.0 Mayo 2020
 */
 import java.util.Random;

public class Mago extends Personaje{
    Random g  = new Random();
	int cuentaEncantos=0;
    int cuentaVuelos=0;    

     /**
     * Crea un nuevo personaje.
     * @param nombre el nombre del Mago.
     * @param vida vida del Mago.
     * @param vivo si esta o no vivo el personaje
     */
    public Mago(String nombre){
	super(nombre);
    }

    /**metodo "encantar”, el cual restará entre 20 puntos
     de vida a su oponente,*/
    public void encantar(Personaje atacado){
        int encanto = atacado.getVida()-20;
        atacado.setVida(encanto);
        System.out.println("Quitamos "+encanto+" de vida a "+atacado.getNombre());

        cuentaEncantos++;
    }

    /**metodo "volar”, el cual restará entre 5 a 10 puntos
     de vida a su oponente,*/
    public void volar(Personaje atacado){
        int numero = g.nextInt(11-5)+5;
        int vuela = atacado.getVida()-numero;
        atacado.setVida(vuela);
        System.out.println("Quitamos "+vuela+" de vida a "+atacado.getNombre());

        cuentaVuelos++;
    }

    /**por cada 5 ataques "encantar” y por cada 2 ataques "volar"
    nuestro personaje recupera un cierto puntaje de vida*/
    @Override
    public void masVida(){    
        if(cuentaEncantos == 5){
            System.out.println("\nCombo \"encantar\" x5 -----> vida aumentada +30 ");
            this.vida+=30;
            cuentaEncantos = 0;
        }

        if(cuentaVuelos == 2){
            System.out.println("\nCombo \"volar\" x2 -----> vida aumentada +10 ");
            this.vida+=10;
            cuentaVuelos=0; 
        }
    }

    /** método que dado un numero entre 0 y 10, si el
    numero es igual a 6 entonces nuestro personaje
    recuperará el 15% de su vida total.*/
     @Override
     public void bono(){
        int numero = g.nextInt(11);
        if(numero==6){
            System.out.println("\nnum.6 ----->  Bono vida aumentada 15% ");

            this.vida+=this.vida/15;
        }

    }

    /**Método que mezcla los diferentes ataques de un
     Mago dado un numero aleatorio entre 
     0 y 1*/
     @Override
     public void ataca(Personaje atacado){   
        int dado = g.nextInt(2);
        if(dado==0){
            System.out.println("\nMago "+this.nombre+" aplicó \"encantar\" a "+atacado.getNombre());
            this.encantar(atacado);
        }else{
             System.out.println("\nMago "+this.nombre+"  aplicó \"volar\" a "+atacado.getNombre());
            this.volar(atacado);            
        }

        this.bono();
        this.masVida();
        //this.alive();
        //System.out.println(atacado);

    }
}
