package servlet.context.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextClass extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletContext context = getServletContext();
		String emailAddress = context.getInitParameter("email");

		Enumeration<String> parameterNames = context.getInitParameterNames();

		PrintWriter writer = response.getWriter();
		writer.write(emailAddress);

		while (parameterNames.hasMoreElements()) {
			writer.write(" " + parameterNames.nextElement() + " ");
		}

		writer.close();

	}

}
