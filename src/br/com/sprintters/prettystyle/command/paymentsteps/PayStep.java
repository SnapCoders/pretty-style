package br.com.sprintters.prettystyle.command.paymentsteps;

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

public class PayStep implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			AddressService as = new AddressService();
			ItemService is = new ItemService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			Address address = as.findByIdUser(user.getId());
			Cart cart;
			
			if(user.isProvider())
				cart = is.listItemsInCartByIdClient(user.getProvider().getId());
			else
				cart = is.listItemsInCartByIdClient(user.getClient().getId());
			
			if (isJson) {
				Json json = new Json(true, "", cart);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				HttpSession session = request.getSession();
				
				session.setAttribute("address", address);
				session.setAttribute("cart", cart);
				session.setAttribute("user", user);
				
				for (int i = 2; i <= 12; i++) session.setAttribute("parcela" + i, cart.getTotal() / i);
				
				response.sendRedirect("/PrettyStyle/App/pages/payment-steps/payment-steps.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
