package web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet({"/About","/Contact"})
public class AboutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		System.out.println(action);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/about.jsp");
		requestDispatcher.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action + " from post");
		String referer = req.getHeader("referer");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String message = req.getParameter("message");

		System.out.println("[" + name + "][Email: " + email + "]: " + message);
		System.out.println("From page: " + referer);
		resp.sendRedirect(referer);
	}


}
