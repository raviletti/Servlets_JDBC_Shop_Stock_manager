package web;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/Cart", "/Cart/add"})
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		System.out.println(action);
		if (action.equals("/Cart/add")) {
			addGood(req, resp);
		} else {
			listCart(req, resp);
		}
	}




	private void addGood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String model = req.getParameter("model");
		//add to cart model logic
		System.out.println(model);
		resp.sendRedirect(req.getHeader("referer"));
	}

	private void listCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Shop/cart.jsp");
		requestDispatcher.forward(req, resp);

	}

}
