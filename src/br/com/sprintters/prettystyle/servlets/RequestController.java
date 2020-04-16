package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Client;
import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.RequestService;
import br.com.sprintters.prettystyle.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet("/requests")
public class RequestController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @HttpMethodConstraint("GET")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	RequestService service = new RequestService();
        	ArrayList<Request> reqs = service.listRequestsByIdClient(1);
        	request.setAttribute("lista", reqs);
        	RequestDispatcher view = request.getRequestDispatcher("requests.jsp");
        	view.forward(request, response);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    @HttpMethodConstraint("POST")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	String paymentType = request.getParameter("paymentType");
        	double totalPriceWithoutDiscount = Double.parseDouble(request.getParameter("totalPriceWithoutDiscount"));
        	double totalPriceWithDiscount = Double.parseDouble(request.getParameter("totalPriceWithDiscount"));
        	int cardParcels = Integer.parseInt(request.getParameter("cardParcels"));
        	
        	UserService userService = new UserService();
        	RequestService requestService = new RequestService();
        	
        	User user = userService.find(1);
        	Date date = new Date(2001);
        	
        	Client client = new Client("Bruno", "Amaral Futema", "123.456.789-10", date, "M" );
        	
        	int id = user.getId();
        	
        	UUID uuid = UUID.randomUUID();
        	
    		String numberRequestPad = String.format("%02d", id);
    		String nr = numberRequestPad + "-"+ uuid.toString();
    		
    		Request req = new Request(1, nr, "Cartão de crédito");
    		
        	if(paymentType.equals("creditCard")) {
        		if(cardParcels == 1) req.setTotalPrice(totalPriceWithDiscount);
        		else req.setTotalPrice(totalPriceWithoutDiscount);
        	}
        	
        	requestService.create(req);
        	
        	request.setAttribute("client", client);
        	request.setAttribute("req", req);
        	
        	RequestDispatcher view = request.getRequestDispatcher("App/pages/thanks/thanks.jsp");
        	view.forward(request, response);
        } catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Erro ao processar o pagamento!");
			retorno.put("stacktrace", e.getMessage());
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
    }
}
