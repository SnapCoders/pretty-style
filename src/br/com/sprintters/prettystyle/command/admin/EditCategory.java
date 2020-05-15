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

public class EditCategory implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			int idCategory = Integer.parseInt(request.getParameter("idCategory"));
			String name = request.getParameter("name");
			
			
			//UserService us = new UserService();
			CategoryService cs = new CategoryService();
			
			Category category = new Category(idCategory, name);
			cs.update(category);
			
			if (isJson) {
				Json json = new Json(true, "Nome da categoria atualizado com sucesso", category);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/admin/admin.jsp");
			}
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, ocorreu um erro ao listar seus produtos, tente novamente!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}

}

