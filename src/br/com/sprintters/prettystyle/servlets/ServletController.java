package br.com.sprintters.prettystyle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.HttpMethodConstraint;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.middleware.AuthMiddleware;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletController() { }
    
    protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		String commandCalled = request.getParameter("path") + "." + request.getParameter("command");
    		
    		if (verifyRoute(commandCalled)) {
				AuthMiddleware middleware = new AuthMiddleware();
    			
	    		boolean isAuthenticated = middleware.auth(request, response);
	    		
	    		if (isAuthenticated) {
	    			Command command = (Command)Class.forName("br.com.sprintters.prettystyle.command." + commandCalled).newInstance();
	    			command.execute(request, response);
	    		} else {
	    			response.sendRedirect("App/pages/sign-in/sign-in.jsp");
	    		}
    		} else {
    			Command command = (Command)Class.forName("br.com.sprintters.prettystyle.command." + commandCalled).newInstance();
    			command.execute(request, response);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		Json json = new Json(true, "Desculpe, houve algum erro no servidor, estamos trabalhando para resolver este problema!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
    	}
    }
    
    private boolean verifyRoute(String commandCalled) {
    	boolean isAuthorize = false;
    	
    	switch (commandCalled) {
    		case "cart.ListCart":
    			isAuthorize = true;
    			break;
    		default:
    			break;
    	}
    	
    	return isAuthorize;
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
