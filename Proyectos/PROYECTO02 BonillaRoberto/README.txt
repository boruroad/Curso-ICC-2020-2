Bonilla Ruiz Roberto Adrián 
No. Cuenta 31721903-8
Proyecto02 Introducción a Ciencias de la Computación

– Dentro de la carpeta comprimida debe haber un archivo llamado
Readme.txt con una breve descripción de cómo resolvieron los problemas, el funcionamiento, los inconvenientes que se presentaron (si
hubieron) y cómo compilar el proyecto.

Aser verdad este proyecto me emocionó mucho ya que en mi ultimo curso de icc no habia llegado hasta acá por lo mismo de que no entendia, ahora veo que aunque me cuesta un poco de trabajo extra (si entiendo cada una de las partes de mi código)

Después de investigar, preguntar como debía de funcionar cada cifrado y demás, el primer porblema surgio cuando no sabia como eliminar los caracteres especiales, asi que lo primero que hice fue aplicar el método.replaceAll para cada caracter especial (lo malo ahi era la cantidad de estos, pues son muchos) asi que preguntando con demás compañeros fue me que me aconsejaron mejor limitar mi rango de caracteres permitidos, es decir: solo letras y que todo lo que no fuera d eese tipo seria eliminado, ahi fue cunado me pregunte si la "Ñ"  entraba en el abecedario, algunos dicen que no, pero como estamos en méxico y se usa esa letra, en mi abecedario yo si la coloqué auque tambien fue un reto leve saber como descifrarla en el primer cifrado (César) puesto que mi metodo obtener cadena la eliminaba, ahi empezaron los problemas (en los metodos). 
pero si bien, una vez que termine el método "Obtener cadena" y el primer cifrado de cesar, supuse que los demás serian de manera similar, por lo que lo más dificil era hacer los cifrados ya que los decifrados era el mismo codigo solo que con pequeños cambios, por ejemplo:

Que en el cifrado de cesar en vez de restar "k", mejor sumaramos de nuevo el abecedario y restaramos k para obtener el mensaje decifrado o que en el de rieles, en vez de solo trabajar con for, usaramos switch para cada modulo o en kamasutra, regresar las multiples posiciones de cada abecedeario creado aleatoriamente. 

Ahora, sobre el funcionamiento, yo lo primero que hice fue implementar un menú de opciones para que el usuario pudiera trabajar, pero este no servia si queriamos poner un texto de entrada y uno de salida, por lo que elimine mucho codigo por eso y me di cuenta que fueron horas "desperdiciadas" aun asi Scanner es algo que por lo general me gusta mucho implementar, siguiendo con esto, el funcionamiento pues es claro:

-Recibir una cadena y mostrar sus diferentes tipos de cifrado y descifrado ya sin caracteres especiales ni espacios.

Como ya mencioné los principales inconvenientes surgieron en la creacion de cada método para cifrar asi como en tener un abecedario aleatorio usando la clase Random para luego ver cual era la posicion correspondiente al abecedario normal.

Otra cosa es que nunca antes habia usado los simbolos < ó > pues no sabia para que servian, pero al parecer no tienen tanta complejidad, solo especifican la entrada y la salida de lo que el .java va a ejecutar.

Por último para compilar hay dos formas de hacerlo, la primera es por archivo y la segunda por carpeta.
Si es de la primera forma lo hacemos como en el proyecto pasado: javac NombreDelArchivo.java
Si es de la segunda forma, lo primero que debemos hacer es verificar que en la carpeta solo haya archivos.java (eliminamos los .class)
y después desde consola escribimos javac *.java

(En total en este proyecto tarde un promedio de 8 días dedicando de 4 a 5 horas por día).

