package br.com.sprintters.prettystyle.command.cart;

import java.io.IOException;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.service.ItemService;

public class ListCart implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			int idUser = Integer.parseInt(request.getHeader("id_user"));
			
			ItemService is = new ItemService();
			
			Cart cart = is.listItemsInCartByIdClient(idUser);
    		
			Json json = new Json(true, "", cart);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
