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
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;

public class CreateAddress implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		try {
			String idUserStr = request.getParameter("id_user");
			int pIdUser = Integer.parseInt(idUserStr);
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));

			int idUser = -1;

			HttpSession session = request.getSession();

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
				address.setPlace(pPlace);
				address.setNumber(pNumber);
				address.setNeighborhood(pNeighborhood);
				address.setCity(pCity);
				address.setCountry(pCountry);
				address.setZip(pZip);
				address.setComplement(pComplement);

				address.setIdUser(pIdUser);
				AddressService cs = new AddressService();

				try {
					cs.create(address);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (isJson) {
					Json json = new Json(true, "", address);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					
					response.sendRedirect("/PrettyStyle/App/pages/admin/save-address/save-address.jsp");
				}
			}

		} catch (Exception e) {
			JSONObject retorno = new JSONObject();

			retorno.put("success", false);
			retorno.put("message", "Erro ao salvar o Endereço!");
			retorno.put("stacktrace", e.getMessage());

			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}

	}

}
