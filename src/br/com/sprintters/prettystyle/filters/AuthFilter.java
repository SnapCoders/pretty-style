package br.com.sprintters.prettystyle.filters;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.UserService;

@WebFilter("/controller.do")
public class AuthFilter implements Filter {
	
	public void destroy() { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		String commandCalled = req.getParameter("path") + "." + req.getParameter("command");
		
		if (verifyRoute(commandCalled)) {
			int idUser = -1;
			
			//String idUserStr = (String)session.getAttribute("idUser");
			int idUserStr = (int)session.getAttribute("idUser");
			
			if (idUserStr != -1) idUser = idUserStr;
			String bearerToken = (String)session.getAttribute("token");
			
			if (idUser != -1 && bearerToken != null) {
				String[] token = bearerToken.split(" ", 2);
				
				if (token[0].equals("Bearer")) { // acressentar no if a verificação do token
					String tok = token[1].toString();
					String[] arr = tok.split(".");
					String base64Url = token[1].split(".")[1];
					String base64 = base64Url.replaceAll("/-/g", "+").replaceAll("/_/g", "/");
					String obj = new String(Base64.getDecoder().decode(base64));
					
					if (idUser != -1) {
						UserService us = new UserService();
						
						try {
							User user = us.find(idUser);
							if (user != null) chain.doFilter(request, response);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} else ((HttpServletResponse) response).sendRedirect("/PrettyStyle/App/pages/sign-in/sign-in.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException { }
	
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
    		case "admin.EditCategory":
    			isAuthorize = true;
    			break;
    		case "admin.EditMark":
    			isAuthorize = true;
    			break;
    		case "admin.EditProduct":
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
    		case "request.ListRequests":
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
}
