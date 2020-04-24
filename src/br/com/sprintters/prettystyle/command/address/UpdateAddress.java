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

public class UpdateAddress implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		
		try {
			String idUserStr = request.getParameter("id_user");
			String idAddressStr = request.getParameter("id_address");
			
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));

			int idUser = -1;
			int idAddress = Integer.parseInt(idAddressStr);

			try {
				idUser = Integer.parseInt(idUserStr);

			} catch (NumberFormatException e) {
				response.sendRedirect("/PrettyStyle/App/pages/sign-in/sign-in.jsp");
			}

			if (idUser != -1) {
				String pPlace = request.getParameter("place");
				String pNumber = request.getParameter("number");
				String pNeighborhood = request.getParameter("neighborhood");
				String pCity = request.getParameter("city");
				String pCountry = request.getParameter("country");
				String pZip = request.getParameter("zip");
				String pComplement = request.getParameter("complement");

				Address address = new Address();
				address.setId(idAddress);
				address.setPlace(pPlace);
				address.setNumber(pNumber);
				address.setNeighborhood(pNeighborhood);
				address.setCity(pCity);
				address.setCountry(pCountry);
				address.setZip(pZip);
				address.setComplement(pComplement);
				address.setIdUser(idUser);

				AddressService cs = new AddressService();
				
				cs.update(address);
					
				response.sendRedirect("/PrettyStyle/App/pages/profile-address/profile-address.jsp");
				if (isJson) {
					Json json = new Json(true, "Endereço atualizado com sucesso!", address);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
					
				} else {
					response.sendRedirect("/PrettyStyle/App/pages/edit-address/edit-address.jsp");
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
