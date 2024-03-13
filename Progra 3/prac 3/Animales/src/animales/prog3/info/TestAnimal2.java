package animales.prog3.info;

public class TestAnimal2 {
	public static void main(String[] args) {
		Animal donGato = new Gato();
		donGato.saludo();
		Animal benji = new Perro();
		benji.saludo();
		Animal lassie = new PerroGrande(); // no puedo mandar esmasbuenoque() ya que lassie es de tipo animal y el programa no sabe que tipo de animal es
		lassie.saludo();
	}
}