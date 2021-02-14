/**Implementar la clase FuncionesDeCadenas con su interfaz AnalizadorDeCadenas
 * @author Bonilla Ruiz Roberto Adrián.
 * @version 1.0
 */

import java.util.Scanner;

public class FuncionesDeCadenas implements AnalizadorDeCadenas{
    
  //Implementamos nuestros métodos 

  public int encuentraPosicion(String cadena, char c){
    for(int i = 0; i < cadena.length(); i++){
      if(cadena.charAt(i) == c){
        return i;
      }
    }
    //En caso de ingresar un carácter que no esté en la cadena, devuelve -1
    return -1;
  }
    
  public boolean esNumero(String cadena){
    int contador = 0;
    boolean b = false;
    for(int i = 0; i < cadena.length(); i++){
      switch(cadena.charAt(i)){

      case '.':
        contador++;
        if(1 < contador){
          return false;
        }

      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':

      b = true;
      break;

      default: 
        return false;
      }
    } 
    return b; 
  }
             
  public String reemplazaCaracter(String cadena, char reemplazado, char reemplazador){
    String nuevo = "";
    for(int i = 0; i < cadena.length(); i++){
      if(cadena.charAt(i) == reemplazado){
        nuevo += reemplazador;
      }else{
        nuevo+= cadena.charAt(i);
      } 
      }
      return nuevo;
  }
            
  public int cuentaCaracter(String cadena, char c){
    int inicio = 0;
    int conta = 0;
    int termina= cadena.length()-1;
    while (inicio < termina){
      inicio++;
      if(c == cadena.charAt(inicio-1)){
        conta++;
      }
    }
    System.out.println("EL carácter \"" +c+" \" aparece " + conta + " veces");
    return conta;
  }
            
  public boolean esPalindromo(String cadena){
    int longitud = cadena.length();
    cadena = cadena.toLowerCase();
    char espacio = ' ';
    String respaldo = "";
    for (int i = 0; i < longitud; i++){
      if(cadena.charAt(i) != espacio){
        respaldo += cadena.charAt(i);
      }
    }
    longitud = respaldo.length();    
    for (int i = 0; i < longitud; i++){
      if(respaldo.charAt(i) != respaldo.charAt(longitud -1 -i))
        return false;
    }
    return true;
  }
            
  public boolean contiene(String cadena, String buscada){
    boolean n =  false;
    for(int i = 0; i < cadena.length(); i++){
      if(cadena.charAt(i) == buscada.charAt(0)){
        if(i + buscada.length() > cadena.length()){
          return false;
        }
        for(int k = 0; k < buscada.length(); k++){
          if(cadena.charAt(i + k) == buscada.charAt(k)){
            n = true;
          }else{
            n = false;
          }
        }
      }
    }
    return n;
  }
            
  public boolean sonIguales(String cadena1, String cadena2){
    cadena1 = cadena1.toLowerCase();
    cadena2 = cadena2.toLowerCase();
       
    //Comparamos la longitud de abas cadenas (si no es la misma, entonces es obvio que no sean iguales)
    if(cadena1.length() != cadena2.length()){
      return false;
    }
     
    //Comparamos que sean los mismos carácteres en caso de que la longitud sea igual
    for(int i = 0; i < cadena1.length(); i++){
      if(cadena1.charAt(i) != cadena2.charAt(i)){
        return false;
      }
    }
    //Si recorre toda a cadena y todos son iguales, entonces es la misma cadena
      return true;
  }
            
  public String daSubcadena(String cadena, int inicio, int fin){
    String otro = "";
    if(inicio < 0){
      //inicio=0;
      return cadena;
    }
    if(cadena.length() < fin){
      fin = cadena.length();
    }
    for(int i = inicio; i < fin; i++){
      otro += cadena.charAt(i);
    }
    return otro;
  }
            
