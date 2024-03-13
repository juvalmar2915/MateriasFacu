package misservlets;
import java.util.*;

import javax.persistence.EntityManager;
public interface IVisitanteDAO {
	public List<Presupuesto> getPresupuestos();
	public void conexion();
	public Presupuesto getPresupuesto(String mail);
	public void guardarPresupuesto(Presupuesto presupuesto);
	public void modificarPresupuesto(Presupuesto presupuesto);
	public void desconexion();
	//public void eliminarPresupuesto(Presupuesto presupuesto);
	
}
