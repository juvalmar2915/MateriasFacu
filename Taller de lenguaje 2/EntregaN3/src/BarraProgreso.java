
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.plaf.SliderUI;

public class BarraProgreso implements Runnable{
	private JProgressBar barra;
	private int cont;
	private int progreso=0;
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public void addProgreso() {
		this.progreso++;
	}
	public JProgressBar getBarra() {
		return barra;
	}
	public void setBarra(JProgressBar barra) {
		this.barra = barra;
	}
	public BarraProgreso() {
		barra=new JProgressBar();
	}
	public void run() {
		this.getBarra().setValue(50);
		while (progreso<cont) {
			this.getBarra().setValue((progreso*100)/cont);
			Thread.yield();
		}
		this.getBarra().setValue(100);
	}
}
