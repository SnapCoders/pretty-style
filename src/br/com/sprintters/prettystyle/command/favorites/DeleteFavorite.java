package br.com.sprintters.prettystyle.command.favorites;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductService;
import br.com.sprintters.prettystyle.service.UserService;

public class DeleteFavorite implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			
			int idUser = (int)request.getAttribute("idUser");
			int idProduct = Integer.parseInt(request.getParameter("id_product"));
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));

			ProductService ps = new ProductService();
			UserService us = new UserService();

			User user = us.find(idUser);

			ClientProductLike cpl = ps.listFavoriteByIdUserAndIdProduct(user.getId(), idProduct);

			ps.deleteFavoriteById(cpl.getId());

			if (isJson) {
				Json json = new Json(true, "Produto removido com sucesso!", null);

				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/favorites/favorites.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
