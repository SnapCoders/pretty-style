package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Quantity;
import br.com.sprintters.prettystyle.service.QuantityService;

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

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String pQuantity = request.getParameter("quantity");

            Item item = new Item();
            item.setQuantity(pQuantity);

            QuantityService cs = new QuantityService();
            cs.create(quantity);
            quantity = cs.find(quantity.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("id: "+quantity.getId()+"<br>");
            out.println("quantity: "+quantity.getQuantity()+"<br>");
            out.println("idProduct: "+quantity.getIdProduct()+"<br>");
            out.println("</body></html>");

        }

    }

