package misservlets;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class Bienvenida
 */
@WebServlet("/Bienvenida")
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Bienvenida() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> saludo.html </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H1>Ingrese su nombre: </H1>");
		out.println("<form method='post'>");  // aca hubo que aclarar que usamos post para llamar al metodo
		out.println("<INPUT TYPE='Text' NAME='txtNombre' ALIGN='LEFT' SIZE='15'>");
		out.println("<INPUT TYPE='submit' NAME='enviar' VALUE='submit'>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Nombre = req.getParameter("txtNombre");
		res.setContentType("text/html");
        PrintWriter printWriter = res.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Formulario nombre: </h1>");
        printWriter.print("<p> Nombre : " + Nombre + "</p>");
        printWriter.print("</html>");
        printWriter.print("</body>");
        printWriter.close();
        System.out.println("El nombre es: "+ Nombre);
	}
// en WEB-INF\classes van los java class files y jars
// es local e cada computadora
// e se pregunta el miercoles

}
