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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Request req = new Request();

        RequestService cs = new RequestService();
        try {
        	cs.create(req);
        	req = cs.find(req.getId());
        } catch (Exception e) {
        	e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("id: "+req.getId()+"<br>");
        out.println("idCliente: "+req.getIdClient()+"<br>");
        out.println("</body></html>");
    }
}
