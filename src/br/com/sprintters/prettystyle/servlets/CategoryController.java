package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/Category.do")
    public class CategoryController extends HttpServlet {
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
            String pName = request.getParameter("name");
            String pColor = request.getParameter("color");

            Category category = new Category();
            category.setName(pName);
            category.setColor(pColor);

            CategoryService cs = new CategoryService();
            cs.create(category);
            category = cs.find(Category.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("id: "+category.getId()+"<br>");
            out.println("name: "+category.getName()+"<br>");
            out.println("Color: "+category.getColor()+"<br>");
            out.println("</body></html>");

        }

    }

