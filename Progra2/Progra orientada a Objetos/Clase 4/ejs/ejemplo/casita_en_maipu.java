import java.util.Scanner;
public class casita_en_maipu {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int z;
        Punto punto;
        System.out.println("Ingrese Titulo y autor");
        Dibujo dibu=new Dibujo(in.next(),in.next());
        System.out.println("Ingrese cantidad de figuras");
        int max=in.nextInt();
        Figura[] figuras=new Figura[max];
        for (int i=0; i<max; i++){
            System.out.println("Elija el numero 1:circulo, 2:cuadrado, 3:triangulo");
            z=in.nextInt();
            switch(z){
                case(1):
                    System.out.println("Ingrese valores del circulo");
                    figuras[i]=new Circulo(in.nextInt(),in.next(),in.next(),punto=new Punto(in.nextInt(),in.nextInt()));
                break;
                case(2):
                    System.out.println("Ingrese valores del cuadrado");
                    figuras[i]=new Cuadrado(in.nextInt(),in.next(),in.next(),punto=new Punto(in.nextInt(),in.nextInt()));
                break;
                case(3):
                    System.out.println("Ingrese valores del Triangulo");
                    figuras[i]=new Triangulo(in.nextInt(),in.nextInt(),in.nextInt(),in.next(),in.next(),punto=new Punto(in.nextInt(),in.nextInt()));
                break;
            }
            dibu.AniadirFigura();
        }
        for (int i=0; i<max; i++){
            System.out.println(figuras[i].dibujar());
        }
        System.out.println(dibu.mostrar());
    }
}
