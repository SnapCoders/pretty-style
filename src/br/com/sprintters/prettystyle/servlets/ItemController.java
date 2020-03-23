package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Item.do")
public class ItemController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pQuantity = Integer.parseInt(request.getParameter("quantity"));

        Item item = new Item();
        item.setQuantity(pQuantity);

        ItemService cs = new ItemService();
        
        try {
        	cs.create(item);
        	item = cs.find(item.getId());
        } catch (Exception e) {
        	e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("id: "+item.getId()+"<br>");
        out.println("quantity: "+item.getQuantity()+"<br>");
        out.println("idProduct: "+item.getIdProduct()+"<br>");
        out.println("</body></html>");
    }
}
