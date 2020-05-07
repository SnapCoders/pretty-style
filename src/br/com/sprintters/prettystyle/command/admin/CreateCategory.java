package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.CategoryService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateCategory implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String pName = request.getParameter("name");
	        String pColor = request.getParameter("color");
	        int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			UserService us = new UserService();;
			
			User user = us.find(idUser);
			
			Category category = new Category();
			
	        category.setName(pName);
	        category.setColor(pColor);
	        category.setIdProvider(user.getProvider().getId());
	
	        CategoryService cs = new CategoryService();
        
        	cs.create(category);
        	category = cs.find(category.getId());
			
			if (isJson) {
				Json json = new Json(true, "Categoria cadastrada com sucesso!", category);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/product-details/product-details.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
