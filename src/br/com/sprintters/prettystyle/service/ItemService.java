package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.ItemDAO;
import br.com.sprintters.prettystyle.dao.ProductDAO;
import br.com.sprintters.prettystyle.dao.StockDAO;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.Stock;
import br.com.sprintters.prettystyle.model.virtual.Cart;

public class ItemService {
    ItemDAO itemDAO;
    StockDAO stockDAO;
    ProductDAO productDAO;

    public ItemService() {
        itemDAO = new ItemDAO();
        stockDAO = new StockDAO();
        productDAO = new ProductDAO();
    }

    public int create(Item item) throws Exception {
        try {
        	int id = 0;
        	
        	Item itemExists = itemDAO.findByIdProductAndIdClientNotPaid(item.getIdProduct(), item.getIdClient());
        	
        	if (itemExists.getId() == 0) id = itemDAO.insert(item);  
        	else {
        		int newQuantity = itemExists.getQuantity() + item.getQuantity();
        		
        		item.setId(itemExists.getId());
        		item.setQuantity(newQuantity);
        		
        		itemDAO.updateQuantityById(item);
        	}
        	
        	return id;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Item item) throws Exception {
        try {
        	itemDAO.update(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Item item) throws Exception {
        try {
        	itemDAO.delete(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Item find(int id) throws Exception {
    	try {
    		return itemDAO.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Item> list() throws Exception {
    	try {
    		return itemDAO.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Cart listItemsInCartByIdClient(int idClient) throws Exception {
    	try {
    		Cart cart = itemDAO.listItemsInCartByIdClient(idClient);
    		
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
    		 itemDAO.setItemPaid(item);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
        
    public void updateQuantity(Item item) throws Exception {
    	try {
    		Product product = productDAO.find(item.getProduct().getId());
    		Stock stock = stockDAO.find(product.getIdStock());
    		int newQuantity = stock.getQuantity()- item.getQuantity();
    		stock.setQuantity(newQuantity);
    		
    		stockDAO.update(stock);
    		
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public void updateQuantityInItemFromCart(int itemId, int productId, int newQuantity) throws Exception {
    	try {
    		itemDAO.updateQuantityInItemFromCart(itemId, productId, newQuantity);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
