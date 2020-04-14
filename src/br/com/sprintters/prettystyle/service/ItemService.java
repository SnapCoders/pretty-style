package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.dao.ItemDAO;

import java.util.ArrayList;

public class ItemService {
    ItemDAO dao;

    public ItemService() {
        dao = new ItemDAO();
    }

    public int create(Item item) throws Exception {
        try {
        	return dao.insert(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Item item) throws Exception {
        try {
        	dao.update(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Item item) throws Exception {
        try {
        	dao.delete(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Item find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Item> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    public ArrayList<Item> listPlusItem(int idClient) throws Exception {
        try {
        	return dao.listRequestsByIdClient(idClient);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
