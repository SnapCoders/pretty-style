package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.MarkService;

public class EditMark implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			int idMark = Integer.parseInt(request.getParameter("idMark"));
			String name = request.getParameter("name");
			
			
			MarkService ms = new MarkService();
			Mark mark = new Mark(idMark,name);
			
			ms.update(mark);
			
			if (isJson) {
				Json json = new Json(true, "Nome da categoria atualizado com sucesso", mark);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/admin/admin.jsp");
			}
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, ocorreu um erro ao listar seus produtos, tente novamente!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}

}


