package br.com.sprintters.prettystyle.command.favorites;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateFavorite implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)request.getAttribute("idUser");
			int idProduct = Integer.parseInt(request.getParameter("id_product"));
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			ProductService ps = new ProductService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			Product product = ps.find(idProduct);
			
			ClientProductLike cpl = new ClientProductLike(user.getId(), product.getId(), 1); 
			
			ps.createFavorite(cpl);
			
			cpl.setProduct(product);
			
			if (isJson) {
				Json json = new Json(true, "Este produto foi adicionado aos seus favoritos!", cpl);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("productDetails", cpl);
				
				response.sendRedirect("/PrettyStyle/App/pages/product-details/product-details.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
