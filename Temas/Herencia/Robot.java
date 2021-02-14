public class Robot{
  protected int x, y;

  public Robot(int x, int y){
    this.x = x;
    this.y = y;
  }

  public Robot(){
  }

  public void avanza(String direccion){
    switch(direccion){
      case "arriba":
      case "norte":
        y += 1;
        break;
      case "derecha":
      case  "este":
        x += 1;
        break;
      case "abajo":
      case "sur":
        y -= 1;
        break;
      case "izquierda":
      case "oeste":
        x -= 1;
        break;
    }
  }

  @Override
  public String toString(){
    return "El robot está en las coordenadas ("+x+", "+y+ ")";
  }

  public static void reinicia(Robot robot){
    robot.x = robot.y = 0;
  }

  public static void main(String[] args){
    Robot roby = new Robot();
    System.out.println(roby);
    roby.avanza("derecha");
    roby.avanza("norte");
    roby.avanza("norte");
    System.out.println(roby);

    Robot.reinicia(roby);
    System.out.println(roby);
  }


}
