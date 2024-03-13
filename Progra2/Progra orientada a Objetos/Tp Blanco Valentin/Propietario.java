public class Propietario
{
    private int CIT;
    private String nombre;
    private String apellido;
    public Propietario(int CIT,String nombre,String apellido)
    {
     this.setCit(CIT);
     this.setNombre(nombre);
     this.setApellido(apellido);
    }
    public Propietario()
    {
    }
    public void setCit(int CIT)
    {
        this.CIT=CIT;
    }
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public void setApellido(String apellido)
    {
        this.apellido=apellido;
    }
    public String getApellido()
    {
        return apellido;
    }
    public String getNombre()
    {
        return nombre;
    }
    public int getCit()
    {
        return CIT;
    }
}
