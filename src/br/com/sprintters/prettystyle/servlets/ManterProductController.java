package br.com.sprintters.prettystyle.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.service.ProductService;

@WebServlet("/ManterCliente.do")
public class ManterProductController extends HttpServlet {
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
        String pName = request.getParameter("name");
        String pDescription = request.getParameter("description");
        String pPrice = request.getParameter("price");

        Product product = new Product();
        product.setName(pName);
        product.setDescription(pDescription);
        product.setPrice(pPrice);

        ProductService cs = new ProductService();
        cs.criar(Product);
        Product = cs.carregar(Product.getId());

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cadastro de produto</title></head><body>");
        out.println("id: "+product.getId()+"<br>");
        out.println("name: "+product.getName()+"<br>");
        out.println("description: "+product.getDescription()+"<br>");
        out.println("price: "+product.getPrice()+"<br>");
        out.println("</body></html>");

    }

}
