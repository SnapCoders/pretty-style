package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.service.MarkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/Mark.do")
    public class MarkController extends HttpServlet {
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

            Mark mark = new Mark();
            mark.setName(pName);


            MarkService cs = new MarkService();
            cs.create(mark);
            mark = cs.find(Mark.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Mark</title></head><body>");
            out.println("id: "+mark.getId()+"<br>");
            out.println("name: "+mark.getName()+"<br>");
            out.println("</body></html>");

        }

    }

