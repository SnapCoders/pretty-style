package br.com.sprintters.prettystyle.command.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.UserService;

public class EditProfile implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			if (isJson) {
				Json json = new Json(true, "", user);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("user", user);
	    		
				if (user.isProvider()) response.sendRedirect("/PrettyStyle/App/pages/edit-profile-business/edit-profile-business.jsp");
				else response.sendRedirect("/PrettyStyle/App/pages/edit-profile-simple/edit-profile-simple.jsp");
			}
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, não foi possível listar os seus pedidos", e);
			
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
