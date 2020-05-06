package br.com.sprintters.prettystyle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.generic.Json;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletController() { }
    
    protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		String commandCalled = request.getParameter("path") + "." + request.getParameter("command");
    		
			Command command = (Command)Class.forName("br.com.sprintters.prettystyle.command." + commandCalled).newInstance();
			command.execute(request, response);
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		Json json = new Json(false, "Desculpe, houve algum erro no servidor, estamos trabalhando para resolver este problema!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
    	}
    }
    
    @HttpMethodConstraint("GET")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	@HttpMethodConstraint("POST")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	@HttpMethodConstraint("PUT")
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	@HttpMethodConstraint("DELETE")
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}
}
