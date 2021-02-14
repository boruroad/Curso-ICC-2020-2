/**
 * Clase que simula una casa.
 * @author Pedro Ulises Cervantes González
 * @version 1.0
 */

public class Casa extends Construccion{

	/** Atributo que nos da la posición donde será construida la casa */
	protected int posicion;


	/**
	 * CONSTRUCTOR. Construye una nueva casa.
	 * @param zona donde será construida la casa.
	 * @param posicion donde será construida la casa.
	 */
	public Casa (ZonaConstruccion zona, int posicion){
		super(zona);
		this.precioBase = 500000;
		this.posicion = posicion;
		zona.construcciones[posicion] = this;
	}

	@Override
	protected  void recalculaPrecioActual() {
	/* Código cuando la casa se contruye en la posicion 1 */
		//Si a lado de la casa hay terreno baldío.
		if ((posicion == 0) && ((zona.construcciones[posicion + 1] instanceof Casa) == false)) {
			double caso1Baldio = this.precioBase * (0.90);
			System.out.println("A un lado hay un terreno baldío. Costo -10%");
			setPrecioActual(caso1Baldio);
		}

		//Si a lado de la casa hay otra construcción.
		if ((posicion == 0) && ((zona.construcciones[posicion + 1] instanceof Casa) == true)) {
			double caso1_Baldio = this.precioBase +(precioBase*0.15);
			System.out.println("A un lado hay una construcción. Costo +15%");
			setPrecioActual(caso1_Baldio);
		}

	/* Código cuando la casa se contruye en la última posición */
		//Si a lado de la casa hay terreno baldío.
		if ((posicion == zona.construcciones.length-1) && ((zona.construcciones[posicion - 1] instanceof Casa) == false)) {
			double caso2Baldio = this.precioBase * (0.90);
			System.out.println("A un lado hay un terreno baldío. Costo -10%");
			setPrecioActual(caso2Baldio);
		}

		//Si a lado de la casa hay otra construcción.
		if ((posicion == zona.construcciones.length-1) && ((zona.construcciones[posicion - 1] instanceof Casa) == true)) {
			double caso2_Baldio = this.precioBase + (precioBase * 0.15);
			System.out.println("A un lado hay una construcción. Costo +15%");
			setPrecioActual(caso2_Baldio);
		}

	/* Código cuando la casa se contruye en una posición que no es la primera o la última */
		//Si a los lados de la casa hay dos terrenos baldíos.
		if((posicion > 0) && (posicion < zona.construcciones.length-1)){
			boolean entreDos = false;
			if ((zona.construcciones[posicion - 1] instanceof Casa) == false){
				if(entreDos == (zona.construcciones[posicion + 1] instanceof Casa)){
					double caso3Baldio = this.precioBase * (0.75);
					System.out.println("Está entre dos terrenos baldíos. Costo -25%");
					setPrecioActual(caso3Baldio);
				}
			}
		}

		//Si a los lados de la casa NO hay dos terrenos baldíos.
		if((posicion > 0) && (posicion < zona.construcciones.length-1)){
			boolean entreDos = true;
			if ((zona.construcciones[posicion - 1] instanceof Casa) == true){
				if(entreDos == (zona.construcciones[posicion + 1] instanceof Casa)){
					double caso3_Baldio = this.precioBase + (precioBase * 0.15);
					System.out.println("A un lado hay dos construcción. Costo +15%");
					setPrecioActual(caso3_Baldio);
				}
			}
		}

		//Si a los lados de la casa hay un terreno baldío enfrente y una construcción atrás
			if((posicion > 0) && (posicion < zona.construcciones.length-1)){
				boolean entreDos = true;
				if ((zona.construcciones[posicion - 1] instanceof Casa) == false){
					if(entreDos == (zona.construcciones[posicion + 1] instanceof Casa)){
						double caso31_Baldio = this.precioBase * (0.90);
						System.out.println("A un lado hay un terreno baldío y en el otro no. Costo -10%");
						setPrecioActual(caso31_Baldio);
					}
				}
			}

		//Si a los lados de la casa hay un terreno baldío atrás y una construcción enfrente.
		if((posicion > 0) && (posicion < zona.construcciones.length-1)){
			boolean entreDos = false;
			if ((zona.construcciones[posicion - 1] instanceof Casa) == true){
				if(entreDos == (zona.construcciones[posicion + 1] instanceof Casa)){
					double caso32_Baldio = this.precioBase * (0.90);
					System.out.println("A un lado hay un terreno baldío y en el otro no. Costo -10%");
					setPrecioActual(caso32_Baldio);
				}
			}
		}
	}


	@Override
	public String[] toStringArray(){
	String[] array=new String[8];

	array[7]= "  ______  ";
	array[6]= " /      \\ ";
	array[5]= "/________\\";
	array[4]= "|        |";
	array[3]= "| _  [][]|";
	array[2]= "|| | [][]|";
	array[1]= "||•|     |";
	array[0]= "TTTTTTTTTT";
	return array;
	}
}
