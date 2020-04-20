package br.com.sprintters.prettystyle.command.favorites;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductService;
import br.com.sprintters.prettystyle.service.UserService;

public class ListFavorites implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String idUserStr = request.getParameter("id_user");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			int idUser = -1;
			
			HttpSession session = request.getSession();
			
			try {
				idUser = Integer.parseInt(idUserStr);
				
			} catch (NumberFormatException e) {
				response.sendRedirect("/PrettyStyle/App/pages/sign-in/sign-in.jsp");
			}
			
			if (idUser != -1) {
				UserService us = new UserService();
				
				User user = us.find(idUser);
				
				ProductService ps = new ProductService();
				ArrayList<ClientProductLike> productsLiked = ps.listFavoritesByIdClient(user.getClient().getId());
				
				if (isJson) {
					Json json = new Json(true, "", productsLiked);
					
					response.setContentType("application/json");
					response.getWriter().write(new Gson().toJson(json).toString());
				} else {
					session.setAttribute("productsLiked", productsLiked);
					
					response.sendRedirect("/PrettyStyle/App/pages/favorites/favorites.jsp");
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
