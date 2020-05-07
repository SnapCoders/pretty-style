package br.com.sprintters.prettystyle.command.admin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductPhotoService;
import br.com.sprintters.prettystyle.service.ProductService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateProduct implements Command {
	private static final String SAVE_DIR = File.separator + "WebContent\\Upload";
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			int idUser = (int)request.getAttribute("idUser");
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + SAVE_DIR;
			
			File webContentPath = new File(appPath + "\\WebContent");
			File uploadPath = new File(webContentPath + "\\Upload");
			
			if (!webContentPath.exists()) webContentPath.mkdir();
			if (!uploadPath.exists()) uploadPath.mkdir();
			
			MultipartRequest m = new MultipartRequest(request, savePath, 100100100);
			
			byte[] pName = m.getParameter("name").getBytes(ISO_8859_1);
			String name = new String(pName, UTF_8);
			
			byte[] pDescription = m.getParameter("description").getBytes(ISO_8859_1);
			String description = new String(pDescription, UTF_8);
			
			Double pPrice = Double.parseDouble(m.getParameter("price"));
			int idMark = Integer.parseInt(m.getParameter("idMark"));
			
			String[] idsCategories = m.getParameterValues("idCategory");
			
			ArrayList<Category> categories = new ArrayList<Category>();
			
			for (String idCategory : idsCategories) categories.add(new Category(Integer.parseInt(idCategory)));
			
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			Product product = new Product(name, description, pPrice, idMark, user.getProvider().getId(), categories);
			
			ProductService cs = new ProductService();
			ProductPhotoService pps = new ProductPhotoService();
			
			int idProduct = cs.create(product);
			
			Enumeration<?> files = m.getFileNames();
			
			while (files.hasMoreElements()) {
				String fileNameProp = (String)files.nextElement();
				
				if (fileNameProp.startsWith("file-")) {
					String fileName = m.getFilesystemName(fileNameProp);
					
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
