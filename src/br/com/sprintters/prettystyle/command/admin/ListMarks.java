package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.MarkService;
import br.com.sprintters.prettystyle.service.UserService;

public class ListMarks implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)session.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));

			UserService us = new UserService();
			MarkService ms = new MarkService();
			
			User user = us.find(idUser);
			ArrayList<Mark> marks = ms.listByIdProvider(user.getProvider().getId());
			
			if (isJson) {
				Json json = new Json(true, "", marks);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("marks", marks);
				
				response.sendRedirect("/PrettyStyle/App/pages/admin/list-marks/list-marks.jsp");
			}
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, ocorreu um erro ao listar suas marcas, tente novamente!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
