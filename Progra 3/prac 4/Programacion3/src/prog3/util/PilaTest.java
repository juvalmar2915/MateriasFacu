package prog3.util;

public class PilaTest {

	public static void main(String[] args) {
		Pila<Character> p=new Pila<Character>();
		p.apilar('a');
		p.apilar('b');
		p.apilar('c');
		p.apilar('d');
		p.apilar('e');
		p.desapilar();
		p.desapilar();
		p.desapilar();
		p.desapilar();
		System.out.println(p.tope());
	}

}
