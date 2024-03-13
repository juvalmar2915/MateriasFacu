package misservlets.practica2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.InitialContext;

/**
 * Servlet implementation class Productos
 */
//@WebServlet("/Productos")
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Productos() {
        // TODO Auto-generated constructor stub
    }
    //int cantp; //getinitparameter no puede usarse en variables globales solo instanciado en metodos
    /*@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cantp=Integer.parseInt(this.getInitParameter("cant_total"));
		
	}*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//manera de la practica 2 de hacer este ej
		/*
		HttpSession sesion =req.getSession();
		if (sesion !=null) {
			String[] cantidad;
			cantidad= (String [])sesion.getAttribute("Nombregs");
			if (cantidad==null) {
				int x;
				cantidad=new String[cantp];
				for (x=1;x<=cantp;x++) {
					cantidad[x-1]="0";
				}
				sesion.setAttribute("Nombregs", cantidad);
			}
		res.setContentType("text/html");
		PrintWriter printWriter = res.getWriter();
		printWriter.print("<FORM METHOD=\'POST'>");
		printWriter.print("<table>");
		printWriter.print("<tr>");
		printWriter.print("<td>Golosina</td>"); 
		printWriter.print("<td>Precio u</td>");
		printWriter.print("<td>Cant comp</td>");
		printWriter.print("</tr>");
		Integer i;
		for (i=1;i<=cantp;i++) {
			printWriter.print("<tr>");
			printWriter.print("<td>"+this.getInitParameter("golosina"+i.toString())+"</td>"); 
			printWriter.print("<td>"+this.getInitParameter("pu"+i.toString())+"</td>"); 
			printWriter.print("<td>"+"<input type='text' name='Nombreg" + i + "' align='left' size='15' value='" + cantidad[i-1] + "'>"+"</td>");
			printWriter.print("</tr>");  
		}
		printWriter.print("</table>");
		printWriter.print("<INPUT TYPE='Submit' NAME='enviar' VALUE='enviar'>");
		printWriter.print("</form>");
		printWriter.print("<a href=\"/Practica2/TerminarSesion\">Salir</a>");
		printWriter.close();
		}else {
			res.sendRedirect("login.html");
		}*/
		//manera de la practica 3 de hacer este ej
		HttpSession sesion =req.getSession(false);
		ServletContext serv= req.getServletContext();
		if (sesion !=null) {
			String[]  cantidad=(String[]) sesion.getAttribute("Nombregs");
			if (cantidad==null) {
				cantidad=new String[(Integer)serv.getAttribute("Cantgolosinas")];
				int x;
				for (x=1;x<=cantidad.length;x++) {
					cantidad[x-1]="0";
				}
				sesion.setAttribute("Nombregs", cantidad);
			}
			res.setContentType("text/html");
			PrintWriter printWriter = res.getWriter();
			printWriter.print("<FORM METHOD=\'POST'>");
			printWriter.print("<table>");
			printWriter.print("<tr>");
			printWriter.print("<td>Golosina</td>"); 
			printWriter.print("<td>Precio u</td>");
			printWriter.print("<td>Cant comp</td>");
			printWriter.print("</tr>");
			Integer i;
			for (i=0;i<cantidad.length;i++) {
				printWriter.print("<tr>");
				printWriter.print("<td>"+serv.getAttribute("Golosina"+i.toString())+"</td>"); 
				printWriter.print("<td>"+serv.getAttribute("Precio"+i.toString())+"</td>"); 
				printWriter.print("<td>"+"<input type='text' name='Nombreg" + i + "' align='left' size='15' value='" + cantidad[i] + "'>"+"</td>");
				printWriter.print("</tr>");  
			}
			printWriter.print("</table>");
			printWriter.print("<INPUT TYPE='Submit' NAME='enviar' VALUE='enviar'>");
			printWriter.print("</form>");
			printWriter.print("<a href=\"/Practica2/TerminarSesion\">Salir</a>");
			printWriter.close();
		}else {
			res.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext serv= request.getServletContext();
		/*HttpSession sesion =request.getSession();
		
		String[] cantidad = new String[(Integer)serv.getAttribute("Cantgolosinas")];
		Integer i;
		
		for (i=0;i<cantidad.length;i++) {
			//sesion.setAttribute("golosina"+i.toString(), this.getInitParameter("golosina"+i.toString()));
			//sesion.setAttribute("pu"+i.toString(), this.getInitParameter("pu"+i.toString()));
			cantidad[i]=request.getParameter("Nombreg"+i.toString());
		}
		sesion.setAttribute("Nombregs", cantidad);*/
		//response.sendRedirect("Facturar");
		RequestDispatcher d= serv.getRequestDispatcher("/Facturar");
		if (d!=null)d.forward(request, response);
	}

}
