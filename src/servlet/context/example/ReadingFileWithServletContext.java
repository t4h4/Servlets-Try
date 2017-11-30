package servlet.context.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadingFileWithServletContext", urlPatterns = { "/ReadingFileWithServletContext" })
public class ReadingFileWithServletContext extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletContext context = getServletContext();
		
		InputStream txtStream = context.getResourceAsStream("/WEB-INF/taha.txt");
		InputStream propStream = context.getResourceAsStream("/WEB-INF/nameSurname.properties");
		
		Properties properties = new Properties();
		properties.load(propStream);
		
		System.out.println(properties.getProperty("name"));
		System.out.println(properties.getProperty("surname"));
		
		int content;
		ServletOutputStream servletOutputStream = response.getOutputStream(); //dosya okuma icin ozellestirilmis sinif
		while ((content = txtStream.read())!=-1) { //bos olmadigi surece
			servletOutputStream.write(content);
		}
		

	}
}
