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

    @WebServlet("/Address.do")
    public class AddressController extends HttpServlet {
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

            AddressService cs = new AddressService();
            cs.create(Address);
            address = cs.find(Address.getId());

            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("id: "+address.getId()+"<br>");
            out.println("place: "+address.getPlace()+"<br>");
            out.println("number: "+address.getNumber()+"<br>");
            out.println("neighborhood: "+address.getNeighborhood()+"<br>");
            out.println("city: "+address.getCity()+"<br>");
            out.println("country: "+address.getCountry()+"<br>");
            out.println("zip: "+address.getZip()+"<br>");
            out.println("complement: "+address.getComplement()+"<br>");
            out.println("idUser: "+address.getIdUser()+"<br>");
            out.println("</body></html>");

        }

    }

