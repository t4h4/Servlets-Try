package servletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "initParamsWithNotation", urlPatterns = { "/initParamsWithNotation" }, initParams = {
		@WebInitParam(name = "tony stark", value = "iron man"),
		@WebInitParam(name = "steve rogers", value = "captain america") })
public class InitParamsWithNotation extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		ServletConfig config = getServletConfig(); // ServletConfig nesnesi config
		Enumeration<String> initParameterList = config.getInitParameterNames();

		while (initParameterList.hasMoreElements()) {
			String string = (String) initParameterList.nextElement();
			writer.write(" " + string + " "); //name ifadeleri teker teker yazdiriyoruz
		}

		writer.write(" " + config.getInitParameter("tony stark") + " "); //keyin valuesi yaziliyor
		writer.write(" " + config.getInitParameter("steve rogers") + " "); //keyin valuesi yaziliyor
	}
}
