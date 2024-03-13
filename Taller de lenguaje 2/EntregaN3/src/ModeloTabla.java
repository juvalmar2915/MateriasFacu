import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel{
	public ModeloTabla(String[] t,String[][] m) {
		super(m, t);
	}
}
