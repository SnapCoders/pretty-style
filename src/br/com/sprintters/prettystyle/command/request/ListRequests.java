package br.com.sprintters.prettystyle.command.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;
import br.com.sprintters.prettystyle.service.RequestService;

public class ListRequests  implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
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
    		
				RequestService rs = new RequestService();

				session.setAttribute("lista", rs.listRequestsByIdClient(idUser));
	    		
				response.sendRedirect("/PrettyStyle/App/pages/requests/requests.jsp");
	    		if (isJson) {
					Json json = new Json(true, "", rs);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					
					response.sendRedirect("/PrettyStyle/App/pages/requests/requests.jsp");
				}

				
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
