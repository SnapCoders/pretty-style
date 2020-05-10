package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductService;

public class LaunchNewQuantity implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

		boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));
		int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
		
		ProductService ps = new ProductService();
		
		ps.updateQuantity(idProduct, newQuantity);
		
		if (isJson) {
			Json json = new Json(true, "Quantidade atualizada com sucesso!", null);
			
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(json).toString());
		} else {			
			response.sendRedirect("/PrettyStyle/App/pages/admin/list-quantities/list-quantities.jsp");
		}
		
	}

}
