package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.Client;
import br.com.sprintters.prettystyle.model.Provider;
import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.service.UserService;

import java.util.Date;
import java.util.ArrayList;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.HttpMethodConstraint;

import org.json.JSONObject;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @HttpMethodConstraint("GET")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPut(request, response);
    }

    @HttpMethodConstraint("POST")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
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
			
			int Tddd = Integer.parseInt(tellphone.substring(0, 2));
			String Tphone = tellphone.substring(2, tellphone.length());
			
			int Cddd = Integer.parseInt(cellphone.substring(0, 2));
			String Cphone = cellphone.substring(2, cellphone.length());
			
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
			
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", true);
			retorno.put("message", "Sua conta foi criada com sucesso!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
    	} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Desculpe houve uma falha na cria��o da sua conta, estamos trabalhando para resolver este problema!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
    }
    @HttpMethodConstraint("PUT")
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	        String username = request.getParameter("username");
	        String name = request.getParameter("name");
	        String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			String emailConfirmation = request.getParameter("emailConfirmation");
			Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("birthday"));
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
			
			int Tddd = Integer.parseInt(tellphone.substring(0, 2));
			String Tphone = tellphone.substring(2, tellphone.length());
			
			int Cddd = Integer.parseInt(cellphone.substring(0, 2));
			String Cphone = cellphone.substring(2, cellphone.length());
			
			// (\(?\d{2}\)?\s)?(\d{4,5}\-\d{4}) - valida��o de telefone celulares
			
			PhoneNumber TphoneNumber = new PhoneNumber();
			PhoneNumber CphoneNumber = new PhoneNumber();
			
			TphoneNumber.setDdd(Tddd);
			TphoneNumber.setNumber(Tphone);
			
			CphoneNumber.setDdd(Cddd);
			CphoneNumber.setNumber(Cphone);
			
			phones.add(TphoneNumber);
			phones.add(CphoneNumber);
			
			user.setPhoneNumbers(phones);
			user.setPassword(password);
			
			if (cpf == null && cnpj != null) {
				Provider provider = new Provider(cnpj, fantasyName, socialReason, contact);
				user.setProvider(provider);
			} else if (cpf != null && cnpj == null) {
				Client client = new Client(name, surname, cpf, birthday, sex);
				
				user.setClient(client);
			}
	        
			service.update(user);
			
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", true);
			retorno.put("message", "Sua conta foi criada com sucesso!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
    	} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Desculpe houve uma falha na cria��o da sua conta, estamos trabalhando para resolver este problema!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
    }
}
