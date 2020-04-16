package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.dao.AddressDAO;

import java.util.ArrayList;

public class AddressService {
    AddressDAO dao;

    public AddressService() {
        dao = new AddressDAO();
    }

    public int create(Address address) throws Exception {
    	try {
    		return dao.insert(address);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Address address) throws Exception {
    	try {
    		dao.update(address);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Address address) throws Exception {
        try {
        	dao.delete(address);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Address find(int id) throws Exception {
        try {
        	return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Address> list() throws Exception {
        try {
        	return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Address> listPlusName(int id) throws Exception {
        try {
        	return dao.listAllPlusName(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Address findByIdUser(int idUser) throws Exception {
    	try {
    		return dao.findByIdUser(idUser);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
