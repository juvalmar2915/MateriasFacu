package misservlets;

import java.util.List;

import javax.persistence.*;

public class VisitanteDAO implements IVisitanteDAO {
	private EntityManager em;

    public void conexion() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
    	em = emf.createEntityManager();

    }

    public void guardarPresupuesto(Presupuesto presupuesto) {
        em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(presupuesto);
        etx.commit();
    }

    public Presupuesto getPresupuesto(String mail) {
        return em.find(Presupuesto.class, mail);
    }

    public List<Presupuesto> getPresupuestos() {
        TypedQuery<Presupuesto> query = em.createQuery("SELECT p FROM Presupuesto p", Presupuesto.class);
        return query.getResultList();
    }
    
	public void modificarPresupuesto(Presupuesto presupuesto) {
		
	};
	
	public void desconexion() {
		em.close();
	};
}
