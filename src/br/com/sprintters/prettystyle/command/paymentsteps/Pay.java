package br.com.sprintters.prettystyle.command.paymentsteps;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.service.AddressService;
import br.com.sprintters.prettystyle.service.ItemService;

public class Pay implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String idUserStr = request.getParameter("id_user");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			int idUser = -1;
			
			HttpSession session = request.getSession();
			
			try {
				idUser = Integer.parseInt(idUserStr);
				
			} catch (NumberFormatException e) {
				response.sendRedirect("/PrettyStyle/App/pages/sign-in/sign-in.jsp");
			}
			
			if (idUser != -1) {
				AddressService as = new AddressService();
				ItemService is = new ItemService();
						
				Cart cart = is.listItemsInCartByIdClient(idUser);
				
				ArrayList<Item> lista = cart.getItems();
				
				int quantity = 0;
				double total = 0.0;
				double totalItems = 0.0;
				double frete = 0.0;
				double bankSlip = 0.0;
				
				for (Item item : lista) {
					quantity += item.getQuantity();
					totalItems += item.getProduct().getPrice() * item.getQuantity();
					if (item.getProduct().getPrice() > 400) {
						frete += item.getProduct().getPrice() * 0.02;
					} else {
						frete += item.getProduct().getPrice() * 0.082;
					}
				}
				
				total = totalItems + frete;
				bankSlip = total - (total * 0.05);
	  			
	  			for (int i = 2; i <= 12; i++) {
		  			request.setAttribute("parcela" + i, total / i);
	  			}
	  			
	  			
				
				if (isJson) {
					Json json = new Json(true, "", lista);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					session.setAttribute("address", as.findByIdUser(1));
					session.setAttribute("quantity", quantity);
					session.setAttribute("totalItems", totalItems);
					session.setAttribute("frete", frete);
					session.setAttribute("total", total);
					session.setAttribute("bankSlip", bankSlip);
					
					for (int i = 2; i <= 12; i++) {
						session.setAttribute("parcela" + i, total / i);
		  			}
					
					response.sendRedirect("/PrettyStyle/App/pages/thanks/thanks.jsp");
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
