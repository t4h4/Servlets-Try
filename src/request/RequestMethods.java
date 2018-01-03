package request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestMethods", urlPatterns = { "/requestMethods" })
public class RequestMethods extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.write("<html><body>");
		String serverName = request.getServerName(); // Uygulamanin uzerinde calistigi sunucu adini dondurur.
		String hostHeaderInfo = request.getHeader("host"); // Request Header icerisindeki host bilgisini dondurur.
		int serverPort = request.getServerPort(); // Yapilmis olan istegin sunucuda hangi porttan basladigini dondurur.
		// Istegin basladigi port.
		int locaPort = request.getLocalPort(); // Yapilmis olan istedigin tamamlandigi porttur.
		int remotePort = request.getRemotePort(); // Tarayicinin hangi porta istekte bulundugu porttur.
		String method = request.getMethod(); // Istegi hangi metodla yapildigini dondurur.
		String contextPath = request.getContextPath(); // ContextPath bilgisini dondurur.
		Enumeration<String> headerNames = request.getHeaderNames();
		writer.write(serverName + "<br/>");
		writer.write(hostHeaderInfo + "<br/>");
		writer.write(locaPort + "<br/>");
		writer.write(remotePort + "<br/>");
		writer.write(method + "<br/>");
		writer.write(contextPath + "<br/>");
		writer.write("</body></html>");
		while (headerNames.hasMoreElements()) {
			String string = (String) headerNames.nextElement();
			writer.write(string + "<br/>");
		}
		writer.close();
	}
}
