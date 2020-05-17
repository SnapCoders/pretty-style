package br.com.sprintters.prettystyle.command.address;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.UserAddress;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.AddressService;

public class UpdateDefaultAddress implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		boolean isJson = false;
		
		try {
			int idUser = (int)request.getAttribute("idUser");
			int idAddress = Integer.parseInt(request.getParameter("addressId"));
			isJson = Boolean.parseBoolean(request.getParameter("json"));

			UserAddress userAddress = new UserAddress(idUser, idAddress);
			
			AddressService cs = new AddressService();
			
			cs.updateDefaultAddress(userAddress);
			
			if (isJson) {
				Json json = new Json(true, "Endereço principal atualizado com sucesso!", userAddress);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
				
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/profile-address/profile-address.jsp");
			}
		} catch (Exception e) {
			if (isJson) {
    			Json json = new Json(false, "Desculpe, houve um erro ao atualizar o endereço, verifique seus dados e tente novamente!", e);
        		
        		response.setContentType("application/json");
        		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/error/500.jsp");
			}
		}
	}
}
