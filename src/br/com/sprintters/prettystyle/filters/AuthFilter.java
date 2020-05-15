package br.com.sprintters.prettystyle.filters;

import java.io.IOException;

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

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.JWTTokenService;
import br.com.sprintters.prettystyle.service.UserService;
import io.jsonwebtoken.Claims;

@WebFilter("/controller.do")
public class AuthFilter implements Filter {
	
	public void destroy() { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String commandCalled = req.getParameter("path") + "." + req.getParameter("command");
		
		if (verifyRoute(commandCalled)) checkAuth(request, response, chain, req);
		else {
			if (commandCalled.equals("productdetails.ViewProduct")) {
				checkAuth(request, response, chain, req);
				
			} else chain.doFilter(request, response);
		}
	}
	
	protected void checkAuth(ServletRequest request, ServletResponse response, FilterChain chain, HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();
		
		String bearerToken = (String)session.getAttribute("token");
		
		if (bearerToken != null) {
			String[] token = bearerToken.split(" ", 2);
			
			if (token[0].equals("Bearer")) {
				JWTTokenService jwt = new JWTTokenService();
				
				Claims claims = jwt.decodeJWT(token[1]);
				
				int idUser = claims.get("idUser", Integer.class);
				
				if (idUser != -1) {
					UserService us = new UserService();
					
					try {
						User user = us.find(idUser);
						request.setAttribute("idUser", idUser);
						if (user != null) chain.doFilter(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else ((HttpServletResponse) response).sendRedirect("/PrettyStyle/App/pages/sign-in/sign-in.jsp");
	}
	
	public void init(FilterConfig fConfig) throws ServletException { }
	
	private boolean verifyRoute(String commandCalled) {
    	boolean isAuthorize = false;
    	
    	switch (commandCalled) {
    		case "null.null"					: isAuthorize = false; 	break;
    		case "address.ListAddress"			: isAuthorize = true; 	break;
    		case "address.CreateAddress"		: isAuthorize = true; 	break;
    		case "address.UpdateAddress"		: isAuthorize = true; 	break;
    		case "address.DeleteAddress"		: isAuthorize = true; 	break;
    		case "address.FindAddress"			: isAuthorize = true; 	break;
	    	case "admin.CreateCategory"			: isAuthorize = true; 	break;
			case "admin.CreateMark"				: isAuthorize = true; 	break;
    		case "admin.CreateProduct"			: isAuthorize = true; 	break;
    		case "admin.DeleteCategory"			: isAuthorize = true; 	break;
    		case "admin.DeleteMark"				: isAuthorize = true;	break;
    		case "admin.DeleteProduct"			: isAuthorize = true;	break;
    		case "admin.EditCategory"			: isAuthorize = true;	break;
    		case "admin.EditMark"				: isAuthorize = true;	break;
    		case "admin.EditProduct"			: isAuthorize = true;	break;
    		case "admin.UpdateProduct"          : isAuthorize = true;	break;
    		case "admin.ListCategories"			: isAuthorize = true;	break;
    		case "admin.ListMarks"				: isAuthorize = true;	break;
    		case "admin.ListProducts"			: isAuthorize = true;	break;
    		case "admin.EditProductQuantity"	: isAuthorize = true;	break;
    		case "admin.LaunchNewQuantity"  	: isAuthorize = true;	break;
    		case "cart.ListCart"				: isAuthorize = true;	break;
    		case "favorites.CreateFavorite"		: isAuthorize = true;	break;
    		case "favorites.ListFavorites"		: isAuthorize = true;	break;
    		case "favorites.DeleteFavorite"		: isAuthorize = true;	break;
    		case "paymentsteps.CreatePayStep" 	: isAuthorize = true;	break;
    		case "paymentsteps.PayStep"			: isAuthorize = true;	break;
    		case "paymentsteps.Pay"				: isAuthorize = true;	break;
    		case "productdetails.ViewProduct"	: isAuthorize = false;	break;
    		case "profile.EditProfile"			: isAuthorize = true;	break;
    		case "profile.UpdateProfile"		: isAuthorize = true;	break;
    		case "request.ListRequests"			: isAuthorize = true;	break;
    		case "signin.Login"					: isAuthorize = false;	break;
    		case "signin.Logout"				: isAuthorize = true;	break;
    		case "signin.NavigateToLogin"		: isAuthorize = false;	break;
    		default								: isAuthorize = false;	break;
    	}
    	
    	return isAuthorize;
    }
}
