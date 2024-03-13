
public class Entrenador
{
   
    private String Nombre;
    private double SueldoBasico;
    private int CantCampeonatosGanados;
    
    public Entrenador(String Nombre,double SueldoBasico,int CantCampeonatosGanados)
    {this.Nombre = Nombre;
     this.SueldoBasico = SueldoBasico;
     this.CantCampeonatosGanados =  CantCampeonatosGanados;
    }
    public Entrenador(){
    }
    public String getNombre(){
        return Nombre;
    }
    public double getSueldoBasico(){
        return SueldoBasico;
    }
    public int getCantCampeonatosGanados(){
        return CantCampeonatosGanados;
    }
    public double calcularSueldoACobrar(){
        if (CantCampeonatosGanados==0)
            return (SueldoBasico);
        else
            if (CantCampeonatosGanados<=4)
            return (SueldoBasico+5000);
            else 
                if (CantCampeonatosGanados<=10)
                    return (SueldoBasico+30000);
                else
                    return (SueldoBasico+50000);
    }
    public String toString(){
    String aux;
    aux="El entrenador "+Nombre+", tiene "+CantCampeonatosGanados+" campeonatos ganados y cobra $"+calcularSueldoACobrar();
    return aux;
    }
}
