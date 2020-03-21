package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.service.PhoneNumberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/PhoneNumber.do")
    public class PhoneNumberController extends HttpServlet {
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
            String pDdd = request.getParameter("ddd");
            String pNumber = request.getParameter("number");

            PhoneNumber phoneNumber = new PhoneNumber();
            PhoneNumber.setDdd(pDdd);
            PhoneNumber.setNumber(pNumber);

            PhoneNumberService cs = new PhoneNumberService();
            cs.create(phoneNumber);
            phoneNumber = cs.find(phoneNumber.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("id: "+phoneNumber.getId()+"<br>");
            out.println("name: "+phoneNumber.getDdd()+"<br>");
            out.println("description: "+phoneNumber.getNumber()+"<br>");
            out.println("price: "+phoneNumber.getIdUser()+"<br>");
            out.println("</body></html>");

        }

    }

