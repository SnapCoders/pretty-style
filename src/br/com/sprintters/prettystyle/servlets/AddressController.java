package br.com.sprintters.prettystyle.servlets;

import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addresses")
public class AddressController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

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
        	address = cs.find(address.getId());
        } catch (Exception e) {
        	e.printStackTrace();
        }


    }
}
