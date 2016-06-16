package my.projekt.iba;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Erik Macej
 */
public class Servlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/helloIba.jsp").forward(request, response);
	
    }
}
