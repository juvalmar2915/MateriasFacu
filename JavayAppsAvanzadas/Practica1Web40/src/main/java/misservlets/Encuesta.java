package misservlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class Encuesta
 */
@WebServlet("/Encuesta")
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Encuesta() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
        PrintWriter printWriter = res.getWriter();
        printWriter.print("<html>");
        printWriter.println("<HEAD>");
        printWriter.println("<TITLE> mascotas.html </TITLE>");
        printWriter.println("</HEAD>");
        printWriter.print("<body>");
        printWriter.println("<h2>que tipo de mascotas te gustan?</h2>");
        printWriter.println("<form method='post'>");
		printWriter.println("<label><input type='checkbox' name='mascotas' value='pri'>'Perro'</label>");
		printWriter.println("<label><input type='checkbox' name='mascotas' value='seg'>'Gato'</label>");
		printWriter.println("<label><input type='checkbox' name='mascotas' value='ter'>'Conejo'</label>");
		printWriter.println("<label><input type='checkbox' name='mascotas' value='cua'>'Hamster'</label>");
		printWriter.println("<label><input type='checkbox' name='mascotas' value='qui'>'Tortuga'</label>");
		printWriter.println("<label><input type='checkbox' name='mascotas' value='sex'>'Loro'</label>");
		printWriter.println("<INPUT TYPE='submit' NAME='enviar' VALUE='submit'>");
		printWriter.println("</form>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private int y=0;
	String[] mascotas = {"pri", "seg", "ter", "cua", "qui", "sex"};
	String[] m= {"Perro","Gato","Conejo","Hamster","Tortuga","Loro"};
	private int max=-999;
	private String animal= new String();
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i;
		int x;
		ServletContext context = getServletContext();
		if (y==0) {
			y=1;
			Integer [] cant=new Integer[6];
			for (i=0;i<6;i++) {
				cant[i]=0;
			}
			context.setAttribute("cantmasc", cant);
		}
		Integer [] cant = (Integer []) context.getAttribute("cantmasc");
		
		String[] masc = req.getParameterValues("mascotas");
		for (i=0;i<masc.length;i++) {
			for (x=0; x<6;x++) {
				if(masc[i].equals(mascotas[x])) {
					cant[x]++;
				}
			}
		}
		context.setAttribute("camtmasc", cant);
        // Increment the count and store it back in the application scope
        
		res.setContentType("text/html");
		PrintWriter printWriter = res.getWriter();
		printWriter.print("<table>");
		printWriter.print("<tr>");
		printWriter.print("<th>Mascota</th>"); 
		printWriter.print("<th>Cant votos</th>");
		printWriter.print("</tr>");
		printWriter.print("<tr>");
		printWriter.print("<td>Perro</td>");  
		printWriter.print("<td>"+ cant[0] +"</td>");  
		printWriter.print("</tr>");      
		printWriter.print("<tr>");
		printWriter.print("<td>Gato</td>");
		printWriter.print("<td>"+ cant[1]  +"</td>");    
		printWriter.print("</tr>");  
		printWriter.print("<tr>");
		printWriter.print("<td>Conejo</td>");
		printWriter.print("<td>"+ cant[2]  +"</td>");    
		printWriter.print("</tr>"); 
		printWriter.print("<tr>");
		printWriter.print("<td>Hamster</td>");
		printWriter.print("<td>"+ cant[3]  +"</td>");    
		printWriter.print("</tr>"); 
		printWriter.print("<tr>");
		printWriter.print("<td>Tortuga</td>");
		printWriter.print("<td>"+ cant[4]  +"</td>");    
		printWriter.print("</tr>"); 
		printWriter.print("<tr>");
		printWriter.print("<td>Loro</td>");
		printWriter.print("<td>"+ cant[5]  +"</td>");    
		printWriter.print("</tr>"); 
		printWriter.print("</table>"); 
		int total=0;
		for (i=0;i<6;i++) {
			if (cant[i]>max) {
				animal=m[i];
				max=cant[i];
			}
			total+=cant[i];
		}
		float porcentaje= ((float)(max/total))*100;
		printWriter.print("<h2> el animal mas votado es "+ animal +" con " +porcentaje+"%</h2>"); 
		printWriter.print("<a href=\"/Practica1Web40/Encuesta\">Volver a la encuesta</a>");
		printWriter.close();
		
	}

}
