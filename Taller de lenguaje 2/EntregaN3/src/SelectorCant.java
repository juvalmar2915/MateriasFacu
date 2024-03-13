
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import listagenerica.ListaGenericaEnlazada;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class SelectorCant extends JPanel{
	private JTable tabla;
	private JLabel l;
	private JComboBox<String> box;
	private String[] titulos= {"Nombre de pelicula","# Usuarios","# Votos"};
	private ModeloTabla mt;
	private Histograma h;
	public SelectorCant(Histograma h) {
		l=new JLabel("Cantidad de resultados a mostrar: ");
		this.h=h;
		box=new JComboBox<String>();
		box.addItem("");
		box.addItem("5");
		box.addItem("10");
		box.addItem("20");
		box.addItem("100");
		box.addItem("1000");
		box.addItem("TODOS");
		String[][] matriz= new String[3][];
		tabla= new JTable();
		mt=new ModeloTabla(titulos, matriz);
		tabla.setModel(mt);
		this.setLayout(new BorderLayout());
		Container c= new Container();
		c.setLayout(new FlowLayout());
		c.add(l);
		c.add(box);
		add(c,BorderLayout.NORTH);
		Container c2= new Container();
		c2.setLayout(new BorderLayout());
		c2.add(tabla);
		c2.add(new JScrollPane(tabla));
		add(c2);
	}
	public void casos(PelisUsuariosVotos[] arreglo) {
		box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String itemSeleecionado = (String)box.getSelectedItem();
				int a=tabla.getRowCount()-1;
				int x;
				for (int i = a; i >= 0; i--) {          
			        mt.removeRow(tabla.getRowCount()-1);
				}
				switch (itemSeleecionado) {
					case "5" :
						for(x=0;x<5;x++) {
							String[] s={arreglo[x].getPelicula(),String.valueOf(arreglo[x].getCant()),String.valueOf(arreglo[x].getRatingTotal())};
							mt.addRow(s);
						}
						break;
					case "10" :
						for(x=0;x<10;x++) {
							String[] s={arreglo[x].getPelicula(),String.valueOf(arreglo[x].getCant()),String.valueOf(arreglo[x].getRatingTotal())};
							mt.addRow(s);
						}
						break;
					case "20" :
						for(x=0;x<20;x++) {
							String[] s={arreglo[x].getPelicula(),String.valueOf(arreglo[x].getCant()),String.valueOf(arreglo[x].getRatingTotal())};
							mt.addRow(s);
						}
						break;
					case "100" :
						for(x=0;x<100;x++) {
							String[] s={arreglo[x].getPelicula(),String.valueOf(arreglo[x].getCant()),String.valueOf(arreglo[x].getRatingTotal())};
							mt.addRow(s);
						}
						break;
					case "1000" :
						for(x=0;x<1000;x++) {
							String[] s={arreglo[x].getPelicula(),String.valueOf(arreglo[x].getCant()),String.valueOf(arreglo[x].getRatingTotal())};
							mt.addRow(s);
						}
						break;
					case "TODOS" :
						for(x=0;x<arreglo.length;x++) {
							String[] s={arreglo[x].getPelicula(),String.valueOf(arreglo[x].getCant()),String.valueOf(arreglo[x].getRatingTotal())};
							mt.addRow(s);
						}
						break;
				}
			}
		});
	}
	public void histoTabla(PelisUsuariosVotos[] arreglo) {
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				if (tabla.getSelectedRow()!=-1) { //cuando usamos el selector se ejecutaba histo tabla y la fila era -1 (no supimos como solucionarlo que no sea de esta forma)
					h.setAlturas(arreglo[tabla.getSelectedRow()].getArregloRating());
				}
			}
		});
	}
}