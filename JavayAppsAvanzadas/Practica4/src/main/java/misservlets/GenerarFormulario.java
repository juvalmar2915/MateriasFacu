package misservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GenerarFormulario
 */
public class GenerarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Formulario de Presupuesto </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<form ACTION=\"http://localhost:8080/Practica4/GenerarPresupuesto\" method='get'>");
		out.println("<label for='cantasist'>Cant asistentes:</label>");
		out.println("<input type='number' id='cantasist' name='cantasist'><br>");
		out.println("<label for='salon'>Salón:</label>");
		out.println("<select id='salon' name='salon' required>");
		out.println("<option value='sala-a'>Sala Chica</option>");
		out.println("<option value='sala-b'>Sala Mediana</option>");
		out.println("<option value='sala-c'>Sala Grande</option></select><br>");
		out.println("<label for='catering'>Catering:</label>");
		out.println("<input type='checkbox' id='catering' name='catering' value='si'><br>");
		out.println("<label for='barra-libre'>Barra libre:</label>");
		out.println("<input type='checkbox' id='barra-libre' name='barra-libre' value='si'><br>");
		out.println("<label for='vino'>Vino:</label>");
		out.println("<input type='checkbox' id='vino' name='vino' value='si'><br>");
		out.println("<label for='champagne'>Champagne:</label>");
		out.println("<input type='checkbox' id='champagne' name='champagne' value='si'><br>");
		out.println("<label for='torta'>Torta:</label>");
		out.println("<input type='checkbox' id='torta' name='torta' value='si'><br>");
		out.println("<label for='animacion'>Animación de la boda y DJ:</label>");
		out.println("<input type='checkbox' id='animacion' name='animacion' value='si'><br>");
		out.println("<label for='ceremonia-flores'>Flores:</label>");
		out.println("<input type='checkbox' id='ceremonia-flores' name='ceremonia-flores' value='si'>");
		out.println("<label for='ceremonia-decoracion'>Decoración:</label>");
		out.println(" <input type='checkbox' id='ceremonia-decoracion' name='ceremonia-decoracion' value='si'>");
		out.println("<label for='ceremonia-sillas'>Sillas:</label>");
		out.println("<input type='checkbox' id='ceremonia-sillas' name='ceremonia-sillas' value='si'>");
		out.println("<label for='ceremonia-mesa'>Mesa:</label>");
		out.println("<input type='checkbox' id='ceremonia-mesa' name='ceremonia-mesa' value='si'>");
		out.println("<label for='ceremonia-alfombra'>Alfombra:</label>");
		out.println("<input type='checkbox' id='ceremonia-alfombra' name='ceremonia-alfombra' value='si'><br>");
		out.println("<label for='invitaciones'>Invitaciones:</label>");
		out.println("<input type='checkbox' id='invitaciones' name='invitaciones' value='si'><br>");
		out.println(" <label for='alianzas'>Alianzas:</label>");
		out.println("<input type='checkbox' id='alianzas' name='alianzas' value='si'><br>");
		out.println("<label for='servicio-video'>Servicio de Video y Fotografía:</label>");
		out.println(" <input type='checkbox' id='servicio-video' name='servicio-video' value='si'><br>");
		out.println("<label for='txtNombre'>Ingrese su nombre: </label>");
		out.println("<INPUT TYPE='Text' NAME='txtNombre' ALIGN='LEFT' SIZE='15'><br>");
		out.println("<label for='mail'>Ingrese su mail: </label>");
		out.println("<INPUT TYPE='Text' NAME='mail' ALIGN='LEFT' SIZE='15'><br>");
		out.println("<INPUT TYPE='submit' NAME='enviar' VALUE='submit'>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}