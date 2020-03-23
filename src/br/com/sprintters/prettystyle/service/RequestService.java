package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.dao.RequestDAO;

import java.util.ArrayList;

public class RequestService {
    RequestDAO dao;

    public RequestService() {
        dao = new RequestDAO();
    }

    public int create(Request request) throws Exception {
        try {
        	return dao.insert(request);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Request request) throws Exception {
        try {
        	dao.update(request);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Request request) throws Exception {
        try {
        	dao.delete(request);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Request find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Request> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
