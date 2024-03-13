
public class dispositivosprog3infoEjercicioTestSobreescritura {
	public static void main(String[] args) {
		SmartPhone sp[] = new SmartPhone[2];
		int x = 0;
		for (int i = 0; i < 2; i++) {
			sp[i] = new SmartPhone();
			sp[i].setModelo(args[x++]);
			sp[i].setSistemaOperativo(args[x++]);
			sp[i].setMarca(args[x++]);
			sp[i].setCosto(Math.random() * 1000);
			sp[i].setNumero(5);
		}
		System.out.println(sp[0].equals(sp[1]));
		System.out.println(sp[0].toString());
		System.out.println(sp[1].toString());
	}
}
