public class Entrenador extends Empleado
{
    private int CantCampeonatosGanados;
    public Entrenador(String Nombre,double SueldoBasico,int CantCampeonatosGanados)
    {
     super(Nombre,SueldoBasico);
     this.setCantCampeonatosGanados(CantCampeonatosGanados);
    }
    
    public Entrenador(){
    }
    
    public void setCantCampeonatosGanados(int ccg){
        CantCampeonatosGanados=ccg;
    }
    
    public int getCantCampeonatosGanados(){
        return CantCampeonatosGanados;
    }
    public double CalcularSueldoACobrar(){
        if (CantCampeonatosGanados==0)
            return (getSueldoBasico());
        else
            if (CantCampeonatosGanados<=4)
            return (getSueldoBasico()+5000);
            else 
                if (CantCampeonatosGanados<=10)
                    return (getSueldoBasico()+30000);
                else
                    return (getSueldoBasico()+50000);
    }
}
