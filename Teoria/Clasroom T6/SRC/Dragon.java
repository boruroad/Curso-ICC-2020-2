 /**
 * Representacion de un dragón.
 * @author Adrian Boilla Ruiz
 * @version 1.0 Mayo 2020
 */
 import java.util.Random;

public class Dragon extends Personaje{
        Random g  = new Random();
        int cuentaQuemones = 0;    
        int cuentaGolpes =0;
	
     /**
     * Crea un nuevo personaje.
     * @param nombre el nombre del Mago.
     * @param vida vida del Mago.
     * @param vivo si esta o no vivo el personaje
     */
    public Dragon(String nombre){
	super(nombre);
    }

   /**metodo "quemar”, el cual restará entre 0 y 20 puntos
     de vida a su oponente,*/
    public void quemar(Personaje atacado){
        int numero = g.nextInt(21);
        atacado.pierdeVida(numero);
        System.out.println("Quitamos "+numero+" de vida a "+atacado.getNombre());

        cuentaQuemones++;
    }

    /**metodo "golpeDeCola", el cual restará entre 10 y 20 puntos
    de vida a su oponente,*/
    public void golpeDeCola(Personaje atacado){
        int numero = g.nextInt(21-10)+10;
        atacado.pierdeVida(numero);
        System.out.println("Quitamos "+numero+" de vida a "+atacado.getNombre());
        cuentaGolpes++;
    }

    /**por cada 5 ataques "quemar” y por cada 8 ataques "golpeDeCola"
    nuestro personaje recupera un cierto puntaje de vida*/
    @Override
    public void masVida(){    
        if(cuentaQuemones == 5){
            System.out.println("\nCombo \"quemar”\" x5 -----> vida aumentada +20");
            this.vida+=20;
            cuentaQuemones = 0;
        }

        if(cuentaGolpes == 8){
            System.out.println("\nCombo \"golpeDeCola\" x8 -----> vida aumentada +35");

            this.vida+=35;
            cuentaGolpes=0; 
        }
    }


    /** método que dado un numero entre 0 y 15, si el
    numero es igual a 13 entonces nuestro personaje
    recuperará el 30% de su vida total.*/
    @Override
    public void bono(){
        int numero = g.nextInt(16);
        if(numero==13){
        System.out.println("\nnum.13 ----->  Bono vida aumentada 30% \n\n");
            this.vida+=this.vida/30;
        }

    }

      /**Método que mezcla los diferentes ataques de un Dragón dado un numero aleatorio entre 
     0 y 1*/
    @Override
    public void ataca(Personaje atacado){   
        int dado = g.nextInt(2);
        if(dado==0){
            System.out.println("\nDragón "+this.nombre+" aplicó \"quemar\" a "+atacado.getNombre()+" ");
            this.quemar(atacado);
        }else{
            System.out.println("\nDragón "+this.nombre+" aplicó \"golpe de cola\" a "+atacado.getNombre());
            this.golpeDeCola(atacado);            
        }
        this.bono();
        this.masVida();
       // this.alive();
//        System.out.println(atacado);
    }


   

   
}
