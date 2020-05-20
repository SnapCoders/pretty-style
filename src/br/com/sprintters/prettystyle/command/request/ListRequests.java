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
		boolean isJson = false;
		
		try {
			HttpSession session = request.getSession();
			
    		int idUser = (int)request.getAttribute("idUser");
			isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			RequestService rs = new RequestService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			ArrayList<Request> requests = new ArrayList<>();
			
			if (user.isProvider()) requests = rs.listRequestsByIdClient(user.getProvider().getId());
			else requests = rs.listRequestsByIdClient(user.getClient().getId());

    		if (isJson) {
				Json json = new Json(true, "", rs);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("lista", requests);
	    		
				response.sendRedirect("/PrettyStyle/App/pages/requests/requests.jsp");
			}
    	} catch (Exception e) {
    		if (isJson) {
    			Json json = new Json(false, "Desculpe, houve um erro ao cadastrar o produto, verifique os dados e tente novamente!", e);
        		
        		response.setContentType("application/json");
        		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/error/500.jsp");
			}
		}
	}
}
