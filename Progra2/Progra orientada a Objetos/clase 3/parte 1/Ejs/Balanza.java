public class Balanza
{
  private double monto;
  private int cant;
  
  public void iniciarCompra()
  {
   monto=0;
   cant=0;
  }
  
  public void registrarProducto(double pesoEnKg, double precioPorKg)
  {
    monto=monto+precioPorKg*pesoEnKg;
    cant++;
  }
  
  public double devolverMontoAPagar()
  {
   return monto;
  }
  
  public String devolverResumenDeCompra()
  {
   String aux=new String();
   aux="Total a pagar " + monto + " por la compra de " + cant + " productos";
   return aux; 
  }
}
