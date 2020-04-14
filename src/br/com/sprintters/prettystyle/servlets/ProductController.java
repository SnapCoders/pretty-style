package br.com.sprintters.prettystyle.servlets;

import java.io.IOException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.service.ProductService;

@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@HttpMethodConstraint("GET")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@HttpMethodConstraint("POST")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pName = request.getParameter("name");
		String pDescription = request.getParameter("description");
		Double pPrice = Double.parseDouble(request.getParameter("price"));
		int idMark = Integer.parseInt(request.getParameter("idMark"));

		Product product = new Product(pName, pDescription, pPrice, idMark);
		
		ProductService cs = new ProductService();

		try {
			cs.create(product);
			
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", true);
			retorno.put("message","Cadastro realizado com sucesso!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Erro ao cadastrar!");
			retorno.put("stacktrace", e.getMessage());
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
	}
	
	@HttpMethodConstraint("DELETE")
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getQueryString());
			
			ProductService ps = new ProductService();
		
			Product obj = ps.find(id);
			ps.delete(obj);
			
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", true);
			retorno.put("message","Registro excluído com sucesso!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Erro ao Deletar o Registro!");
			retorno.put("stacktrace", e.getMessage());
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
	}
}
