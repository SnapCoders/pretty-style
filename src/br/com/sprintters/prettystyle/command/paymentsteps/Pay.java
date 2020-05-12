package br.com.sprintters.prettystyle.command.paymentsteps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.ItemRequest;
import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.service.ItemService;
import br.com.sprintters.prettystyle.service.RequestService;
import br.com.sprintters.prettystyle.service.UserService;

public class Pay implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			int idUser = (int)request.getAttribute("idUser");
			String typePayment = request.getParameter("paymentType");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			ItemService is = new ItemService();
			RequestService rs = new RequestService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			Cart cart = null;
			
			if(user.isProvider()) cart = is.listItemsInCartByIdClient(user.getProvider().getId());
			else cart = is.listItemsInCartByIdClient(user.getClient().getId());				
			
			ArrayList<Item> lista = cart.getItems();
			
			double total = 0.0;
			double totalItems = 0.0;
			double frete = 0.0;
			double bankSlip = 0.0;
			
			for (Item item : lista) {
				totalItems += item.getProduct().getPrice() * item.getQuantity();
				if (item.getProduct().getPrice() > 400) {
					frete += item.getProduct().getPrice() * 0.02;
				} else {
					frete += item.getProduct().getPrice() * 0.082;
				}
			}
			
			total = totalItems + frete;
			bankSlip = total - (total * 0.05);
  			
  			double totalPrice = 0.0;
  			
  			if (typePayment.equals("creditCard")) {
  				int numberParcels = Integer.parseInt(request.getParameter("cardParcels"));
  				if (numberParcels == 1) {
  					totalPrice = bankSlip;
  				}
				else {
					totalPrice = total;
				}
  			} else {
  				totalPrice = total;
  			}
  			
  			UUID uuidRandom = UUID.randomUUID();
  			
  			String idClientPadded = "";
  			
  			if(user.isProvider()) idClientPadded = String.format("%03d" , user.getProvider().getId());
  			else idClientPadded = String.format("%03d" , user.getClient().getId());
  			
  			
  			String numberRequest = idClientPadded + "-" + uuidRandom.toString();
  			
  			Request req = null;
  			if(user.isProvider()) {
  				req = new Request(user.getProvider().getId(), totalPrice, numberRequest.toString(), typePayment);  				
  				int idRequest = rs.create(req);
  				
  				for (Item item : lista) {
  					ItemRequest ir = new ItemRequest();
  					ir.setIdRequest(idRequest);
  					ir.setIdItem(item.getId());
  					rs.createItemRequest(ir);
  					if(user.isProvider()) item.setIdClient(user.getProvider().getId());
  					else item.setIdClient(user.getClient().getId());
  					is.setItemPaid(item);
  				}
  			}
  			else {
  				req = new Request(user.getClient().getId(), totalPrice, numberRequest.toString(), typePayment);  				
  				int idRequest = rs.create(req);
  				
  				for (Item item : lista) {
  					ItemRequest ir = new ItemRequest();
  					ir.setIdRequest(idRequest);
  					ir.setIdItem(item.getId());
  					rs.createItemRequest(ir);
  				}
  				
  			}
			
			if (isJson) {
				Json json = new Json(true, "", lista);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				HttpSession session = request.getSession();
				
				session.setAttribute("numberRequest", numberRequest);
				if(user.isProvider()) {
					session.setAttribute("numberClient", user.getProvider().getId());
					session.setAttribute("clientName", user.getProvider().getFantasyName());
				}
				else {
					session.setAttribute("numberClient", user.getClient().getId());
					session.setAttribute("clientName", user.getClient().getName());
					session.setAttribute("clientSurname", user.getClient().getSurname());					
				}
				
				response.sendRedirect("/PrettyStyle/App/pages/thanks/thanks.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
