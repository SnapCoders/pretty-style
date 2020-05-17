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
		boolean isJson = false;
		
		try {
			int idUser = (int)request.getAttribute("idUser");
			int idProduct = Integer.parseInt(request.getParameter("id_product"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			ItemService is = new ItemService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			Item item;
			
			if (user.isProvider())
				item = new Item(quantity, idProduct, user.getProvider().getId());
			else
				item = new Item(quantity, idProduct, user.getClient().getId());
				
			is.create(item);
			
			if (isJson) {
				Json json = new Json(true, "", null);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/controller.do?path=paymentsteps&command=PayStep");
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
