package animales.prog3.info;

public class TestAnimal3 {
	public static void main(String[] args) {
		Gato gato1 = new Gato();
		gato1.saludo();
		Perro perro1 = new Perro();
		perro1.saludo();
		PerroGrande perroGrande1 = new PerroGrande();
		perroGrande1.saludo();
		Animal animal1 = new Gato();
		animal1.saludo();
		Animal animal2 = new Perro();
		animal2.saludo();
		Animal animal3 = new PerroGrande();
		animal3.saludo();
		Perro perro2 = (Perro) animal2; // agarra el objeto y lo trata como un perro
		PerroGrande perroGrande2 = (PerroGrande) animal3;
		Perro perro3 = (PerroGrande) animal3; //solo podemos usar metodos de perro
		// Gato gato2 = animal2; al ser de tipo Perro tira error de ejecucion ya que no es posible castear un gato como perro
		perro2.saludo(perro3);
		perro3.saludo(perro2);
		perro2.saludo(perroGrande2);
		perroGrande2.saludo(perro2);
		perroGrande2.saludo(perroGrande1);
	}
}
// g. usamos el mecanismo downcasting
// h. es posible pero no pueden usarse los metodos de las subclases a menos que se lo downcastee (transformar en una subclase)