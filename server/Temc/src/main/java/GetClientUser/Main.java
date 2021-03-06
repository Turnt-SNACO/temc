package GetClientUser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet("/main")
public class Main extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Set response content type and return an error message
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println("ERR");
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// Get received JSON data from HTTP request
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String jsonStr = "";
			if(br != null){
				jsonStr = br.readLine();
	      		}
			String output = new HandleUserData().work(jsonStr);
			if(output == null) {
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.println("ERR");
			}
			else {
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.println(output);
	      		}
		}catch(Exception e) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println("ERR");
		}
	}
}
