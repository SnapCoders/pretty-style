package br.com.sprintters.prettystyle.command.signin;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.JWTTokenService;
import br.com.sprintters.prettystyle.service.UserService;

public class Login implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
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
