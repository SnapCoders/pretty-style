package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Client;
import br.com.sprintters.prettystyle.service. ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/Client.do")
    public class ClientController extends HttpServlet {
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
            String pCpf = request.getParameter("cpf");

            Client client = new Client();
            client.setCpf(pCpf);

            ClientService cs = new  ClientService();
            cs.create(client);
            Client = cs.find( Client.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Cadastro de produto</title></head><body>");
            out.println("id: "+client.getId()+"<br>");
            out.println("cpf: "+client.getCpf()+"<br>");
            out.println("idUser: "+client.getIdUser()+"<br>");
            out.println("</body></html>");

        }

    }

