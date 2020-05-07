package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.CategoryService;
import br.com.sprintters.prettystyle.service.UserService;

public class ListCategories implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			UserService us = new UserService();
			CategoryService ms = new CategoryService();
			
			User user = us.find(idUser);
			ArrayList<Category> categories = ms.listByIdProvider(user.getProvider().getId());
			
			if (isJson) {
				Json json = new Json(true, "", categories);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("categories", categories);
				
				response.sendRedirect("/PrettyStyle/App/pages/admin/list-categories/list-categories.jsp");
			}
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, ocorreu um erro ao listar suas categorias, tente novamente!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
