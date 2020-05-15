package br.com.sprintters.prettystyle.command.address;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;

public class DeleteAddress implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
    	boolean isJson = false;
    	
		try {
			isJson = Boolean.parseBoolean(request.getParameter("json"));
			
    		int id = Integer.parseInt(request.getParameter("id_address"));

    		AddressService as = new AddressService();
    		
			Address obj = as.find(id);
			
			as.delete(obj);
			
    		if (isJson) {
				Json json = new Json(true, "Endereço excluído com sucesso!", as);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				
				response.sendRedirect("/PrettyStyle/App/pages/admin/save-address/save-addtress.jsp");
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
