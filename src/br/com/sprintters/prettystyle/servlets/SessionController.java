package br.com.sprintters.prettystyle.servlets;

import java.util.Base64;
import java.io.IOException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.HttpMethodConstraint;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.UserService;
import br.com.sprintters.prettystyle.service.JWTTokenService;

@WebServlet("/sessions")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@HttpMethodConstraint("GET")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService service = new UserService();
			
			User user = service.find(3);
			
			user.setPassword("123456");
			
			service.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@HttpMethodConstraint("POST")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserService userService = new UserService();
			
			User user = userService.login(username, password);
			
			if (user.isSigned()) {
				JWTTokenService jwt = new JWTTokenService();
				
				String name = "";
				
				if (user.isProvider()) {
					name = user.getProvider().getFantasyName();
				} else {
					name = user.getClient().getName();
				}
				
				String nameAndSurname = name + user.getUsername();
				
				String nameAndSurnameBase64 = Base64.getEncoder().encodeToString(nameAndSurname.getBytes());
				
				String token = jwt.signJWT(user, name, nameAndSurnameBase64);
				
				JSONObject retorno = new JSONObject();
				
				retorno.put("success", true);
				retorno.put("message", "Olá " + name + ", seja bem vindo!");
				retorno.put("token", token);
				
				response.setContentType("application/json");
				response.getWriter().write(retorno.toString());
			} else {
				JSONObject retorno = new JSONObject();
				
				retorno.put("success", false);
				retorno.put("message", "Login ou senha inválidos, verifique seus dados e tente novamente!");
				
				response.setContentType("application/json");
				response.getWriter().write(retorno.toString());
			}
		} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Desculpe houve uma falha na autenticação, estamos trabalhando para resolver este problema!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
	}
}
