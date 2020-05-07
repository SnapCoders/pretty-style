package br.com.sprintters.prettystyle.command.productdetails;

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

public class ViewProduct implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			String idUserStr = (String)request.getAttribute("idUser");
			
			int idUser = -1;
			
			if (idUserStr != null) {
				idUser = (int)request.getAttribute("idUser");
			}
			
			int idProduct = Integer.parseInt(request.getParameter("id_product"));
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			ProductService ps = new ProductService();
			UserService us = new UserService();
			
			User user = null;
			ClientProductLike cpl = null;
			Product product = ps.find(idProduct);
			
			if (idUser != -1) {
				user = us.find(idUser);
				cpl = ps.listFavoriteByIdUserAndIdProduct(user.getId(), idProduct);
				cpl.setProduct(product);
			}			
			
			if (isJson) {
				Json json = new Json(true, "", cpl);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				if (cpl != null) session.setAttribute("productDetails", cpl);
				session.setAttribute("product", product);
				
				response.sendRedirect("/PrettyStyle/App/pages/product-details/product-details.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
