import java.util.Scanner;
public class Editorial{
    public static void main(String[] args){
        Scanner it = new Scanner(System.in);
        Ejemplar[] eje = new Ejemplar[1000];
        int i=0;
        int diml=0;
        boolean salir = false;
        while ((i<4)&&(salir==false)){
          System.out.println("Ingrese si es libro o revista,o ingrese salir si desea terminar");
          String ver = it.next();
          if(ver.equals("libro")){
              System.out.println("Ingrese codigo identificatorio");
              int codigo = it.nextInt();
              System.out.println("Ingrese cantidad de páginas");
              int paginas = it.nextInt();
              System.out.println("Ingrese un resumen");
              String resumen = it.next();
              System.out.println("Ingrese año de publicacion");
              int año = it.nextInt();
              System.out.println("Ingrese DNI del responsable");
              int resDNI = it.nextInt();
              System.out.println("Ingrese nombre del responsable");
              String resNombre = it.next();
              System.out.println("Ingrese apellido del responsable");
              String resApellido = it.next();
              Responsable resp = new Responsable(resDNI,resNombre,resApellido);
              System.out.println("Ingrese titulo del libro");
              String titulo = it.next();
              System.out.println("Ingrese cantidad de capitulos");
              int capitulos = it.nextInt();
              System.out.println("Ingrese si es una edicion de bolsillo (si o no)");
              String bolsillo = it.next();
              boolean edicion=false;
              if (bolsillo == "si"){
                  edicion = true;
                }
              eje[i] = new Libro (codigo,paginas,resumen,año,resp,titulo,capitulos,edicion);
              i++;
              diml++;
            }
            else if(ver.equals("revista")) {
              System.out.println("Ingrese codigo identificatorio");
              int codigo = it.nextInt();
              System.out.println("Ingrese cantidad de páginas");
              int paginas = it.nextInt();
              System.out.println("Ingrese un resumen");
              String resumen = it.next();
              System.out.println("Ingrese año de publicacion");
              int año = it.nextInt();
              System.out.println("Ingrese DNI del responsable");
              int resDNI = it.nextInt();
              System.out.println("Ingrese nombre del responsable");
              String resNombre = it.next();
              System.out.println("Ingrese apellido del responsable");
              String resApellido = it.next();
              Responsable resp = new Responsable(resDNI,resNombre,resApellido);
              System.out.println("Ingrese nombre de la revista");
              String nombre = it.next();
              System.out.println("Ingrese volumen");
              double volumen = it.nextDouble();
              System.out.println("Ingrese cantidad de articulos");
              int articulos = it.nextInt();
              eje[i] = new Revista(codigo,paginas,resumen,año,resp,nombre,volumen,articulos);
              i++;
              diml++;
            }else if(ver.equals("salir")){
                salir = true;
            }
        }
        for(i=0;i<diml;i++){
            System.out.println(eje[i].toString());
        }
        for(i=0;i<diml;i++){
         if(eje[i].getAñoPublicacion()==0){
             eje[i].setAñoPublicacion(2019);
             System.out.println(eje[i].toStringAño());
            } 
        }
    }        
}

