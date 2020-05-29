package br.com.sprintters.prettystyle.command.signup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Client;
import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.model.Provider;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateUser   implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
	        String username = request.getParameter("username");
	        String name = request.getParameter("name");
	        String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			String emailConfirmation = request.getParameter("emailConfirmation");
			
			Date birthday = new Date();
			
			if (request.getParameter("birthday") != null) {
				birthday = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("birthday"));
			}
			
			String sex = request.getParameter("sex");
			String password = request.getParameter("password");
			
			String cpf = request.getParameter("cpf");
			String tellphone = request.getParameter("telephone"); // 11 2222-4444
			String cellphone = request.getParameter("cellphone"); // 11 97686-8585
			
			// Business
			String fantasyName = request.getParameter("fantasyName");
			String socialReason = request.getParameter("socialReason");
			String cnpj = request.getParameter("cnpj");
			String contact = request.getParameter("contact");
			
			UserService service = new UserService();
			
			User user = new User(username, email, emailConfirmation);
			
			ArrayList<PhoneNumber> phones = new ArrayList<PhoneNumber>();
			
			int Tddd = 0;
			String Tphone = null;
			
			if(tellphone != "") {
				Tddd = Integer.parseInt(tellphone.substring(1, 3));
				Tphone = tellphone.substring(4, tellphone.length());
			}
			
			int Cddd = Integer.parseInt(cellphone.substring(1, 3));
			String Cphone = cellphone.substring(4, cellphone.length());
			
			// (\(?\d{2}\)?\s)?(\d{4,5}\-\d{4}) - valida��o de telefone celulares
			
			PhoneNumber TphoneNumber = new PhoneNumber();
			PhoneNumber CphoneNumber = new PhoneNumber();
			
			TphoneNumber.setDdd(Tddd);
			TphoneNumber.setNumber(Tphone);
			
			CphoneNumber.setDdd(Cddd);
			CphoneNumber.setNumber(Cphone);
			
			phones.add(TphoneNumber);
			phones.add(CphoneNumber);
			
			if (cpf == null && cnpj != null) {
				Provider provider = new Provider(cnpj, fantasyName, socialReason, contact);
				
				user.setProvider(provider);
			} else if (cpf != null && cnpj == null) {
				Client client = new Client(name, surname, cpf, birthday, sex);
				
				user.setClient(client);
			}
			
			user.setPhoneNumbers(phones);
			user.setPassword(password);
	        
			if (user != null) service.create(user);
			
			if (isJson) {
				Json json = new Json(true, "Seu perfil foi criado com sucesso!", user);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				
				response.sendRedirect("/PrettyStyle/App/pages/sign-up-business/sign-up-business.jsp");
			}
    	} catch (Exception e) {
    		if (e.getMessage().contains("Já existe um usuário com este e-mail cadastrado!")) {
    			Json json = new Json(false, e.getMessage(), "info");
    			
    			response.setContentType("application/json");
    			response.getWriter().write(new Gson().toJson(json).toString());
    		} else {
    			Json json = new Json(false, e.getMessage(), "error");
    			
    			response.setContentType("application/json");
    			response.getWriter().write(new Gson().toJson(json).toString());
    		}
		}
	}
}
