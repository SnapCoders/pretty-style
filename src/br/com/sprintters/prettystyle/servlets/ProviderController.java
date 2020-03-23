package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Provider;
import br.com.sprintters.prettystyle.service.ProviderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Provider.do")
    public class ProviderController extends HttpServlet {
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
            String pCnpj = request.getParameter("cnpj");

            Provider provider = new Provider();
            provider.setCnpj(pCnpj);

            ProviderService cs = new ProviderService();
            cs.create(provider);
            Provider = cs.find(Provider.getId());

            PrintWriter out = response.getWriter();
            out.println("id: "+provider.getId()+"<br>");
            out.println("name: "+provider.getCnpj()+"<br>");
            out.println("</body></html>");

        }

    }

