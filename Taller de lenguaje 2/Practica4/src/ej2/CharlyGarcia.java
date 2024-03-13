package ej2;

public class CharlyGarcia {
	private static CharlyGarcia INSTANCE = new CharlyGarcia();
	private CharlyGarcia() {}
	public static CharlyGarcia getCharlyGarcia() {
		return INSTANCE;
	}
	public void cantar(){
		System.out.println("Charly Garcia está cantando");
	}

}
