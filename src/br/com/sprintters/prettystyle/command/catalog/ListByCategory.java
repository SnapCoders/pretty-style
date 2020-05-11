package br.com.sprintters.prettystyle.command.catalog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.CategoryService;
import br.com.sprintters.prettystyle.service.ProductPhotoService;
import br.com.sprintters.prettystyle.service.ProductService;

public class ListByCategory implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			String filter = request.getParameter("filter");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			ProductService ps = new ProductService();
			CategoryService cs = new CategoryService();
			ProductPhotoService pps = new ProductPhotoService();
			
			ArrayList<Category> categories = cs.list();
			ArrayList<Product> products = ps.findByCategory(filter);
	  				
		    String filterIds = "";
		    
		    for(Product produto: products) filterIds += produto.getId() + ",";
		    
		    
		    ArrayList<ProductPhoto> photos = new ArrayList<ProductPhoto>();
		    if(filterIds.length() > 0) {
		    	filterIds = filterIds.substring(0, filterIds.length()-1);	
		    	photos = pps.findPhotosByFilter(filterIds);
		    }
		    
		   	
		    
		    /*
		    ArrayList<Integer> ids = new ArrayList<Integer>();
		    for(Product produto: products) {
		    	ids.add(produto.getId());
		    }    
		    */
		    
			
			////////
			ArrayList<Product> lista = ps.listBestSellers();
		
			ArrayList<Product> bestSellers1 = new ArrayList<Product>(lista.subList(0, (lista.size()/2)));
			ArrayList<Product> bestSellers2 = new ArrayList<Product>(lista.subList(lista.size()/2, lista.size()));
			
			if (isJson) {
				Json json = new Json(true, "", products);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("products", products);
				session.setAttribute("photos", photos);
				session.setAttribute("categories", categories);
				session.setAttribute("filter", filter);
				session.setAttribute("bestSellersOne", bestSellers1);
				session.setAttribute("bestSellersTwo", bestSellers2);
				
				response.sendRedirect("/PrettyStyle/App/pages/catalog/catalog.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
