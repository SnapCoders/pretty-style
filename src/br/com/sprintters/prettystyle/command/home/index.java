package br.com.sprintters.prettystyle.command.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.service.ProductService;

public class index implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		HttpSession session = request.getSession();
		
		ProductService ps = new ProductService();
  		
		ArrayList<Product> lista = ps.listBestSellers();
		
		for (Product p : lista) {
			for (ProductPhoto pp : p.getPhotos()) {
				String oldRelativeUrl = pp.getUrl();
				String newUrl = "\\PrettyStyle" + oldRelativeUrl;
				pp.setUrl(newUrl);
			}
		}
	
		ArrayList<Product> bestSellers1 = new ArrayList<Product>(lista.subList(0, (lista.size()/2)));
		ArrayList<Product> bestSellers2 = new ArrayList<Product>(lista.subList(lista.size()/2, lista.size()));
		
		session.setAttribute("bestSellersOne", bestSellers1);
		session.setAttribute("bestSellersTwo", bestSellers2);
		
		response.sendRedirect("/PrettyStyle/index.jsp");
	}
}
