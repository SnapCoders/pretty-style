package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.CategoryService;

public class CreateCategory implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String pName = request.getParameter("name");
	        String pColor = request.getParameter("color");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			Category category = new Category();
	        category.setName(pName);
	        category.setColor(pColor);
	
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
