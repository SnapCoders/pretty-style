package br.com.sprintters.prettystyle.command.address;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;

public class DeleteAddress implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
    	try {
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
    		int id = Integer.parseInt(request.getParameter("id_address"));

    		AddressService as = new AddressService();
    		
			Address obj = as.find(id);
			as.delete(obj);
			
    		if (isJson) {
				Json json = new Json(true, "", as);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				
				response.sendRedirect("/PrettyStyle/App/pages/admin/save-address/save-address.jsp");
			}
    	} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Erro ao Deletar o Endereço!");
			retorno.put("stacktrace", e.getMessage());
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
		
	}

}
