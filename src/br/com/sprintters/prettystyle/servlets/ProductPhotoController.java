package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.service.ProductPhotoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProductPhoto.do")
public class ProductPhotoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pUrl = request.getParameter("url");
        String pName = request.getParameter("name");

        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setUrl(pUrl);
        productPhoto.setName(pName);

        ProductPhotoService cs = new ProductPhotoService();
        
        try {
        	cs.create(productPhoto);
        	productPhoto = cs.find(productPhoto.getId());
        } catch (Exception e) {
        	e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cadastro de Imagem</title></head><body>");
        out.println("id: "+productPhoto.getId()+"<br>");
        out.println("url: "+productPhoto.getUrl()+"<br>");
        out.println("name: "+productPhoto.getName()+"<br>");
        out.println("name: "+productPhoto.getIdProduct()+"<br>");
        out.println("</body></html>");
    }
}
