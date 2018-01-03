package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestTutorial", urlPatterns = { "/requestTutorial" })
public class RequestTutorial extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();

		writer.write(request.getParameter("firstName") + " ");
		writer.write(request.getParameter("surName") + " ");
		writer.write(request.getParameter("marialStatus") + " ");
		String[] parameters = request.getParameterValues("progLang"); // checkbox coklu secim olabilir degerleri cektik,
																		// diziye aktardik.
		for (int i = 0; i < parameters.length; i++) {
			writer.write(" " + parameters[i] + " ");
		}
	}
}
