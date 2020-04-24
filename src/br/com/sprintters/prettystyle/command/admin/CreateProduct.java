package br.com.sprintters.prettystyle.command.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductService;

public class CreateProduct implements Command {
	private static final String SAVE_DIR = "WebContent\\Upload";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + File.separator + SAVE_DIR;
			
			MultipartRequest m = new MultipartRequest(request, savePath, 100100100);
			
			String pName = m.getParameter("name");
			String pDescription = m.getParameter("description");
			Double pPrice = Double.parseDouble(m.getParameter("price"));
			int idMark = Integer.parseInt(m.getParameter("idMark"));
			
			Product product = new Product(pName, pDescription, pPrice, idMark);
			
			ProductService cs = new ProductService();
			
			cs.create(product);
			
			Json json = new Json(true, "Produto cadastrado com sucesso!", product);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		} catch (Exception e) {
			Json json = new Json(false, "Desculpe, houve um erro ao cadastrar o produto, verifique os dados e tente novamente!", e);
    		
    		response.setContentType("application/json");
    		response.getWriter().write(new Gson().toJson(json).toString());
		}
	}
}
