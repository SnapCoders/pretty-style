package br.com.sprintters.prettystyle.command.paymentsteps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ItemService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreatePayStep implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String idUserStr = request.getParameter("id_user");
			int idProduct = Integer.parseInt(request.getParameter("id_product"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			int idUser = -1;
			
			try {
				idUser = Integer.parseInt(idUserStr);
			} catch (NumberFormatException e) {
				response.sendRedirect("/PrettyStyle/App/pages/sign-in/sign-in.jsp");
			}
			
			if (idUser != -1) {
				ItemService is = new ItemService();
				UserService us = new UserService();
				
				User user = us.find(idUser);
				Item item = new Item(quantity, idProduct, user.getId());
				
				is.create(item);
				
				if (isJson) {
					Json json = new Json(true, "Este produto foi adicionado aos seus favoritos!", null);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					response.sendRedirect("/PrettyStyle/controller.do?path=paymentsteps&command=PayStep&id_user=" + idUser + "&token=" + request.getParameter("token"));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
