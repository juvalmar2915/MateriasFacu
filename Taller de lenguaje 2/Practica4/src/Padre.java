// archivo Padre.java
public class Padre  extends Abuelo{
	Padre(int x) {
		System.out.println("Constructor Padre(" + x + ") "); //siempre que haya un constructor se debe agregar el nulo
		}
	Padre() {
		System.out.println("Constructor Padre()");
		}
}
