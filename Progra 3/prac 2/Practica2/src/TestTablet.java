
public class TestTablet {

	public static void main(String[] args) {
		Tablet tablets[]=new Tablet[3];
		int x=0;
		for (int i=0;i<3;i++) {
			tablets[i]=new Tablet();
			tablets[i].setModelo(args[x++]);
			tablets[i].setSistemaOperativo(args[x++]);
			tablets[i].setMarca(args[x++]);
			tablets[i].setCosto(Math.random()*1000);
			tablets[i].setPulgadas((float) Math.random()*10);
		}
		for (int i=0;i<3;i++) {
			System.out.println(tablets[i].devolverDatos());
		}
	}

}