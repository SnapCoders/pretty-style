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
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.CategoryService;
import br.com.sprintters.prettystyle.service.ProductService;

public class ListByCategory implements Command {
	public static ArrayList<String> categoryFilter = new ArrayList<String>();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		boolean isJson = false;
				
		try {
			HttpSession session = request.getSession();
			
			String filter = request.getParameter("filter");
			isJson = Boolean.parseBoolean(request.getParameter("json"));
			String filterCategories = request.getParameter("categories");
			
			ProductService ps = new ProductService();
			CategoryService cs = new CategoryService();
			
			ArrayList<Category> categories = cs.list();
			ArrayList<Product> products = new ArrayList<Product>();
		
			String valueCategories = "";
			int quantityProduct = 0;
			
				if(filterCategories != null || (categoryFilter.size() < 1 && filterCategories != null)) {
					if(categoryFilter.size() < 1 && filterCategories != null) {
						categoryFilter.add(filterCategories);
					}
					else {
						if(!categoryFilter.contains(filterCategories)) {
							categoryFilter.add(filterCategories);
						}
						else {
							categoryFilter.remove(filterCategories);
						}		
						
					}
					valueCategories = String.join("','", categoryFilter);
					
					String valueFilter = filter.substring(0,1) + filter.substring(1).toLowerCase();
					quantityProduct = ps.findByCategoryAndFilterCount(valueFilter, valueCategories);
					products = ps.findByCategoryAndFilter(valueFilter, valueCategories);
				}
				else {
					categoryFilter = new ArrayList<String>();
					quantityProduct = ps.findByCategoryCount(filter);
					products = ps.findByCategory(filter);				
				}
				//int quantityPages = (quantityProduct / 16);
				int quantityPages = (int) Math.round(((double)quantityProduct / 16)+0.5d);
				
				if(quantityPages < 1 && quantityPages >= 0) quantityPages = 1;
				ArrayList<Integer> pages = new ArrayList<Integer>();
				
								
				for(int i = 1; i <= quantityPages; i++) {
					pages.add(i);
				}
							
			if (isJson) {
				Json json = new Json(true, "", products);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("products", products);
				session.setAttribute("categories", categories);
				session.setAttribute("filter", filter);
				session.setAttribute("categoriesSelected", categoryFilter);
				session.setAttribute("quantityProduct", quantityProduct);
				session.setAttribute("quantityPages", pages);
				
				response.sendRedirect("/PrettyStyle/App/pages/catalog/catalog.jsp");
			}
		} catch (Exception e) {
			if (isJson) {
				Json json = new Json(false, "Desculpe, houve um erro ao listar os produtos pela categoria, estamos trabalhando para corrigir esse problema!", e);
	    		
	    		response.setContentType("application/json");
	    		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/error/500.jsp");
			}
		}
	}
}
