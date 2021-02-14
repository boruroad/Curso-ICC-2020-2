public class CocheDeCarreras extends Thread{

	public int id;
	public int distancia;


	public CocheDeCarreras(int id, int distancia){
		this.id = id;
		this.distancia = distancia;

	}

	@Override
	public void run(){
		for(int i=0; i<distancia; i+=5){
			try{
				Thread.sleep(100); //NANO-SEGUNDOS //menos número más velocidad (y viceversa)
				System.out.println("Soy el coche: "+ id+ " Distancia: "+i);

			} catch(Exception e){};
		}
		System.out.println("\nSoy el coche "+ id + " y llegué a la meta\n");
	}


	public static void main(String[] args) {
		CocheDeCarreras c1= new CocheDeCarreras(1,500);
		CocheDeCarreras c2= new CocheDeCarreras(2,500);
		CocheDeCarreras c3= new CocheDeCarreras(3,500);


		c1.start();
		c2.start();
		c3.start();
		

	}

}