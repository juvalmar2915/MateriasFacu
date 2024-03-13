public class Entrenador
{
  private String nombre;
  private double sueldo;
  private int campeonatos;

  public void setCampeonatos(int campeonatos)
  {
    this.campeonatos=campeonatos;
  }
  public void setSueldo(double sueldo)
  {
    this.sueldo=sueldo;
  }
  public void setNombre(String nombre)
  {
    this.nombre=nombre;
  }
  public String getNombre()
  {
    return nombre;
  }
  public double getSueldo()
  {
    return sueldo;
  }
  public int getCampeonatos()
  {
    return campeonatos;
  }
  public double calcularSueldoACobrar()
  {
    int plus=0;
    if (campeonatos>=1 && campeonatos<=4)
     plus=5000;
    if (campeonatos>=5 && campeonatos<=10)
     plus=30000;
    if (campeonatos>10)
     plus=50000;
    return (sueldo+plus);
  }
}
