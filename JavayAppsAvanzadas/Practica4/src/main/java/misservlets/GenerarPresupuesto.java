package misservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class GenerarPresupuesto
 */
@WebServlet("/GenerarPresupuesto")
public class GenerarPresupuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GenerarPresupuesto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		Presupuesto p=new Presupuesto();
		PrintWriter out = res.getWriter();
		p.setMail((String)req.getParameter("mail"));
		p.setNombre((String)req.getParameter("txtNombre"));
		p.setSalon((String)req.getParameter("salon"));
		if (req.getParameter("catering").equals("si")) {
			p.setCatering(true);
		}
		else {
			p.setCatering(false);
		}
		p.setCantAsist(Integer.parseInt(req.getParameter("cantasist")));
		VisitanteDAO v=new VisitanteDAO();
		v.conexion();
		v.guardarPresupuesto(p);
		Presupuesto p2=new Presupuesto();
		p2= v.getPresupuesto(p.getMail());
		v.desconexion();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Formulario de Presupuesto </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h2>"+p2.getMail()+p2.getCantAsist()+"</h2>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
