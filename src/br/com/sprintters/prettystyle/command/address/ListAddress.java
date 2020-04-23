package br.com.sprintters.prettystyle.command.address;

import java.io.IOException;
import java.util.ArrayList;

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

public class ListAddress implements Command {

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
				

					AddressService as = new AddressService();
					
					User user = as.findListByIdUser(idUser);
					ArrayList<Address> lista = user.getAddresses(); 
					ArrayList<Address> listAddress1 = new ArrayList<Address>(lista.subList(0, (lista.size()/2)));
					ArrayList<Address> listAddress2 = new ArrayList<Address>(lista.subList(lista.size()/2, lista.size()));
					session.setAttribute("lista1", listAddress1);
					session.setAttribute("lista2", listAddress2);
					session.setAttribute("user", user);
					

				
				if (isJson) {
					Json json = new Json(true, "", user);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					response.sendRedirect("/PrettyStyle/App/pages/profile-address/profile-address.jsp");
				}
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
