package bav;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);
		
		HttpSession htps=req.getSession(false);
		if(htps!=null) 
		{
			String n=(String) htps.getAttribute("name");
			pw.println("<h3 style='color:blue; text-align:center'>Welcome to Profile Page "+n+"</h3>");
			
		}
		else 
		{
			pw.println("<h3 style='color:red; text-align:center'>Please Login First to visit Profile Page!!!</h3>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
	}
	

}
