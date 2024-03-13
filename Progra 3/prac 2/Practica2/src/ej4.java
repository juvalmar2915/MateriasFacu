import java.util.Scanner;

public class ej4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x=s.nextInt();
		int[] multiplosx= new int[x];
		multiplosx=Multiplos.getmultiplos(x);
		for (int i=0;i<x;i++) {
			System.out.println(multiplosx[i]);
		s.close();
		}
	}

}
