package web;


import model.Cart;
import model.Fan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/Cart", "/Cart/delete"})
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if(action.equals("/Cart/delete")){
			deleteFromCart(req, resp);
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Shop/cart.jsp");
		requestDispatcher.forward(req, resp);
	}




	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addToCart(req, resp);
		resp.sendRedirect(req.getHeader("referer"));
	}

	public void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		List<Fan> fanList = cart.getFans();
		String model = req.getParameter("model");
		String producer = req.getParameter("producer");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");

		Fan fanToCart = new Fan(model, producer, Integer.parseInt(quantity), Double.parseDouble(price));

		if(!fanList.isEmpty() && fanList.contains(fanToCart)){
			int index = fanList.indexOf(fanToCart);
			fanToCart.setQuantity(Integer.parseInt(quantity) + fanList.get(index).getQuantity());
			fanList.set(index, fanToCart);
		}
		else fanList.add(fanToCart);

		session.setAttribute("fanList", cart.getFans());
		session.setAttribute("cart", cart);
	}

	private void deleteFromCart(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		List<Fan> fanList = cart.getFans();
		String model = req.getParameter("model");
		String producer = req.getParameter("producer");
		fanList.remove(new Fan(model, producer, 1, 1.0));

		session.setAttribute("fanList", cart.getFans());
		session.setAttribute("cart", cart);
	}
}
