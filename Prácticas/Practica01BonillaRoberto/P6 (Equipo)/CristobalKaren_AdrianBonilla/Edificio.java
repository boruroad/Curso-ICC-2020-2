/**
 * Practica 6: Herencia.
 * Ésta clase "Edificio" extiende a la clase "Clase".
 * El edificio tiene distinta forma de construcción respecto a una casa.
 * EL precio base y actual del edificio cambian de acuerdo a su zona y cantidad de pisos.
 *
 * @author Bonilla Ruíz Roberto Adrián.
 * @author Cristóbal Morales Karen.
 * @version 1.0
 */

public class Edificio extends Casa{

  public int aumentaPisos = 0;

    /**
	   * CONSTRUCTOR. Construye una nueva casa.
	   * @param zona donde será construida la casa.
	   * @param posicion donde será construida la casa.
	   */
    public Edificio (ZonaConstruccion zona, int posicion){
      super(zona,posicion);
      this.precioBase = 600000;
    }

        //EXPERIMENTO
        @Override
        public double getPrecioActual(){
          this.precioActual +=(aumentaPisos*200000);
    	  	return this.precioActual;
        }

        //EXPERIMENTO
        //@Override
      	//public void setPrecioActual(double precioActual){
      	//	super.(precioActual);
      //	}

        public int getAumentaPisos(){
            return this.aumentaPisos;
        }


        public void setAumentaPisos(int aumentaPisos){
            this.aumentaPisos += aumentaPisos;
      }

        @Override
        protected void recalculaPrecioActual(){
            super.recalculaPrecioActual();

            //this.getPrecioActual()*(200000*aumentaPisos);
        }

        @Override
        public String[] toStringArray(){
            String[] array = new String[8 + aumentaPisos*2];

            array[7 + aumentaPisos*2]="___________";
            for (int i = 7; i < 7 + aumentaPisos*2; i+=2){
            array[i]   = "|  _____  |";
            array[i+1] = "| |__|__| |";
            }
            array[6]= "|  _____  |";
            array[5]= "| |__|__| |";
            array[4]= "|  _____  |";
            array[3]= "| |__|__| |";
            array[2]= "|    __   |";
            array[1]= "|   |• |  |";
            array[0]= "TTTTTTTTTTT";
            return array;


    }
}
