package web;

import model.Fan;
import service.WarehouseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/Warehouse","/Warehouse/new","/Warehouse/create","/Warehouse/delete","/Warehouse/edit","/Warehouse/update"})
public class WarehouseServlet extends HttpServlet {
    WarehouseServiceImpl wsi = new WarehouseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        try {
            switch (action) {
                case "/Warehouse/new" -> showNewForm(req, resp);
                case "/Warehouse/create" -> createFan(req, resp);
                case "/Warehouse/delete" -> deleteFan(req, resp);
                case "/Warehouse/edit" -> showEditForm(req, resp);
                case "/Warehouse/update" -> update(req, resp);
                default -> listFan(req, resp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void listFan(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Fan> listFan = wsi.findAll();
        request.setAttribute("listFan", listFan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Warehouse/Warehouse.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Warehouse/GoodsAddForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Fan existingFan = wsi.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Warehouse/GoodsAddForm.jsp");
        request.setAttribute("fan", existingFan);
        dispatcher.forward(request, response);

    }

    private void createFan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String modelName = request.getParameter("modelName");
        String producerName = request.getParameter("producerName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double volume = Double.parseDouble(request.getParameter("volume"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        int inOrder = Integer.parseInt(request.getParameter("inOrder"));
        String description = request.getParameter("description");
        Fan newFan = new Fan(modelName, producerName, quantity, volume, weight, inOrder, description);
        wsi.create(newFan);
        response.sendRedirect("/Warehouse");
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String modelName = request.getParameter("modelName");
        String producerName = request.getParameter("producerName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double volume = Double.parseDouble(request.getParameter("volume"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        int inOrder = Integer.parseInt(request.getParameter("inOrder"));
        int freeStock = quantity - inOrder;
        String description = request.getParameter("description");
        Fan updFan = new Fan(id, modelName, producerName, quantity, volume, weight, inOrder, freeStock, description);
        wsi.update(updFan);
        response.sendRedirect("/Warehouse");
    }

    private void deleteFan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        wsi.deleteById(id);
        response.sendRedirect("/Warehouse");

    }
}
