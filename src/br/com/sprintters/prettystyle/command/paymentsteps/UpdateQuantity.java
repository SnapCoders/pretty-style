package br.com.sprintters.prettystyle.command.paymentsteps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ItemService;

public class UpdateQuantity implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		boolean isJson = false;
		
		try {
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int productId = Integer.parseInt(request.getParameter("productId"));
			int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
			
			isJson = Boolean.parseBoolean(request.getParameter("json"));

			ItemService is = new ItemService();
			
			is.updateQuantityInItemFromCart(itemId, productId, newQuantity);
			
			if (isJson) {
				Json json = new Json(true, "Quantidade modificada com sucesso!", null);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/product-details/product-details.jsp");
			}
		} catch (Exception e) {
			if (isJson) {
    			Json json = new Json(false, "Desculpe, houve um erro ao alterar a quantidade, verifique os dados e tente novamente!", e);
        		
        		response.setContentType("application/json");
        		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/error/500.jsp");
			}
		}
	}
}
