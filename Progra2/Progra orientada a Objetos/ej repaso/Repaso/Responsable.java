public class Responsable
{
    private int dni;
    private String nombre;
    private String apellido;
    public Responsable(int dni,String nombre,String apellido)
    {
     this.setDni(dni);
     this.setNombre(nombre);
     this.setApellido(apellido);
    }
    public Responsable()
    {
    }
    public void setDni(int dni)
    {
        this.dni=dni;
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
    public int getDni()
    {
        return dni;
    }
}
