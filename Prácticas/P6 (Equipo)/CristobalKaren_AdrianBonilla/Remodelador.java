import java.util.Scanner;
/**
 * Practica 6: Herencia.
 * Ésta clase "Remodelador" extiende a la clase "Trabajador".
 * El remodelador tiene distinta forma de trabajar respecto a los otros trabajadores.
 * Trabaja únicamente con edificios, puede aumentan o quitar plantas a un edificio.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Remodelador extends Trabajador {

    @Override
    public boolean puedeTrabajar(ZonaConstruccion zona, int posicion){
        return zona.construcciones[posicion-1] instanceof Edificio;
    }

    @Override
    public void trabaja (ZonaConstruccion zona, int numLotes){

       Scanner sc = new Scanner(System.in);
        System.out.println("\nSelecciona la  posicion del edificio que deseas modificar: ");
        System.out.print("Posicion: ");

         /* Robustez para el programa */
		while(!sc.hasNextInt()){
			System.out.println("\n¡¡ Sólo se acepta números !!\n");
			sc.next();
			System.out.print("Posicion: ");
		}
        int posicion = sc.nextInt();
		while(posicion < 1 || posicion > numLotes){
			System.out.println("\n¡¡¡ Opción inválida !!!\n");
			System.out.print("Posicion: ");
			while(!sc.hasNextInt()){
				System.out.println("\n¡¡ Sólo se acepta números !!\n");
				sc.next();
				System.out.print("Posicion: ");
			}
			posicion = sc.nextInt();
		}


        if(this.puedeTrabajar(zona, posicion)){
            System.out.println(zona);
            System.out.println("\n¿Qué desea hacer?\n");
            System.out.println("[1] ---> Aumentar una planta al edificio");
            System.out.println("[2] ---> Eliminar una planta al edificio");
            System.out.print("\nOpción: ");

            /* Robustez para el programa */
		    while(!sc.hasNextInt()){
		    	System.out.println("\n¡¡ Sólo se acepta números !!\n");
		    	sc.next();
		    	System.out.print("Opción: ");
		    }
		    int eleccion = sc.nextInt();

		    while(eleccion != 1 && eleccion != 2){
		    	System.out.println("\n¡¡¡ Opción inválida !!!\n");
		    	System.out.print("Opción: ");
		    	while(!sc.hasNextInt()){
		    		System.out.println("\n¡¡ Sólo se acepta números !!\n");
		    		sc.next();
		    		System.out.print("Opción: ");
		    	}
		    	eleccion = sc.nextInt();
		    }


		    Edificio modificado = (Edificio) zona.construcciones[posicion-1];
            switch(eleccion){
                case 1:
                    System.out.println("¿Cuántos pisos deseas añadir al edificio ?");

                    System.out.print("Pisos: ");

                    /* Robustez para el programa */
		            while(!sc.hasNextInt()){
		            	System.out.println("\n¡¡ Sólo se acepta números !!\n");
		            	sc.next();
		            	System.out.print("Pisos: ");
		            }
		            int pisos = sc.nextInt();

		            while(pisos < 1){
                  System.out.println("\n¡¡¡ Opción inválida !!!\n El remodelador no destruye pisos cero o negativos\n");

		            	System.out.print("Pisos: ");
		            	while(!sc.hasNextInt()){
		            		System.out.println("\n¡¡ Sólo se acepta números !!\n");
		            		sc.next();
		            		System.out.print("Pisos: ");
		            	}
		            	pisos = sc.nextInt();
		            }

                    modificado.setAumentaPisos(pisos);

                    //ganancias
                    double pagoRem1 = 120000;
      			        this.ganancias += 120000;
      			        System.out.println("El remodelador ha cobrado $" + pagoRem1 + " por destruir una planta al edificio");
                    pagoRem1 += this.ganancias;
                    System.out.println("Ganacias del remodelador: " + this.ganancias +"\n");
//                    System.out.println(zona);

                    System.out.println("\nDATOS DEL EDIFICIO: ");
//EXPERIMENTO
                    modificado.recalculaPrecioActual();
                    System.out.println(modificado);
                    System.out.println("Costo devaluado + planta ($200000 agregado por planta)\n$"+modificado.getPrecioActual());
                    System.out.println(zona);

                break;

                case 2:
                    System.out.println("¿Cuántos pisos eliminar añadir al edificio ?");
                    System.out.print("Pisos: ");

                /* Robustez para el programa */
		            while(!sc.hasNextInt()){
		            	System.out.println("\n¡¡ Sólo se acepta números !!\n");
		            	sc.next();
		            	System.out.print("Pisos: ");
		            }
		            int pisos1 = sc.nextInt();


		            while(pisos1 < 1){
		            	System.out.println("\n¡¡¡ Opción inválida !!!\n El remodelador no destruye pisos cero o negativos\n");
		            	System.out.print("Pisos: ");
		            	while(!sc.hasNextInt()){
		            		System.out.println("\n¡¡ Sólo se acepta números !!\n");
		            		sc.next();
		            		System.out.print("Pisos: ");
		            	}
		            	pisos1 = sc.nextInt();
		            }

                int aux1 = modificado.getAumentaPisos();
                ///////
                while(pisos1 > aux1){
		            	System.out.println("\n¡¡¡ El remodelador no puede quitar pisos al edificio inicial !!!\n");
		            	System.out.print("Pisos: ");
		            	while(!sc.hasNextInt()){
		            		System.out.println("\n¡¡ Sólo se acepta números !!\n");
		            		sc.next();
		            		System.out.print("Pisos: ");
		            	}
		            	pisos1 = sc.nextInt();
		            };
              //////

                modificado.setAumentaPisos((-1*pisos1));
                System.out.println(zona);

                //ganancias
                double pagoRem2 = 60000;
  			        this.ganancias += 60000;
  			        System.out.println("El remodelador ha cobrado $" + pagoRem2 + " por destruir una planta al edificio");
  			        pagoRem2 += this.ganancias;
                System.out.println("Ganacias del remodelador: " + this.ganancias +"\n");

//EXPERIMENTO
                System.out.println("\nDATOS DEL EDIFICIO: ");

                modificado.recalculaPrecioActual();
                System.out.println(modificado);
                System.out.println("Costo devaluado + planta ($200000 eliminado por planta)\n$"+modificado.getPrecioActual());
                System.out.println(zona);



                break;
            }
        }else{
			System.out.println("\nEl remodelador no puede trabajar aqui :C");
		}


    }


}
