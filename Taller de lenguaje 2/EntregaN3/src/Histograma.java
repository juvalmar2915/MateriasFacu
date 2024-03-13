import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Histograma extends JPanel {
	private int[] a=new int[6];
	
    public Histograma() {
        JLabel titulo=new JLabel("HISTOGRAMA",SwingConstants.CENTER);
        titulo.setFont(new Font("Histograma",6,20));
        this.add(titulo);
        this.add(new PanelDibujo());
    }
    public class PanelDibujo extends JPanel{
    	public PanelDibujo() {
    		setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(450,180));
            this.setBackground(Color.WHITE);
            repaint();
            this.setVisible(true);
        }
        @Override
	    public void paintComponent(Graphics g){
        	super.paintComponent(g);
        	Graphics2D grafico = (Graphics2D) g;
            grafico.setColor(Color.BLACK); 
            grafico.setStroke(new BasicStroke(3)); 
            grafico.drawLine(60, 150, 440, 150);
            grafico.drawLine(60, 10, 60, 150);   
            grafico.setFont(new Font("Fuente", 6,18));
	        grafico.drawString("0", 100, 175);
	        grafico.drawString("1", 170, 175);
	        grafico.drawString("2", 230, 175);
	        grafico.drawString("3", 290, 175);
	        grafico.drawString("4", 350, 175);
	        grafico.drawString("5", 410, 175);
	        int aux=0;
	        for (int i=0;i<=5;i++) {
	        	if(a[i]>aux) {
	        		aux=a[i];
	        	}
	        }
	        double x=1;
	        if (aux!=0) {
	        	x=(double)140/(double)aux;
	        }
	        grafico.drawString(String.valueOf((int)(aux*0.2)), 10, 140);
	        grafico.drawString(String.valueOf((int)(aux*0.4)), 10, 110);
	        grafico.drawString(String.valueOf((int)(aux*0.6)), 10, 80);
	        grafico.drawString(String.valueOf((int)(aux*0.8)), 10, 50);
	        grafico.drawString(String.valueOf(aux), 10, 20);
	        grafico.setColor(Color.blue);
	        grafico.fillRect(100, 150-(int)(a[0]*x), 15, (int)(a[0]*x)); 
	        grafico.fillRect(170, 150-(int)(a[1]*x), 15, (int)(a[1]*x));
	        grafico.fillRect(230, 150-(int)(a[2]*x), 15,(int) (a[2]*x));
	        grafico.fillRect(290, 150-(int)(a[3]*x), 15,(int) (a[3]*x));
	        grafico.fillRect(350, 150-(int)(a[4]*x), 15,(int) (a[4]*x));
	        grafico.fillRect(410, 150-(int)(a[5]*x), 15,(int) (a[5]*x));
	        }
	    }

    public void setAlturas(int[] ranks){
    	for (int x= 0; x<=5; x++) {
    		this.a[x] = ranks[x];
    	}
	    repaint();
    }
}

