package misservlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginUsr() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String[] usr = {"jose", "pedro", "juan"};
    String[] psw = {"hola123", "pedroboca", "juanpincha"};
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String error = req.getParameter("error");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> login.html </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
	    if ("usuario_incorrecto".equals(error)) {
	    	out.println("<h2>usuario o contraseña incorrectos: </h2>");
	    }
		out.println("<H2>Ingrese su nombre y contraseña: </H2>");
		out.println("<form method='post'>"); 
		out.println("<INPUT TYPE='Text' NAME='txtNombre' ALIGN='LEFT' SIZE='15'>");
		out.println("<INPUT TYPE='Password' NAME='txtPsw' ALIGN='LEFT' SIZE='15'>");
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
		String Nombre = req.getParameter("txtNombre");
		String Contra = req.getParameter("txtPsw");
        int i;
        boolean logueo=false;
        for(i=0; i<3; i++) {
        	if (Nombre.equals(usr[i])) {
        		if(Contra.equals(psw[i])) {
        			logueo=true;
        			break;
        		}
        	}
        }
        if (logueo==false) {
        	res.reset();
            //res.setBufferSize(0);
            //res.setContentType(null);
            res.sendRedirect(req.getRequestURI() + "?error=usuario_incorrecto");
        }
        else {
        	res.sendRedirect("ContadorVisitas");
        }
        
	}

}
