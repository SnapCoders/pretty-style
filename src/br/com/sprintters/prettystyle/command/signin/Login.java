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
			
			if (user.isSigned()) {
				JWTTokenService jwt = new JWTTokenService();
				
				String name = "";
				
				String nameAndSurname = name + user.getUsername();
				
				String nameAndSurnameBase64 = Base64.getEncoder().encodeToString(nameAndSurname.getBytes());
				
				String token = "Bearer " + jwt.signJWT(user, name, nameAndSurnameBase64);
				
				HttpSession session = request.getSession();
				
				if (user.isProvider()) {
					name = user.getProvider().getFantasyName();
					session.setAttribute("isProvider", true);
				} else {
					name = user.getClient().getName();
				}
				
				session.setAttribute("token", token);
				session.setAttribute("idUser", user.getId());
				
				if (isJson) {
					Json json = new Json(true, "Olá " + name + ", seja bem vindo!", token);
		    		
		    		response.setContentType("application/json");
		    		response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					response.sendRedirect("/PrettyStyle/index.jsp");
				}
			} else {
				Json json = new Json(false, "Login ou senha inválidos, verifique seus dados e tente novamente!", null);
	    		
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
