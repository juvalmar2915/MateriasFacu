package misservlets.practica2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.InitialContext;

/**
 * Servlet implementation class Facturar
 */
@WebServlet("/Facturar")
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Facturar() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=req.getSession(false);
		ServletContext serv= req.getServletContext();
		String []cantidad;
		//Integer totalgeneral=0;
		Double totalgeneral=0.00;
		Integer i;
		if (s!=null) {
			cantidad = new String[(Integer)serv.getAttribute("Cantgolosinas")];
			for (i=0;i<cantidad.length;i++) {
				cantidad[i]=req.getParameter("Nombreg"+i.toString());
			}
			s.setAttribute("Nombregs", cantidad);
			//cantidad =(String []) s.getAttribute("Nombregs");
			res.setContentType("text/html");
			PrintWriter printWriter = res.getWriter();
			printWriter.print("<table>");
			printWriter.print("<tr>");
			printWriter.print("<td>Golosina</td>"); 
			printWriter.print("<td>Cantidad Comprada</td>");
			printWriter.print("<td>Precio total</td>");
			printWriter.print("</tr>");
			int cantidad2;
			//int total;
			double total;
			for (i=0;i<cantidad.length;i++) {
				printWriter.print("<tr>");
				//printWriter.println("<td>"+s.getAttribute("golosina"+i.toString())+"</td>");
				printWriter.println("<td>"+serv.getAttribute("Golosina"+i.toString())+"</td>");
				printWriter.println("<td>"+cantidad[i]+"</td>");
				//total=Integer.parseInt((String) s.getAttribute("pu"+i.toString()));
				total=Double.parseDouble((String) serv.getAttribute("Precio"+i.toString()));
				cantidad2=Integer.parseInt(cantidad[i]);
				total=total*cantidad2;
				totalgeneral+=total;
				printWriter.println("<td>"+String.format("%.2f", total)+"</td>");
				printWriter.print("</tr>");
			}
			printWriter.print("</table>");
			printWriter.print("<h2>"+String.format("%.2f", totalgeneral)+"</h2>");
			printWriter.print("<a href="+res.encodeURL("/Practica2/Productos")+">Seguircomprando</a>");
			printWriter.print("<a href=\"/Practica2/TerminarSesion\">Salir</a>");
			printWriter.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
