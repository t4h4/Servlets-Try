package servletConfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigClass extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig(); // ServletConfig nesnesini elde ettik.
		// simdi bur servlet config nesnesinden parametre elde edecegiz.
		response.getWriter().write("<html><body>");
		response.getWriter().write(config.getInitParameter("Genclerbirligi")); // key verilecek value dondurecek
		response.getWriter().write("<br/>");
		response.getWriter().write(config.getInitParameter("ageOf"));
		response.getWriter().write("<br/>");
		response.getWriter().write("Servlet Adi: " + config.getServletName());
		response.getWriter().write("</body></html>");
	}

}
