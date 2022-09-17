package web;

import model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/Calculator/Calculator.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        //add a service instead of model obj

        Calculator calcModel = new Calculator();
        String result = calcModel.calculating(
                request.getParameter("NumberOne"),
                request.getParameter("NumberTwo"),
                request.getParameter("operation"));
        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("/Calculator/CalculatorResult.jsp");
        rd.forward(request, response);
    }
}
