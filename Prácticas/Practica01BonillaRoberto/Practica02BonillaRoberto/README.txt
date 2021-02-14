Bonilla Ruiz Roberto Adrián 
No. Cuenta 31721903-8

– Dentro de la carpeta comprimida debe haber un archivo llamado
Readme.txt con una breve descripción de cómo resolvieron los prob-
lemas, el funcionamiento, los inconvenientes que se presentaron (si
hubieron) y cómo compilar la práctica.

Para ser breves, lo más complicado fue la implementación de la clase Veterinario y su interacción con la clase Mascota
ya que jamas habia creado y usado clases como tal. Lo que aprendi de manera conreta fueron las definiciones de métodos, sobre todo la función del método constructor como molde para la creación de instancias, asi como la sobrecarga de métodos, los cuales se pueden llamar igual pero reciben diferentes parámetros, me agrada que para el desarrollo de la práctica debamos comentar el código aunque eso implique más tiempo, tambien los métodos de acceso y mutantes, los cuales nos sirven para obtener o cambiar los estados de algunas instancias, igualmente conocer el método toString para la impresion de propiedades.
Una de las cosas  que también se me complicó fueron los métodos que hacen la función "platicar", "HacerMejorAMigo" y "Ex-MejorAMmigo" 
Sobre la práctica, todo funciona como lo establecido (incluyendo la interacción de las clases) y por último para compilar hay dos formas de hacerlo, la primera es por archivo y la segunda por carpeta.
Si es de la primera forma lo hacemos como la parctica pasada: javac NombreDelArchivo.java
SI es de la segunda forma, lo primero que debemos hacer es verificar que en la caroeta solo haya archivos.java (eliminamos los .class)
y después desde consola escribimos javac *.java

Por último uno de los problemas más graves que tuve fue el revertir la amistad entre dos mascotas, ya que no sabía ni por donde empezar (por lo mismo de que nunca habia visto un metodo con getters y setters en una sola línea)

				//Creamos el método "revertir amistad"
					public void revertirAmistad(Mascota mascota1){
						mascota1.setMejorAmigo(mascota1.getExMejorAmigo());
						mascota1.setExMejorAmigo(null);
					}


 (en total en esta practica tarde un promedio de 8-9 días).

