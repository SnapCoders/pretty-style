package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/User.do")
    public class UserController extends HttpServlet {
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
            String pSurname = request.getParameter("surname");
            String pEmail = request.getParameter("email");

            User user = new User();
            user.setName(pName);
            user.setSurname(pSurname);
            user.setEmail(pEmail);

            UserService cs = new UserService();
            cs.create(user);
            user = cs.find(User.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Cadastro de Usuario</title></head><body>");
            out.println("id: "+user.getId()+"<br>");
            out.println("name: "+user.getName()+"<br>");
            out.println("Surname: "+user.getSurname()+"<br>");
            out.println("Email: "+user.getEmail()+"<br>");
            out.println("</body></html>");

        }

    }

