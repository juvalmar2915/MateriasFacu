package misservlets.practica2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.InitialContext;
/**
 * Servlet implementation class LoginUsr
 */
//@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	private Hashtable logins=new Hashtable <String, String>();
    public LoginUsr() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		logins.put(this.getInitParameter("usuario1"),this.getInitParameter("password1"));
		logins.put(this.getInitParameter("usuario2"),this.getInitParameter("password2"));
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Integer i=0;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String Nombre = req.getParameter("txtNombre");
		String Contra = req.getParameter("txtPsw");
		
        if (logins.get(Nombre)!=null){
        	String contra1=(String)logins.get(Nombre);
        	if (contra1.equals(Contra)) {
        		i++;
        		HttpSession sesion =req.getSession();
        		Persona p=new Persona(req.getParameter("nombreForm"),req.getParameter("postalForm"),Contra,Nombre);
        		
        		sesion.setAttribute("usuario"+i.toString(), p);
        		res.sendRedirect(res.encodeRedirectURL("Productos"));
        		
        	}
        	else {
        		System.out.println("Contrasena incorrecta");
        		res.sendRedirect(res.encodeRedirectURL("login.html"));
        	}
        }
        else {
        	System.out.println("usuario incorrecto");
        	res.sendRedirect(res.encodeRedirectURL("login.html"));
        }
	}

}
