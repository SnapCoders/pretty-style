package br.com.sprintters.prettystyle.command.admin;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductPhotoService;
import br.com.sprintters.prettystyle.service.ProductService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateProduct implements Command {
	private static final String SAVE_DIR = File.separator + "WebContent\\Upload";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			
			int idUser = (int)request.getAttribute("idUser");
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + SAVE_DIR;
			
			MultipartRequest m = new MultipartRequest(request, savePath, 100100100);
			
			String pName = m.getParameter("name");
			String pDescription = m.getParameter("description");
			Double pPrice = Double.parseDouble(m.getParameter("price"));
			int idMark = Integer.parseInt(m.getParameter("idMark"));
			int idCategory = Integer.parseInt(m.getParameter("idCategory"));
			
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			Product product = new Product(pName, pDescription, pPrice, idMark, user.getProvider().getId());
			
			ProductService cs = new ProductService();
			ProductPhotoService pps = new ProductPhotoService();
			
			int idProduct = cs.create(product);
			
			Enumeration<?> files = m.getFileNames();
			
			while (files.hasMoreElements()) {
				String name = (String)files.nextElement();
				
				if (name.startsWith("file-")) {
					String fileName = m.getFilesystemName(name);
					
					String url = File.separator + "PrettyStyle" + SAVE_DIR + File.separator + fileName;
					
					ProductPhoto productPhoto = new ProductPhoto(fileName, url, idProduct);
					
					pps.create(productPhoto);
				}
			}
			
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
