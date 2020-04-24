package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductService;

public class DeleteProduct implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			ProductService ps = new ProductService();
		
			Product obj = ps.find(id);
			ps.delete(obj);
			
			Json json = new Json(true, "Produto excluído com sucesso!", null);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, ocorreu um erro ao deletar este produto, tente novamente!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
