package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.service.CategoryService;
//import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.service.MarkService;
import br.com.sprintters.prettystyle.service.ProductPhotoService;
import br.com.sprintters.prettystyle.service.ProductService;

public class EditProduct implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		request.setCharacterEncoding("UTF-8");
		int idProduct = Integer.parseInt(request.getParameter("id_product"));
		
		ProductService ps = new ProductService();
		Product product = ps.findProductAndCategory(idProduct);
		
		MarkService ms = new MarkService();
		Mark mark = ms.find(product.getIdMark());
		
		//ProductPhoto deve retornar um arraylist (inserir no product);
		ProductPhotoService pps = new ProductPhotoService();
		product.setPhotos(pps.findAllPhotosByIdProduct(idProduct));
		//ArrayList<ProductPhoto> photos = pps.findAllPhotosByIdProduct(idProduct);
		
		String idsCategoriesByUser = "";
		if(product.getCategories() != null) {			
			for(Category a :product.getCategories()) {
				idsCategoriesByUser += a.getId() + ",";
			}
			if(idsCategoriesByUser.length() > 0) {
				idsCategoriesByUser = idsCategoriesByUser.substring(0, idsCategoriesByUser.length() - 1);
			}
			else {
				idsCategoriesByUser = "";
			}
		}
		
		CategoryService cs = new CategoryService();
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("idsCategoriesByUser", idsCategoriesByUser);
		session.setAttribute("product", product);
		session.setAttribute("mark", mark);
		session.setAttribute("productPhoto", product.getPhotos());
		session.setAttribute("marks", ms.list());
		session.setAttribute("categories", cs.list());
		
		response.sendRedirect("/PrettyStyle/App/pages/admin/edit-product/edit-product.jsp");
		
	}
}
