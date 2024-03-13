package misservlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ContadorVisitas
 */
@WebServlet("/ContadorVisitas")
public class ContadorVisitas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ContadorVisitas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private int cantvis=0;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String Cont = req.getRequestId(); //este metodo te lo devuelve en hexa preguntar como transformar en int
		/*ServletContext context = getServletContext();
        Integer count = (Integer) context.getAttribute("totalCount");
        if (count == null) {
            count = 0;
        }

        // Increment the count and store it back in the application scope
        count++;
        context.setAttribute("totalCount", count);*/
		cantvis++;
		res.setContentType("text/html");
        PrintWriter printWriter = res.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Contador de visitas: </h1>");
        printWriter.print("<p>Este servlet lo visitaron: " + cantvis + " usuario/s</p>");
        printWriter.print("</html>");
        printWriter.print("</body>");
        printWriter.close();
        System.out.println("El nombre es: "+ cantvis);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
