package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.dao.AddressDAO;
import br.com.sprintters.prettystyle.dao.ClientDAO;
import br.com.sprintters.prettystyle.dao.UserDAO;

import java.util.ArrayList;

public class AddressService {
    AddressDAO addressDAO;
    UserDAO userDAO;
    ClientDAO clientDAO;

    public AddressService() {
    	addressDAO = new AddressDAO();
    	userDAO = new UserDAO();
    	clientDAO = new ClientDAO();
    }

    public int create(Address address) throws Exception {
    	try {
    		return addressDAO.insert(address);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Address address) throws Exception {
    	try {
    		addressDAO.update(address);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Address address) throws Exception {
        try {
        	addressDAO.delete(address);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Address find(int id) throws Exception {
        try {
        	return addressDAO.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Address> list() throws Exception {
        try {
        	return addressDAO.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Address findByIdUser(int idUser) throws Exception {
    	try {
    		return addressDAO.findByIdUser(idUser);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Address findAllByUser(int idUser) throws Exception {
    	try {
    		return addressDAO.find(idUser);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public User findListByIdUser(int idUser) throws Exception {
    	try {
    		User user = userDAO.find(idUser);
    		
    		user.setClient(clientDAO.find(idUser));
    		
    		ArrayList<Address> addresses = addressDAO.findListByIdUser(idUser);
    		
    		user.setAddresses(addresses);
    		
    		return user;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
