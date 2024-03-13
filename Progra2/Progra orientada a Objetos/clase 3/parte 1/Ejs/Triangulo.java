public class Triangulo
{
    private double l1;
    private double l2;
    private double l3;
    private String cr;
    private String cl;
    
    public String getCl()
    {
     return cl;
    }
    
    public String getCr()
    {
     return cr;
    }
    
    public double getL1()
    {
     return l1;
    }
    
    public double getL2()
    {
     return l2;
    }
    
    public double getL3()
    {
     return l3;
    }
    
    public void setL1(double x)
    {
     l1=x;
    }
    
    public void setL2(double x)
    {
     l2=x;
    }
    
    public void setL3(double x)
    {
     l3=x;
    }
    
    public void setCl(String color)
    {
     cl=color;
    }
    
    public void setCr(String color)
    {
     cr=color;
    }
    
    public double calcularArea()
    {
        double s=(l1+l2+l3)/2;
        return Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
    }
    
    public double calcularPerimetro()
    {
        return l1+l2+l3;
    }
}
