package br.com.sprintters.prettystyle.command.address;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;

public class ListAddress implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		boolean isJson = false;
		
		try {
			int idUser = (int)request.getAttribute("idUser");
			isJson = Boolean.parseBoolean(request.getParameter("json"));

			AddressService as = new AddressService();
			
			User user = as.findListByIdUser(idUser);
			
			ArrayList<Address> lista = user.getAddresses();
								
			if (isJson) {
				Json json = new Json(true, "", user);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				HttpSession session = request.getSession();
				
				session.setAttribute("lista", lista);
				session.setAttribute("user", user);
				
				response.sendRedirect("/PrettyStyle/App/pages/profile-address/profile-address.jsp");
			}
		} catch (Exception e) {
			if (isJson) {
    			Json json = new Json(false, "Desculpe, houve um erro ao carregar os endereços, estamos trabalhando para corrigir este problema!", e);
        		
        		response.setContentType("application/json");
        		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/error/500.jsp");
			}
		}
	}
}
