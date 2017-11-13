package servletNotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
@WebServlet(urlPatterns = {"/hello","/merhaba"})
public class ServletWithNotation extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter writer = response.getWriter();
		writer.write("Hello Servlet World");
		
	}

}
