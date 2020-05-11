package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.ItemRequestDAO;
import br.com.sprintters.prettystyle.dao.RequestDAO;
import br.com.sprintters.prettystyle.model.ItemRequest;
import br.com.sprintters.prettystyle.model.Request;

public class RequestService {
    RequestDAO dao;
    ItemRequestDAO itemRequestDAO;

    public RequestService() {
        dao = new RequestDAO();
        itemRequestDAO = new ItemRequestDAO();
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
    
    public ArrayList<Request> listRequestsByIdClient(int idClient) throws Exception {
    	try {
    		return dao.listRequestsByIdClient(idClient);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public void createItemRequest(ItemRequest itemRequest) throws Exception{
    	itemRequestDAO.insert(itemRequest);
    }

}
