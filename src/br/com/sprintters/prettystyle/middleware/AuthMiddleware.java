package br.com.sprintters.prettystyle.middleware;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.UserService;

public class AuthMiddleware  {
	public boolean auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			boolean isAuth = false;
			
			request.setCharacterEncoding("UTF-8");
			
			String idUserStr = request.getParameter("id_user");
			String tokenStr = request.getParameter("token");
			
			int idUser = -1;
			
			try {
				idUser = Integer.parseInt(idUserStr);
			} catch (NumberFormatException e) {
				isAuth = false;
			}
			
			if (idUserStr != null && tokenStr != null) {
				String[] str = tokenStr.split(" ", 2);
				
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
