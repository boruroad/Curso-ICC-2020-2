import java.util.Scanner;

public class Carrera {
    private int premios;
    private boolean haTerminado;

    private class Competidor extends Thread {
        private String nombre;
        private Carrera carrera;
        private int premios;

        public Competidor(Carrera carrera, String nombre) {
            super("Hilo de " + nombre);
            this.nombre = nombre;
            this.carrera = carrera;
        }

        @Override
        public void run() {
            while (!carrera.haTerminado() && premios < 5) {
                if (carrera.tomaPremio()) {
                    System.out.println(nombre + " obtuvo un premio.");
                    premios++;
                }
            }
            System.out.println(nombre + " se retira, ganó " + premios + " premios");
        }
    }

    public boolean haTerminado() {
        return haTerminado;
    }

    public boolean hayPremios() {
        return premios > 0;
    }

    public synchronized boolean tomaPremio() {
        try {
            while (!haTerminado && !hayPremios()) {
                wait();
            }
        } catch (InterruptedException e) {
            System.err.println(">>> Fue interrumpido: " + Thread.currentThread().getName());
            return false;
        }
        premios--;
        return true;
    }

    public synchronized void agregaPremios(int premiosNuevos) {
        premios += premiosNuevos;
        notifyAll();
    }

    public void inicia(String[] nombres) {
        Competidor[] competidores = new Competidor[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            competidores[i] = new Competidor(this, nombres[i]);
        }
        for (Competidor competidor : competidores) {
            competidor.start();
        }
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("Ingresa la cantidad de premios nuevo o 0 para salir: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                System.out.println();
                if(opcion ==0){
                    for (Competidor competidor : competidores) {
                         competidor.stop();
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("***Ingresa un número***\n");
            }
            if (opcion > 0) {
                agregaPremios(opcion);
            }
        } while (opcion != 0);
        haTerminado = true;
    }

    public static void main(String[] args) {
        Carrera ejemplo = new Carrera();
        String[] competidores = { "Pedro", "Juan", "Pablo", "Santiago", "Judas" };
        ejemplo.inicia(competidores);
    }
}

/**
1.Explica qué líneas del código están haciendo que el programa no se detenga al oprimir 0

    Respuesta = En el método "inicia" el for-each de los competidores, es lo que inicia a los competidores, pero en el menú si nosotros 
                ponemos la opcion cero en la primera ejecucion del programa, el progrma se sigue y no se detiene porque los hilos aun siguen "activos"
                pues ya fueron iniciados por .start(); entonces auqnue crearamos una opcion que se salga del menú, si nosotros no detenemos a los competidores 
                el programa no se va a salir. (el for-each es el de la línea 61 y donde no se sale ni si quiera poniendo el cero es en el menú 
                línea 69 (antes de hacer las modificaciones))

2- Adjunta el código corregido para manejar el caso en que se oprime 0 sin que los competidores hayan obtenido sus premios. No modifiques la lógica del programa (hacer que la carrera nunca inicie, darle premios sin que hayan competido, etc).

3- Explica cuáles son la modificaciones que hiciste y por qué funciona tu solución.

    Respuesta = Lo que yo hice fue usar el for-each que se usó para iniciar a los competidores pero aplicado al revés 
                (es decir en vez de usar el método .start(), cambiarlo por .stop()) y eso lo añadi en la parte del menú donde si la opcion era
                igual a cero, entonces todos los hilos se detenian lohgrando asi que el progrma se detuviera :)

Asi el programa ahora ya funciona debido a que dividimos los casos dependiendo de la opcion que seleccionara el usuario */ 

