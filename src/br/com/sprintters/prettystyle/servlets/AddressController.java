package br.com.sprintters.prettystyle.servlets;

import org.json.JSONObject;

import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses")
public class AddressController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @HttpMethodConstraint("GET")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @HttpMethodConstraint("POST")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pPlace = request.getParameter("place");
        String pNumber = request.getParameter("number");
        String pNeighborhood = request.getParameter("neighborhood");
        String pCity = request.getParameter("city");
        String pCountry = request.getParameter("country");
        String pZip = request.getParameter("zip");
        String pComplement = request.getParameter("complement");

        Address address = new Address();
        address.setPlace(pPlace);
        address.setNumber(pNumber);
        address.setNeighborhood(pNeighborhood);
        address.setCity(pCity);
        address.setCountry(pCountry);
        address.setZip(pZip);
        address.setComplement(pComplement);
        
        //fake user
        address.setIdUser(1);
		AddressService cs = new AddressService();
		
		try {
			cs.create(address);
			JSONObject retorno = new JSONObject();
			retorno.put("success", true);
			retorno.put("message", "Cadastro realizado com sucesso.");
		
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			retorno.put("error", true); retorno.put("message", "Erro ao realizar o cadastro.");
		
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
    }
    
    @HttpMethodConstraint("DELETE")
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int id = Integer.parseInt(request.getQueryString());
    		
    		AddressService as = new AddressService();
    		
    		Address obj = as.find(id);
    		as.delete(obj); 
    		
    		JSONObject retorno = new JSONObject();
			
			retorno.put("success", true);
			retorno.put("message","Endereço excluído com sucesso!");
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
    	} catch (Exception e) {
			JSONObject retorno = new JSONObject();
			
			retorno.put("success", false);
			retorno.put("message", "Erro ao Deletar o Endereço!");
			retorno.put("stacktrace", e.getMessage());
			
			response.setContentType("application/json");
			response.getWriter().write(retorno.toString());
		}
    }
    
    
}
