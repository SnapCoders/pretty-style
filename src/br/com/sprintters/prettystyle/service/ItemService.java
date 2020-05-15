package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.dao.ItemDAO;

import java.util.ArrayList;

public class ItemService {
    ItemDAO dao;

    public ItemService() {
        dao = new ItemDAO();
    }

    public int create(Item item) throws Exception {
        try {
        	int id = 0;
        	
        	Item itemExists = dao.findByIdProductAndIdClientNotPaid(item.getIdProduct(), item.getIdClient());
        	
        	if (itemExists.getId() == 0) id = dao.insert(item);  
        	else {
        		int newQuantity = itemExists.getQuantity() + item.getQuantity();
        		
        		item.setId(itemExists.getId());
        		item.setQuantity(newQuantity);
        		
        		dao.updateQuantityById(item);
        	}
        	
        	return id;
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
    
    public Cart listItemsInCartByIdClient(int idClient) throws Exception {
    	try {
    		Cart cart = dao.listItemsInCartByIdClient(idClient);
    		
    		ArrayList<Item> items = cart.getItems();
    		
    		int quantity = 0;
    		double totalItems = 0.0;
    		double frete = 0.0;
    		double total = 0.0;
    		double bankSlip = 0.0;
    		
    		for (Item item : items) {
				quantity += item.getQuantity();
				totalItems += item.getProduct().getPrice() * item.getQuantity();
				if (item.getProduct().getPrice() > 400) {
					frete += item.getProduct().getPrice() * 0.02;
				} else {
					frete += item.getProduct().getPrice() * 0.082;
				}
			}
			
			total = totalItems + frete;
			bankSlip = total - (total * 0.05);
			
			cart.setQuantity(quantity);
			cart.setTotalItems(totalItems);
			cart.setFrete(frete);
			cart.setTotal(total);
			cart.setBankSlip(bankSlip);
			
    		return cart;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public void setItemPaid(Item item) throws Exception {
    	try {
    		dao.setItemPaid(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
