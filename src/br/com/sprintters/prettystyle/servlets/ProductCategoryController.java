package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.ProductCategory;
import br.com.sprintters.prettystyle.service.ProductCategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/ProductCategory.do")
    public class ProductCategoryController extends HttpServlet {
        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            ProductCategory productCategory = new ProductCategory();

            ProductCategoryService cs = new ProductCategoryService();
            cs.create(productCategory);
            productCategory = cs.find(productCategory.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("id: "+productCategory.getId()+"<br>");
            out.println("idProduct: "+productCategory.getIdProduct()+"<br>");
            out.println("idCategory: "+productCategory.getIdCategory()+"<br>");
            out.println("</body></html>");

        }

    }

