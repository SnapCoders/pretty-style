package br.com.sprintters.prettystyle.command.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.service.AddressService;
import br.com.sprintters.prettystyle.service.ItemService;

public class ListCart implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)request.getAttribute("idUser");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			AddressService as = new AddressService();
			ItemService is = new ItemService();
			
			Cart cart = is.listItemsInCartByIdClient(idUser);
			Address address = as.findByIdUser(idUser);
			
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
				Json json = new Json(true, "", cart);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("cart", cart);
				session.setAttribute("quantity", quantity);
				session.setAttribute("totalItems", totalItems);
				session.setAttribute("frete", frete);
				session.setAttribute("total", total);
				session.setAttribute("bankSlip", bankSlip);
				session.setAttribute("zip", address.getZip());
				
				response.sendRedirect("/PrettyStyle/App/pages/cart/cart.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
