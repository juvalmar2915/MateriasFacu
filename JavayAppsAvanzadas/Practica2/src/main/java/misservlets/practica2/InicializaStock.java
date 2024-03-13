package misservlets.practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InicializaStock
 *
 */
@WebListener
public class InicializaStock implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializaStock() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			ServletContext serv= sce.getServletContext();
			String recurso=serv.getInitParameter("stock");
			InputStream is = serv.getResourceAsStream(recurso);
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			int posComa=0;
			Integer i=0;
			String linea = r.readLine();
			while (linea != null) {
				posComa = linea.indexOf(",");
				String nom = linea.substring(0, posComa);
				String precio = linea.substring(posComa + 1);
				serv.setAttribute("Golosina"+i.toString(), nom);
				serv.setAttribute("Precio"+i.toString(), precio);
				linea = r.readLine();
				i++;
			}
			serv.setAttribute("Cantgolosinas", i);
		}
			catch (IOException e) {
			// TODO
			}
	}
	
}
