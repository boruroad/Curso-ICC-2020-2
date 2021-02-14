import java.util.Scanner;
import java.util.Random;


public class Jugar {

	public static Personaje seleccionaAleatorio(){
		Random sh =new Random ();
		int numero = sh.nextInt(4)+1;
		Personaje p1 = null;

		switch (numero){

			case 1:
			p1 = new Guerrero("AMPILI");
			System.out.print("\nTu oponente es -----> Guerrero "+p1.getNombre()+"\n");
			////p1.imprimePersonajes();
			break;

			case 2:
			p1 = new Mago("BLAISE");
			System.out.print("\nTu oponente es -----> Mago "+p1.getNombre()+"\n");
			//p1.imprimePersonajes();
			break;

			case 3:
			p1 = new Duende("DOBBY");
			System.out.print("\nTu oponente es  -----> Duende "+p1.getNombre()+"\n");
			//p1.imprimePersonajes();
			break;
			
			case 4:
			p1 = new Dragon("GALAKROND");
			System.out.print("\nTu oponente es -----> Dragón "+p1.getNombre()+"\n");
			//p1.imprimePersonajes();
			break; 		
			}
		return p1;
		
	}

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Random shuffle = new Random();
		int n = shuffle.nextInt(4)+1;
		Personaje player = null;

	
		System.out.println("TAREA 6 ICC \"JUEGO\" \n(Reglas ya especificadas en el código) \n");
		System.out.println("Personajes disponibles, pulsa el número que desees para seleecionar tu personaje:");
			System.out.println("\n  1 -Guerrero "
								+"\n  2 -Mago"
								+"\n  3 -Duende"
								+"\n  4 -Dragón");
	
		System.out.print("\n  Personaje: ");
			while(!s.hasNextInt()){	
				System.out.println("\nOpción Inválida");
				s.next();
				System.out.print("Personaje: ");
			}
			int usuario = s.nextInt();
	
		if(usuario>4 || usuario<1 ){
				while(usuario>4 || usuario<1 ){
					System.out.println("\nIngresa un número que sea parte del menú");	
					System.out.print("Personaje: ");
					while(!s.hasNextInt()){	
						System.out.println("\n Opción Inválida ");	
						System.out.print("Personaje: ");
						s.next();
					}
					usuario = s.nextInt();
				}
			}
		
		switch(usuario){
	
			case 1:
			System.out.print("\nEnhorabuena !!! \nNombra a tu personaje: ");
			String n1 = s.next().toUpperCase();
	    	Personaje azteca = new Guerrero(n1);
	    	player= azteca;
	    	System.out.println(player);
			break;
	
			case 2:
			System.out.print("\nEnhorabuena !!! \nNombra a tu personaje: ");
			String n2 = s.next().toUpperCase();
			Personaje merlin = new Mago(n2);
			player= merlin;
			System.out.println(player);
			break;
	
			case 3:
			System.out.print("\nEnhorabuena !!! \nNombra a tu personaje: ");
			String n3 = s.next().toUpperCase();
			Personaje elfo = new Duende(n3);
			player= elfo;
			System.out.println(player);
			break;
	
	
			case 4:
			System.out.print("\nEnhorabuena !!! \nNombra a tu personaje: ");
			String n4 = s.next().toUpperCase();
			Personaje draco = new Dragon(n4);
			player= draco;
			System.out.println(player);
			break;
		}

		Personaje pc = seleccionaAleatorio();
		while(player.getVida()>0 && pc.getVida()>0){
			int t = shuffle.nextInt(2)+1;
			if(t==1){
				pc.ataca(player);
				
			}else{
				player.ataca(pc);

			}
			System.out.println(pc);
			System.out.println(player);
		}

	        if (player.vida > 0){
	            //System.out.println("\n"+player.getNombre() + " sigue vivo");
	         
	        }else{
				//System.out.println(pc);
	            System.out.println("\nVida de "+player.getNombre()+" = "+player.getVida()+"\n"+player.getNombre()+" ha muerto x_x \n**************************** \nGana: "+pc.getNombre());
	            
	        }

	       	if (pc.vida > 0){
	            //System.out.println("\n"+pc.getNombre() + " sigue vivo");
	         
	        }else{
				//System.out.println(player);
	            System.out.println("\nVida de "+pc.getNombre()+" = "+pc.getVida()+"\n"+pc.getNombre()+" ha muerto x_x \n******************************* \nGana: "+player.getNombre());

	        }

	        
	
	        


        
        





    }

}