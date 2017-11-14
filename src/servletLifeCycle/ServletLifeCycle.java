package servletLifeCycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifeCycle")
public class ServletLifeCycle extends HttpServlet {
	@Override
	public void init() {
		System.out.println("Init metodu cagrildi.");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.write("Servlet Yasam Dongusu.");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet destroy edildi.");
	}

}
