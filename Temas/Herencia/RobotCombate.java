public class RobotCombate extends Robot{
  protected int municion;

  public RobotCombate(int x, int y, int municion){
    super(x, y);
    this.municion = municion;
  }

  public void recarga(){
    System.out.println("---recargando");
    municion += 10;
  }

  public void dispara(){
    if(municion > 0){
      municion--;
      System.out.println("\t¡BANG!");
    }else{
      System.out.println("---sin munición");
    }
  }

  @Override
  public String toString(){
    return super.toString() + " y "+municion+" de munición";
  }

  //@Override no va para métodos estáticos
  public static void reinicia(RobotCombate robot){
    Robot.reinicia(robot);
    robot.municion = 0;
  }

  public static void main(String[] args){
    Robot roby = new RobotCombate(2,2,5); //El compilador lo permite?? SÍ
    // por INFERENCIA DE TIPOS

    System.out.println(roby instanceof Robot);
    System.out.println(roby instanceof RobotCombate);

    System.out.println(roby); //¿Cuál toString invoca?
    //opcion 1 lode RobotCombate
    //opcion 2 lo de Robot

    roby.avanza("derecha");
    roby.avanza("norte");
    roby.avanza("norte");
    // Lo nuevo
    RobotCombate rob = (RobotCombate)roby;
    rob.dispara();
    rob.recarga();
    rob.dispara();
    // Fin de lo nuevo

    System.out.println(roby);

    // Robot.reinicia(rob);
    RobotCombate.reinicia(rob);
    System.out.println(roby);

  }


}
