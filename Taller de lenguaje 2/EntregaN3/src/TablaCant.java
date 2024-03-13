import java.awt.*;
import javax.swing.*;

import javax.swing.border.Border;
public class TablaCant extends JPanel{
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	
	public TablaCant(){
		this.setLayout(new GridLayout(2,3));
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		l1=new JLabel("???",SwingConstants.CENTER);
		l1.setBorder(border);
		l1.setBackground(Color.LIGHT_GRAY);
		l1.setOpaque(true);
		l2=new JLabel("???",SwingConstants.CENTER);
		l2.setBorder(border);
		l2.setBackground(Color.LIGHT_GRAY);
		l2.setOpaque(true);
		l3=new JLabel("???",SwingConstants.CENTER);
		l3.setBorder(border);
		l3.setBackground(Color.LIGHT_GRAY);
		l3.setOpaque(true);
		l4=new JLabel("Usuarios",SwingConstants.CENTER);
		l4.setBorder(border);
		l4.setBackground(Color.LIGHT_GRAY);
		l4.setOpaque(true);
		l5=new JLabel("Peliculas",SwingConstants.CENTER);
		l5.setBorder(border);
		l5.setBackground(Color.LIGHT_GRAY);
		l5.setOpaque(true);
		l6=new JLabel("Cant. de votos",SwingConstants.CENTER);
		l6.setBorder(border);
		l6.setBackground(Color.LIGHT_GRAY);
		l6.setOpaque(true);
		this.add(l1);
		this.add(l2);
		this.add(l3);
		this.add(l4);
		this.add(l5);
		this.add(l6);
	}
	public void actualizar(int x, int y, int z) {
		l1.setText(String.valueOf(x));
		l2.setText(String.valueOf(y));
		l3.setText(String.valueOf(z));
	}
}
