package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.AddressDAO;
import br.com.sprintters.prettystyle.dao.ClientDAO;
import br.com.sprintters.prettystyle.dao.UserAddressDAO;
import br.com.sprintters.prettystyle.dao.UserDAO;
import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.UserAddress;

public class AddressService {
	AddressDAO addressDAO;
    UserAddressDAO userAddressDAO;
    UserDAO userDAO;
    ClientDAO clientDAO;

    public AddressService() {
    	addressDAO = new AddressDAO();
    	userAddressDAO = new UserAddressDAO();
    	userDAO = new UserDAO();
    	clientDAO = new ClientDAO();
    }

    public int create(Address address) throws Exception {
    	try {
    		int id = 0;
    		Address addressExists = addressDAO.findByIdUser(address.getIdUser());
    		
    		if (addressExists.getId() == 0) {
    			id = addressDAO.insert(address);
    			addressDAO.insertDefault(address.getIdUser(), id);
    		} else {
    			id = addressDAO.insert(address);
    		}
    		
    		return id; 
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
    
    public void updateDefaultAddress(UserAddress userAddress) throws Exception {
    	try {
    		userAddressDAO.update(userAddress);
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
    		user.setAddresses(addressDAO.findListByIdUser(idUser));
    		
    		UserAddress userAddress = userAddressDAO.find(idUser);
    		
    		for (Address address : user.getAddresses()) {
    			if (address.getId() == userAddress.getIdAddress()) {
    				address.setUserAddress(userAddress);
    			}
    		}
    		
    		return user;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
