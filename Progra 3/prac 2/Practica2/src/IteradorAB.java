
public class IteradorAB {
	
	public static void iteracionConFor(int a, int b) {
		for (int i=a;i<=b;i++)
			System.out.println(i);
	}
	public static void iteracionConWhile(int a, int b) {
		while (a<=b) {
			System.out.println(a);
			a++;
		}
	}
	public static void recursivo(int a, int b) {
        System.out.println(a);
        if (a < b) 
        	recursivo(++a, b);
	}
	public static void recursivo2(int a, int b) {
		System.out.println(a);
		if (a > b) 
			recursivo2(--a, b);
	}
}
