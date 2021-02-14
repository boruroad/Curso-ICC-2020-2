/**
 * Tarea 6
 * @author Adrian Bonilla Ruiz.
 * @version 1.0 Mayo 2020.
 */
public abstract class Personaje{
	
    /** Nombre. */
    protected String nombre;

    /** Vida */
    protected int  vida=100;

    /** Saber si esta vivo . */
    protected boolean vivo;

    /**
     * Crea una nuev personaje.
     * @param nombre el nombre del personaje.
     * @param vida la vida de la persona.
     * @param vivo saber si el personaje esta vivo
     */

    public Personaje(String nombre){
	   this.nombre = nombre;
    }
    
    /** Métodos de acceso */
    public String getNombre(){
        return this.nombre; 
    }

    public int getVida(){
        return this.vida;
    }

    public boolean getVivo(){
        return this.vivo;
    }

    /**Métodos modificadores */
 
    public void setVida(int vida){
        this.vida =vida;
    }

    public void setVivo(){
        this.vivo=vivo;
    }

    /* 
     * Hace que un personaje pierda vida. 
     */
    public void pierdeVida(int n){
        this.vida = vida - n;
    }


    /**
     * Hace que un personaje ataque.
     */
    public void ataca(Personaje atacado){    
    }

    /**
     * Hace que un personaje aumente su vida.
     */
    public void masVida(){    
    }

    /**
     * Hace que un personaje aumente su vida. por bonificación
     */
    public void bono(){    
    }
  
    @Override
    public String toString() {
        return "\nNombre: "+this.nombre+ "\nVida: "+this.vida;
    }





   
}
