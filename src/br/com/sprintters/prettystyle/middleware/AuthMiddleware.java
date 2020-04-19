package br.com.sprintters.prettystyle.middleware;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthMiddleware  {
	public boolean auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		return true;
		
//		boolean next = false;
//		
//		String token = request.getHeader("Authorization");
//		
//		if (token == null) return false;
//		else {
//			// chamar o serviço de JWT para verificar o token do usuário se é válido
//		}
//		
//		
//		return next;
	}
}
