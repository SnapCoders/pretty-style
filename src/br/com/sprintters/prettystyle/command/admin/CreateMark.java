package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.MarkService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateMark implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String pName = request.getParameter("name");
			int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));

			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			Mark mark = new Mark();
	        mark.setName(pName);
	        mark.setIdProvider(user.getProvider().getId());

	        MarkService cs = new MarkService();
	        
	        cs.create(mark);
	        
        	mark = cs.find(mark.getId());
			
			if (isJson) {
				Json json = new Json(true, "Marca cadastrada com sucesso!", mark);
				
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
