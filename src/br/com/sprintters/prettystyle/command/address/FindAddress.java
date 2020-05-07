package br.com.sprintters.prettystyle.command.address;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;

public class FindAddress implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		try {
			int idUser = (int)request.getAttribute("idUser");
			int idAddress = Integer.parseInt(request.getParameter("id_address"));
			
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));

			HttpSession session = request.getSession();

			AddressService as = new AddressService();
			Address address = as.find(idAddress);

			User user = as.findListByIdUser(idUser);
			
			session.setAttribute("user", user);
			session.setAttribute("address", address);
			
			if (isJson) {
				Json json = new Json(true, "", user);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/edit-address/edit-address.jsp");
			}
		} catch (Exception e) {
			JSONObject retorno = new JSONObject();

			retorno.put("success", false);
			retorno.put("message", "Erro ao carregar o Endereço!");
			retorno.put("stacktrace", e.getMessage());

			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
		
	}

}
