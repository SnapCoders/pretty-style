package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.service.ClientProductLikeService;

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

@WebServlet("/likes")
public class ClientProductLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@HttpMethodConstraint("GET")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@HttpMethodConstraint("POST")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// o like ta vindo null do jsp, tentar fazer ele vir com algum valor la pela script.js
			String pLike = request.getParameter("like");
			int like = Integer.parseInt(pLike);
			ClientProductLike clientProductLike = new ClientProductLike(2, 2, like);

			
			

			ClientProductLikeService service = new ClientProductLikeService();



			service.create(clientProductLike);

			JSONObject retorno = new JSONObject();

			retorno.put("success", true);
			retorno.put("message", "Produto curtido com sucesso!");

			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		} catch (Exception e) {
			JSONObject retorno = new JSONObject();

			retorno.put("success", false);
			retorno.put("message", "Desculpe houve uma falha no momento de curtir este produto, tente mais tarde!");

			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
	}
}