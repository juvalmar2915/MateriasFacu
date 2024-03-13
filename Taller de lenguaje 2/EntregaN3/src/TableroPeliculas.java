import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class TableroPeliculas extends Frame{
	public static int progreso;
	public TableroPeliculas() {
		GridLayout g=new GridLayout(5,1);
		setLayout(g);
		setSize(1000,1000);
		TablaCant t= new TablaCant();
		Histograma h=new Histograma();
		SelectorCant s=new SelectorCant(h);
		JButton procesar= new JButton("Procesar Datos");
		BarraProgreso ba=new BarraProgreso();
		procesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
					ProcesarDatos p = new ProcesarDatos(t, s, ba);
			}
		});
		Container c=new Container();
		c.setLayout(new FlowLayout());
		c.add(procesar);
		c.add(ba.getBarra());
		add(c);
		add(t);
		add(s);
		add(h);
		setVisible(true);
		JOptionPane.showMessageDialog(null, "Sin Datos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	public static void main(String[] args) {
		TableroPeliculas t=new TableroPeliculas();
	}

}
