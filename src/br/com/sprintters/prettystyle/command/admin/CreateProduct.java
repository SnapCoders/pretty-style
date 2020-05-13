package br.com.sprintters.prettystyle.command.admin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.Stock;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.service.ProductPhotoService;
import br.com.sprintters.prettystyle.service.ProductService;
import br.com.sprintters.prettystyle.service.UserService;

public class CreateProduct implements Command {
	private static final String SAVE_DIR = "PrettyStyle\\Uploads";
	private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		boolean isJson = false;
		
		try {
			HttpSession session = request.getSession();
			
			isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			int idUser = (int)request.getAttribute("idUser");
			
			String appPath = request.getServletContext().getRealPath("");
			String savePath = "";
			
			for (int i = 0; i < appPath.length(); i++) {
				if (!String.valueOf(appPath.charAt(i)).equals(".")) {
					savePath += appPath.charAt(i);
				}
				else break;
			}
			
			savePath += SAVE_DIR;
					
			checkIfDirectoryExists(savePath);
			
			MultipartRequest m = new MultipartRequest(request, savePath, 100100100);
			
			String name = toUTF(m, "name");
			String description = toUTF(m, "description");
			Double price = Double.parseDouble(m.getParameter("price"));
			int idMark = Integer.parseInt(m.getParameter("idMark"));
			int quantity = Integer.parseInt(m.getParameter("quantity"));
			
			String[] idsCategories = m.getParameterValues("idCategory");
			
			ArrayList<Category> categories = new ArrayList<Category>();
			
			for (String idCategory : idsCategories) categories.add(new Category(Integer.parseInt(idCategory)));
			
			UserService us = new UserService();
			
			User user = us.find(idUser);
			
			ProductService cs = new ProductService();
			ProductPhotoService pps = new ProductPhotoService();
			
			Product product = new Product(
				name,
				description,
				price,
				idMark,
				user.getProvider().getId(),
				categories,
				new Stock(quantity)
			);
			
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
    		
    		if (isJson) {
    			Json json = new Json(true, "Produto cadastrado com sucesso!", product);
        		
        		response.setContentType("application/json");
        		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				session.setAttribute("product", product);
				
				response.sendRedirect("/PrettyStyle/App/pages/catalog/catalog.jsp");
			}
		} catch (Exception e) {
    		if (isJson) {
    			Json json = new Json(false, "Desculpe, houve um erro ao cadastrar o produto, verifique os dados e tente novamente!", e);
        		
        		response.setContentType("application/json");
        		response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				response.sendRedirect("/PrettyStyle/App/pages/error/500.jsp");
			}
		}
	}
	
	static String toUTF(MultipartRequest m, String prop) {
		byte[] propConverted = m.getParameter(prop).getBytes(ISO_8859_1);
		return new String(propConverted, UTF_8);
	}
	
	static void checkIfDirectoryExists(String appPath) {
		File uploadPath = new File(appPath);
		
		if (!uploadPath.exists()) uploadPath.mkdir();
	}
}
