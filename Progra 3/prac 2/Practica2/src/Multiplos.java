
public class Multiplos {
	public static int[] getmultiplos(int n) {
		int[] arreglo=new int[n];
		for (int i=1;i<=n;i++) {
			arreglo[i-1]=n*i;
		}
		return arreglo;
	}
}