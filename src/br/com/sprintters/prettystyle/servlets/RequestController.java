package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/Request.do")
    public class RequestController extends HttpServlet {
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

            RequestService cs = new RequestService();
            cs.create(request);
            request = cs.find(Request.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("</body></html>");

        }

    }

