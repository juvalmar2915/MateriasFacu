package prog3.complementos;

import prog3.util.Pila;

public class TestBalanceo {

	public static void main(String[] args) {
		String p=" hola todo bien soy arg  [[]]";
		System.out.println(balanceado(p));

	}
	
	public static boolean balanceado(String s) {
		Pila<Character> p=new Pila<Character>();
		for(int i=0;i<s.length();i++) {
			if (s.charAt(i)=='(') {
				p.apilar(s.charAt(i));
			}
			else {
				if (s.charAt(i)==')') {
					if ((!p.esVacia()) && (p.tope()=='('))
						p.desapilar();
					else
						p.apilar(s.charAt(i));
				}	
			}
			if (s.charAt(i)=='[') {
				p.apilar(s.charAt(i));
			}
			else {
				if (s.charAt(i)==']') {
					if ((!p.esVacia()) && (p.tope()=='['))
						p.desapilar();
					else
						p.apilar(s.charAt(i));
				}
			}
			if (s.charAt(i)=='{') {
				p.apilar(s.charAt(i));
			}
			else {
				if (s.charAt(i)=='}') {
					if ((!p.esVacia()) && (p.tope()=='{'))
						p.desapilar();
					else
						p.apilar(s.charAt(i)); 
				}
			}
		}
		return p.esVacia();
	}

}
