/**
 * Representacion de un Guerrero
 * @author Adrian Bonilla Ruiz.
 * @version 1.0 Mayo 2020.
 */
import java.util.Random;

public class Guerrero extends Personaje{
    Random g  = new Random();
    int contadorCombate=0;
    int contadorCabalga=0;
    

    /**
     * Crea un nuevo personaje.
     * @param nombre el nombre del Guerrero.
     * @param vida vida del Guerrero.
     * @param vivo si esta o no vivo el personaje
     */

    /*Método constructor*/
    public Guerrero(String nombre){
	super(nombre);
    }

    /**metodo ”combatir”, el cual restará entre 5 a 15 puntos
     de vida a su oponente,*/
    public void combatir(Personaje atacado){
        int numero = g.nextInt(16-5)+5;
        atacado.pierdeVida(numero);
        System.out.println("Quitamos "+numero+" de vida a "+atacado.getNombre());
        contadorCombate++;
    }

    /**por cada 4 ataques ”combatir” y por cada 5 ataques ”cabalgar”
        nuestro personaje recupera un cierto puntaje de vida*/
    @Override
    public void masVida(){    
        if(contadorCombate==4){
            System.out.println("\nCombo \"combate\" x4 -----> vida aumentada +30 ");
            this.vida +=30;
            contadorCombate=0;
        }

        if(contadorCabalga==5){
            System.out.println("\nCombo \"cabalga\" x5 -----> vida aumentada +10 ");

            this.vida +=10;
            contadorCabalga=0;
        }

    }

    /**metodo ”cabalgar” que podra restar entre 10 a 15 puntos de vida al
    su oponente*/
    public void cabalgar(Personaje atacado){
        int numero = g.nextInt(16-10)+10;
        atacado.pierdeVida(numero);
        System.out.println("Quitamos "+numero+" de vida a "+atacado.getNombre());
        contadorCabalga++;

    }

    /** método que dado un numero entre 0 y 10, si el
        numero es igual a 8 entonces nuestro personaje
        recuperará el 10% de su vida total.*/
    @Override
    public void bono(){
        int numero = g.nextInt(11);
        if(numero==8){
            System.out.println("\nnum.8 ----->  Bono vida aumentada 10%");

            this.vida+=this.vida/10;
        }

    }

    /**Método que mezcla los diferentes ataques de un Guerrero dado un numero aleatorio entre 
     0 y 1*/
    @Override
    public void ataca(Personaje atacado){   
        int dado = g.nextInt(2);
        if(dado==0){
            System.out.println("\nGuerrero "+this.nombre+" aplicó \"combatir\" a "+atacado.getNombre());
            this.combatir(atacado);
        }else{
            System.out.println("\nGuerrero "+this.nombre+" aplicó \"cabalgar\" a "+atacado.getNombre());
            this.cabalgar(atacado);            
        }

        this.bono();
        this.masVida();
        //this.alive();
        //System.out.println(atacado);

    }









}
