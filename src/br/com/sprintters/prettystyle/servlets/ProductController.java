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

@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pName = request.getParameter("name");
		String pDescription = request.getParameter("description");
		Double pPrice = Double.parseDouble(request.getParameter("price"));

		Product product = new Product();
		product.setName(pName);
		product.setDescription(pDescription);
		product.setPrice(pPrice);

		ProductService cs = new ProductService();

		try {
			cs.create(product);
			product = cs.find(product.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cadastro de produto</title></head><body>");
		out.println("id: " + product.getId() + "<br>");
		out.println("name: " + product.getName() + "<br>");
		out.println("description: " + product.getDescription() + "<br>");
		out.println("price: " + product.getPrice() + "<br>");
		out.println("</body></html>");
	}
}