  public static void main(String[] args) {

    //Creamos nuestro Scanner
    Scanner entrada = new Scanner(System.in);
        
    //Pedimos que el usuario eliga una función a trabajar con una cadena
    System.out.println("Hola, estamos desarrollando un programa el cual puede hacer las siguientes funciones con cadenas"
      + "\nSelccione una función porfavor :)\n");
        
    System.out.println("1: Encuentra la posicion de la cadena (encuentraPosicion) \n2: Reconoce si la cadena es un número (esNumero) \n3: Reemplaza un carácter de la cadena (reemplazaCaracter) "+
      "\n4: Cuenta el número de veces que está un carácter en la cadena (cuentaCaracter) \n5: Reconoce si la cadena es palíndroma (esPalindromo) \n6: Sabe si una cadena esta contenida en otra (contiene) "+
      "\n7: Determina si dos cadenas son o no iguales (sonIguales) \n8:Da una subcadena de la cadena original (En caso de ingresar mal los datos devuelve la cadena entera) (daSubcadena) \n");

    int opciones = entrada.nextInt();
       
    do{ 
      //Usamos un switch para ejecutar la opción elegida por el usuario con sus diferentes casos
      switch(opciones){
                    
        //Si el usuario escoge el método encuentraPosicion
        case 1:
          Scanner f1 = new Scanner(System.in);
          FuncionesDeCadenas funcion1 = new FuncionesDeCadenas();
                   
          System.out.println("\nEscogiste la funcion \"encontrar posición\" \nIngrese cadena 1");
          String c1 = f1.nextLine();
                   
          System.out.println("\nIngrese caráter ");
          String car = f1.nextLine();
                      
          char auxChar = car.charAt(0);
                          
          if(funcion1.encuentraPosicion(c1,auxChar) != -1){
            System.out.println("\nLa letra \"" + auxChar + "\" está en la posición " + funcion1.encuentraPosicion(c1,auxChar));
          }else{
            System.out.println("\nLa letra \"" + auxChar + "\" no está en la cadena, devolvemos " + funcion1.encuentraPosicion(c1,auxChar));
                                }           
            System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 seguido de ENTER para salir)");
              opciones = entrada.nextInt();
        break;

        //Si el usuario escoge el método esNumero
        case 2:
          Scanner f2 = new Scanner(System.in);
          FuncionesDeCadenas funcion2 = new FuncionesDeCadenas();

          System.out.println("\nEscogiste la función \"es número\" \nIngrese cadena ");
          String ca1 = f2.nextLine();

          System.out.print("\n" + funcion2.esNumero(ca1));

          System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 para salir)");
              opciones = entrada.nextInt();
                          
        break;

        //Si el usuario escoge el método reemplazaCaracter
        case 3:
          Scanner f3 = new Scanner(System.in);
          FuncionesDeCadenas funcion3 = new FuncionesDeCadenas();
  
          System.out.println("\nEscogiste la funcion \"reemplazar carácter\" \nIngrese texto ");
          String todo = f3.nextLine();
  
          System.out.println("\n¿Qué carácter deseas reemplazar? ");
          String a = f3.nextLine();
          char reemplazado = a.charAt(0);

          System.out.println("\n¿Por qué carácter deseas cambiar al anterior? ");
          String b = f3.nextLine();
          char reemplazador = b.charAt(0);
                           
          System.out.print("\n" + funcion3.reemplazaCaracter(todo,reemplazado, reemplazador));

          System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 para salir)");
              opciones = entrada.nextInt();
        break;

        //Si el usuario escoge el método cuentaCaracter
        case 4:
          Scanner f4 = new Scanner(System.in);
          FuncionesDeCadenas funcion4 = new FuncionesDeCadenas();
  
          System.out.println("\nEscogiste la función \"cuenta carácter\" \nIngrese texto ");
          String cadPrincipal = f4.nextLine();
  
          System.out.println("\n¿Qué carácter deseas contar? ");
          String c = f4.nextLine();
          char auxChar4 = c.charAt(0);

          System.out.print("\n" + funcion4.cuentaCaracter(cadPrincipal,auxChar4));

          System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 seguido de ENTER para salir)");
            opciones = entrada.nextInt();
        break;

        //Si el usuariov escoge el método esPalindromo
        case 5:
          Scanner f5 = new Scanner(System.in);
          FuncionesDeCadenas funcion5 = new FuncionesDeCadenas();
  
          System.out.println("\nEscogiste la funcion es palíndromo \nIngrese palabra ");
          String palim = f5.nextLine();

          System.out.print("\n" + funcion5.esPalindromo(palim));

          if(funcion5.esPalindromo(palim)){
            System.out.print(", " + palim + " es palíndroma\n");      
          }else{
            System.out.print(", " + palim + " no es palíndroma\n");
          }
          System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 para salir)");
            opciones = entrada.nextInt();
        break;

        //Si el usuario escoge el método contiene
        case 6:
          Scanner f6 = new Scanner(System.in);
          FuncionesDeCadenas funcion6 = new FuncionesDeCadenas();

          System.out.println("\nEscogiste la función contiene \nIngrese primer cadena ");
          String principal = f6.nextLine();

          System.out.println("\nIngrese segunda cadena ");
          String secundaria = f6.nextLine();

          System.out.print("\n"+funcion6.contiene(principal,secundaria));

          System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 para salir)");
            opciones = entrada.nextInt();
        break;

        //Si el usuario escoge el método sonIguales(
        case 7:
          Scanner f7 = new Scanner(System.in);
          FuncionesDeCadenas funcion7 = new FuncionesDeCadenas();
                           
          System.out.println("\nEscogiste la función \"son iguales\" \nIngrese cadena 1");
          String cad1 = f7.nextLine();  
                    
          System.out.println("\nIngrese cadena 2");
          String c2 = f7.nextLine();
                     
          System.out.print("\n" + funcion7.sonIguales(cad1,c2));
            if(funcion7.sonIguales(cad1,c2)){
              System.out.print(", las cadenas son iguales.\n");      
            }else{
              System.out.print(", las cadenas son diferentes.\n");
            }
            System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 seguido de ENTER para salir)");
              opciones = entrada.nextInt();
        break;

        //Si el usuario escoge el método daSubcadena
        case 8:
          Scanner f8 = new Scanner(System.in);
          FuncionesDeCadenas funcion8 = new FuncionesDeCadenas();
  
          System.out.println("\nEscogiste la funcion dar subcadena \nIngrese texto ");
          String subcadena = f8.nextLine();
  
          System.out.println("\n¿Desde dónde quieres partir? ");
          int  start = f8.nextInt();
          
          System.out.println("\n¿Hasta ...?");
          int  end = f8.nextInt();

          System.out.print("\n\"" + funcion8.daSubcadena(subcadena,start,end) + "\"");
          System.out.println("\n¿Continuar? (Ingrese otro número para realizar otra de las opciones o pulsa 9 para salir)");
            opciones = entrada.nextInt();
        break;

        default:
          entrada.close();
          opciones = 9;
          System.out.print("Opción inválida (Cierre automático del programa) \n* * * * Hasta la Proximaaaaaaa * * * * UwU\n" );
          }
                
          }while(opciones !=9);
    }
}