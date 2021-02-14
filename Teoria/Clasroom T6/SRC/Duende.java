 /**
 * Representacion de un duende.
 * @author Adrian Boilla Ruiz
 * @version 1.0 Mayo 2020
 */
 import java.util.Random;

public class Duende extends Personaje{
    Random g  = new Random();
    int cuentaHechizos=0;
    int danios=0;    
    int thanos=0;


	
     /**
     * Crea un nuevo personaje.
     * @param nombre el nombre del Mago.
     * @param vida vida del Mago.
     * @param vivo si esta o no vivo el personaje
     */
    public Duende(String nombre){
	super(nombre);
    }

     /**metodo "dobleDanio”, el cual arroja un numero 0 o 2
     si es 1, el daño es entre 15 y 20, si es 2 el daño de duplica contra 
     la vida a su oponente,*/
    public void dobleDanio(Personaje atacado){
        int jugada = g.nextInt(2)+1;
        int danio = g.nextInt(21-5)+5;
        if(jugada==1){
            atacado.pierdeVida(danio);
            System.out.println("Quitamos "+danio+" de vida a "+atacado.getNombre());

        }

         if(jugada==2){
            atacado.pierdeVida((danio*2));
            System.out.println("Quitamos "+(danio*2)+" de vida a "+atacado.getNombre());

        }
        danios++;
    }

    /**metodo ”chasquido” que podra restar entre 0 a 5 puntos de vida al
    su oponente*/
    public void chasquido(Personaje atacado){
        int numero = g.nextInt(6) + 1;
        atacado.pierdeVida(numero);
        System.out.println("Quitamos "+numero+" de vida a "+atacado.getNombre());

        thanos++;
    }

     /**por cada 4 chasquidos  y por cada 5 ataques dobleDanio
    nuestro personaje recupera un cierto puntaje de vida*/
    @Override
    public void masVida(){    
        if(thanos==4){
            System.out.println("\nCombo \"chasquido\" x4 -----> vida aumentada +20");
    
            this.vida +=20;
            thanos=0;
        }

        if(danios==5){
            System.out.println("\nCombo \"doble daño\" x5 -----> vida aumentada +10 ");
            this.vida +=10;
            danios=0;
        }

    }

    /** método que dado un numero entre 0 y 10, si el
        numero es igual a 10 entonces nuestro personaje
        recuperará el 15% de su vida total.*/
    @Override
    public void bono(){
        int numero = g.nextInt(11);
        if(numero==8){
            System.out.println("\nnum.8 ----->  Bono vida aumentada 15%\n\n");
    
            this.vida+=this.vida/15;
        }

    }


    /**Método que mezcla los diferentes ataques de un duende
     dado un numero aleatorio entre 
     0 y 1*/
    @Override
    public void ataca(Personaje atacado){   
        int dado = g.nextInt(2);
        if(dado==0){
            System.out.println("\nDuende "+this.nombre+" aplicó \"doble daño\" a "+atacado.getNombre());
            this.dobleDanio(atacado);
        }else{
            System.out.println("\nDuende "+this.nombre+" aplicó \"chasquido\", dañó a "+atacado.getNombre());
            this.chasquido(atacado);           
        }

        this.bono();
        this.masVida();
        //this.alive();
//        System.out.println(atacado);
    }
   
   
}
