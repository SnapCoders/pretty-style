package br.com.sprintters.prettystyle.command.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.service.MarkService;
import br.com.sprintters.prettystyle.service.ProductCategoryService;
import br.com.sprintters.prettystyle.service.ProductPhotoService;
import br.com.sprintters.prettystyle.service.ProductService;

public class EditProduct implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		request.setCharacterEncoding("UTF-8");
		int idProduct = Integer.parseInt(request.getParameter("id_product"));
		
		ProductService ps = new ProductService();
		Product product = ps.find(idProduct);
		
		MarkService ms = new MarkService();
		Mark mark = ms.find(product.getIdMark());
		
		ProductPhotoService pps = new ProductPhotoService();
		ProductPhoto productPhoto = pps.findByIdProduct(idProduct);
		
		ProductCategoryService = pcs = new ProductCategoryService();
		
		//ProductCategory pc = pcs.
		
		HttpSession session = request.getSession();
		
		session.setAttribute("product", product);
		session.setAttribute("mark", mark);
		session.setAttribute("productPhoto", productPhoto);
		
		response.sendRedirect("/PrettyStyle/App/pages/admin/edit-product/edit-product.jsp");
		
	}
}
