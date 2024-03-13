
public class PruebaRetorno {
	public static void main(String args[]) {
		int dimf=5;
		int[] arreglo=new int [dimf];
		for (int i=0;i<dimf-1;i++) {
			arreglo[i]=(int) (Math.random()*10);
		}
		System.out.println(sumaArreglo1(arreglo,dimf));
		sumaArreglo2(arreglo,dimf);
		System.out.println(arreglo[dimf-1]);
	}
	public static int sumaArreglo1(int x[],int df){
		int suma=0;
		for (int i=0;i<df;i++) {
			suma=suma+x[i];
		}
		return suma;
	}
	public static void sumaArreglo2(int vector[], int cant){
        vector[cant-1]=0;
        for(int i=0; i<(cant-1); i++) {
            vector[cant-1]+=vector[i];
        }
    }
}
