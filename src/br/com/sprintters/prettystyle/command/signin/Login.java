package br.com.sprintters.prettystyle.command.signin;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.JWTTokenService;
import br.com.sprintters.prettystyle.service.UserService;

public class Login implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			UserService userService = new UserService();
			
			User user = userService.login(username, password);
			
			if (user.getId() > 0) {
				if (user.isSigned()) {
					JWTTokenService jwt = new JWTTokenService();
					
					String name = "";
					
					HttpSession session = request.getSession();
					
					if (user.isProvider()) {
						name = user.getProvider().getFantasyName();
						session.setAttribute("isProvider", true);
					} else {
						name = user.getClient().getName();
					}
					
					String nameAndSurname = name + user.getUsername();
					
					String nameAndSurnameBase64 = Base64.getEncoder().encodeToString(nameAndSurname.getBytes());
					
					String bearerToken = "Bearer " + jwt.signJWT(user, name, nameAndSurnameBase64);
					
					session.setAttribute("token", bearerToken);
					session.setAttribute("name", "Olá, " + name);
					
					if (isJson) {
						Json json = new Json(true, "Olá " + name + ", seja bem vindo!", bearerToken);
			    		
			    		response.setContentType("application/json");
			    		response.getWriter().write(new Gson().toJson(json).toString());
					} else {
						response.sendRedirect("/PrettyStyle/index.jsp");
					}
				} else {
					Json json = new Json(false, "Login ou senha inválidos, verifique seus dados e tente novamente!", "error");
		    		
		    		response.setContentType("application/json");
		    		response.getWriter().write(new Gson().toJson(json).toString());
				}
			} else {
				Json json = new Json(false, "E-mail não encontrado, crie uma conta e faça parte da nossa rede.", "info");
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			}
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe houve uma falha na autenticação, estamos trabalhando para resolver este problema!", e);
			
			response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
