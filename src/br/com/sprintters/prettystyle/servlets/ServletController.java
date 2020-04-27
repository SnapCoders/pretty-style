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
import br.com.sprintters.prettystyle.middleware.AuthMiddleware;
import br.com.sprintters.prettystyle.model.generic.Json;

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
    			if (commandCalled.equals("null.null")) commandCalled = "home.index";
    			
    			Command command = (Command)Class.forName("br.com.sprintters.prettystyle.command." + commandCalled).newInstance();
				command.execute(request, response);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		Json json = new Json(false, "Desculpe, houve algum erro no servidor, estamos trabalhando para resolver este problema!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
    	}
    }
    
    private boolean verifyRoute(String commandCalled) {
    	boolean isAuthorize = false;
    	
    	switch (commandCalled) {
    		case "null.null":
    			isAuthorize = false;
    			break;
	    	case "admin.CreateCategory":
	    		isAuthorize = true;
	    		break;
			case "admin.CreateMark":
				isAuthorize = true;
				break;
    		case "admin.CreateProduct":
				isAuthorize = true;
				break;
    		case "admin.DeleteCategory":
				isAuthorize = true;
				break;
    		case "admin.DeleteMark":
				isAuthorize = true;
				break;
    		case "admin.DeleteProduct":
				isAuthorize = true;
				break;
    		case "admin.ListCategories":
				isAuthorize = true;
				break;
    		case "admin.ListMarks":
				isAuthorize = true;
				break;
    		case "admin.ListProducts":
				isAuthorize = true;
				break;
    		case "cart.ListCart":
    			isAuthorize = true;
    			break;
    		case "favorites.CreateFavorite":
    			isAuthorize = true;
    			break;
    		case "favorites.ListFavorites":
    			isAuthorize = true;
    			break;
    		case "favorites.DeleteFavorite":
    			isAuthorize = true;
    			break;
    		case "paymentsteps.CreatePayStep":
    			isAuthorize = true;
    			break;
    		case "paymentsteps.PayStep":
    			isAuthorize = true;
    			break;
    		case "paymentsteps.Pay":
    			isAuthorize = true;
    			break;
    		case "productdetails.ViewProduct":
    			isAuthorize = false;
    			break;
    		case "requests.ListRequests":
    			isAuthorize = true;
    			break;
    		case "signin.Login":
    			isAuthorize = false;
    			break;
    		case "signin.Logout":
    			isAuthorize = true;
    			break;
    		default:
    			isAuthorize = false;
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
