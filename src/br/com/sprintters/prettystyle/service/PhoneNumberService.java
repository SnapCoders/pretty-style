package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.dao.PhoneNumberDAO;

import java.util.ArrayList;

public class PhoneNumberService {
    PhoneNumberDAO dao;

    public PhoneNumberService() {
        dao = new PhoneNumberDAO();
    }

    public int create(PhoneNumber phoneNumber) throws Exception {
        try {
        	return dao.insert(phoneNumber);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(PhoneNumber phoneNumber) throws Exception {
        try {
        	dao.update(phoneNumber);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(PhoneNumber phoneNumber) throws Exception {
        try {
        	dao.delete(phoneNumber);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public PhoneNumber find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<PhoneNumber> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
