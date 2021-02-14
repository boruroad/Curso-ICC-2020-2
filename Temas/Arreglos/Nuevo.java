public class Nuevo {

    public static int auxVeces(int n,int [] arreglo){
        int veces = 0;
        for (int i=0;i<arreglo.length;i++){
            if(n==arreglo[i])
            veces++;    
        }
        return veces;
    }

    public static int masRepetido(int[] numeros){
       int mayor = numeros[0];
       for (int i=0;i<numeros.length;i++){
           if(auxVeces(mayor,numeros)<auxVeces(numeros[i],numeros))
            mayor=numeros[i];
       }    
       return mayor;
   }

    /**
     * Muestra los elementos de un arreglo bidimensional
     * @param arreglo el arreglo a mostrar
     */
    public static void dame(int [] arreglo){
        for(int i=0;i<arreglo.length;i++){
        System.out.print(arreglo[i]+" ");
        }
        System.out.println();
    } 


    public static int[] colapsa(int[] arreglo){
        int mayor = arreglo[0];
       for (int i=0;i<arreglo.length;i++){
            if(mayor<arreglo[i]){
                mayor=arreglo[i];
            }
       }   
      int a = auxVeces(masRepetido(arreglo),arreglo)+1;
      System.out.println(mayor);
      int [] arrAux = new int [mayor+1];

      int [] nuevo = new int [mayor+1]       
       for (int i=0;i<arreglo.length;i++){
            nuevo = auxVeces(i,arreglo);
       }
       return arrAux;
    }

    public static void main(String[] args) {

        System.out.println("\nRecibe un arreglo de enteros: ");
        int []a3 = {1,3,4,3,1,5,1,5};
        //int []a3 = {2,2,3,3,5};
        //int []a3 = {2,1,3,2,5};
        //int []a3 = {2,1,2,2,5,1,2,3,2,5,1};
        dame(a3);
        System.out.println("\nDevolvemos ");
        dame(colapsa(a3));
    

    }    
}