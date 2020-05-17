package br.com.sprintters.prettystyle.command.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.service.AddressService;
import br.com.sprintters.prettystyle.service.ItemService;
import br.com.sprintters.prettystyle.service.UserService;

public class ListCart implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			AddressService as = new AddressService();
			ItemService is = new ItemService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			Cart cart;
			
			if (user.isProvider())
				cart = is.listItemsInCartByIdClient(user.getProvider().getId());
			else
				cart = is.listItemsInCartByIdClient(user.getClient().getId());
			
			Address address = as.findByIdUser(idUser);
			
			if (isJson) {
				Json json = new Json(true, "", cart);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("cart", cart);
				
				for (int i = 2; i <= 12; i++) request.setAttribute("parcela" + i, cart.getTotal() / i);
				
				session.setAttribute("zip", address.getZip());
				
				response.sendRedirect("/PrettyStyle/App/pages/cart/cart.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
