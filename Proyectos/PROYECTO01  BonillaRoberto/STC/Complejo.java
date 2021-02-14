/** Implementar la clase Complejo con su interfaz ServiciosCompleo
 *
 * @author Bonilla Ruiz Roberto Adrián
 */

import java.lang.Math;

public class Complejo implements ServiciosComplejo{
    
    //Creamos los atributos de la clase Complejo
    private double real;
    private double imaginario;            
    
    //Método constructor con parámetros vacio 
    public Complejo(){
       
    }
    
    //Método constructor con parámetros de tipo double
    public Complejo(double real, double imaginario){
        this.real=real;
        this.imaginario=imaginario;
    }
    

    //Métodos de Acceso (getters)
    public double getReal(){
        return  this.real;
        
    }
    
    public double getImaginario(){
       return this.imaginario;
    }

    //Métodos modificadore (setters)
    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }
    

    //Los métodos de la interfaz ServiciosComplejos a implementar
    @Override
    public Complejo suma(Complejo otro) {
        double sumaReal = this.real + otro.getReal();
        double sumaImaginario = this.imaginario + otro.getImaginario();
        return new Complejo(sumaReal, sumaImaginario);
    }

    @Override
    public Complejo multiplica(Complejo otro){
        double multiplicaReal = this.real * otro.getReal() - 
        this.getImaginario() * otro.getImaginario();
        
        double multiplicaImaginario = this.real * otro.getImaginario() +
                this.imaginario * otro.getReal();
              
        return new Complejo(multiplicaReal, multiplicaImaginario);
    }

    @Override
    public Complejo cuadrado() {
        return this.multiplica(this);
    }

    @Override
    public Complejo cubo() {
        return this.cuadrado().multiplica(this);
    }
    

    @Override
    public Complejo conjugado() {
        return new Complejo(this.real,this.imaginario*(-1));
    }

    @Override
    public Complejo inverso() {
        double base = Math.pow(this.real,2)+Math.pow(this.imaginario,2);
        return new Complejo(this.real/(base), this.imaginario*(-1)/(base)); 
    }

    
    @Override
    public Complejo divide(Complejo otro){
        return this.multiplica(otro.inverso());

    }


    @Override
    public double modulo() {
        return Math.sqrt(Math.pow(this.real,2)+ Math.pow(this.imaginario,2));
    }


    @Override
    public boolean esIgual(Complejo otro) {
        return ((this.real == otro.real) && (this.imaginario == otro.imaginario)) ? true:false;
        
    }

    @Override
    public String muestra() {
        return this.real+ " + "+ this.imaginario+ "i";
    }

    /**Método toString para imprimir los atributos y/o métodos de un objeto 
     * Concatena cadenas
     */
    @Override
    public String toString(){
        return this.real+ " + "+ this.imaginario+ "i";

    }

    // El "main" es el método que se eejecuta del programa
    public static void main(String[] args) {
        Complejo c = new Complejo(1.0,2.0);
        Complejo d = new Complejo(4.0,7.0);

        System.out.println("Imprimiendo nuestros complejos: ");
        System.out.println(c);
        System.out.println(d+"\n");


        //Probando los métodos de la interfaz
        System.out.println("Probando los métodos de la interfaz");

        //Prueba de suma
        System.out.println("Probando el método suma: ");        
        System.out.println(c.suma(d)+"\n");

        //Prueba de multiplica
        System.out.println("Probando el método multiplica: "); 
        System.out.println(c.multiplica(d)+"\n");

        //Prueba de cuadrado
        System.out.println("Probando el método cuadrado: "); 
        System.out.println(c.cuadrado()+"\n");

        //Prueba de cubo
        System.out.println("Probando el método cubo: "); 
        System.out.println(c.cubo()+"\n");

        //Prueba de conjugado 
        System.out.println("Probando el método conjugado: "); 
        System.out.println(c.conjugado()+"\n");

        //Prueba de inverso
        System.out.println("Probando el método inverso: "); 
        System.out.println(c.inverso()+"\n");

        //Prueba de divide
        System.out.println("Probando el método divide: "); 
        System.out.println(c.divide(d)+"\n");

        //Prueba de modulo
        System.out.println("Probando el método modulo: "); 
        System.out.println(d.modulo()+"\n");

        //Prueba de esIgual
        System.out.println("Probando el método esIgual: "); 
        System.out.println(c.esIgual(d)+"\n");

        //Prueba de muestra
        System.out.println("Probando el método muestra: "); 
        System.out.println(c.muestra()+"\n");

        
       
        
    }
    
    
}
