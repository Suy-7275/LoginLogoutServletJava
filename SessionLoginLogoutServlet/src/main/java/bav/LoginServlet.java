package bav;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);
		
		String name=req.getParameter("uname");
		String password=req.getParameter("pass");
		
		if(password.equals("Ankur@123456")) 
		{
			pw.println("<h3 style='color:blue; text-align:center'>Welcome to login Page "+name+"</h3>");
			
			HttpSession htps=req.getSession();
			htps.setAttribute("name", name);
		
			
		}
		else 
		{
			pw.println("<h3 style='color:red; text-align:center'>Username or Password are Incorrect!!!</h3>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
	}

}
