public class RobotVeloz extends Robot{

  protected int velocidad = 10;

  @Override
  public void avanza(String direccion){
    for(int i=0; i<velocidad; i++){
      super.avanza(direccion);
    }
  }

  @Override
  public String toString(){
    return super.toString() + " y "+velocidad+" de velocidad";
  }

  public static void main(String[] args){
    RobotVeloz roby = new RobotVeloz();
    System.out.println(roby);
    roby.avanza("derecha");
    roby.avanza("norte");
    System.out.println(roby);
  }
}
