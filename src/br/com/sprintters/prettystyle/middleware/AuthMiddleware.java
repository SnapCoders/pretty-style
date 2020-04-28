package br.com.sprintters.prettystyle.middleware;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.UserService;

public class AuthMiddleware  {
	public boolean auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			boolean isAuth = false;
			
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
						
			int idUser = -1;
			String token = "";
			
			try {
				idUser = (int)session.getAttribute("idUser");
				token = (String)session.getAttribute("token");
			} catch (NumberFormatException e) {
				isAuth = false;
			}
			
			if (idUser != -1 && token != null) {
				String[] str = token.split(" ", 2);
				
				if (str[0].equals("Bearer")) { // acressentar no if a verificação do token
					if (idUser != -1) {
						UserService us = new UserService();
						
						User user = us.find(idUser);
						
						if (user != null) isAuth = true;
					}
				}
			}
			
			return isAuth;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
