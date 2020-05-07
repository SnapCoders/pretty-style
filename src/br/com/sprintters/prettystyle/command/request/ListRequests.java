package br.com.sprintters.prettystyle.command.request;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.RequestService;
import br.com.sprintters.prettystyle.service.UserService;

public class ListRequests  implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
    		int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			RequestService rs = new RequestService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			ArrayList<Request> requests = rs.listRequestsByIdClient(user.getClient().getId());

    		if (isJson) {
				Json json = new Json(true, "", rs);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("lista", requests);
	    		
				response.sendRedirect("/PrettyStyle/App/pages/requests/requests.jsp");
			}
    	} catch (Exception e) {
			Json json = new Json(false, "Desculpe, não foi possível listar os seus pedidos", null);
			
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
