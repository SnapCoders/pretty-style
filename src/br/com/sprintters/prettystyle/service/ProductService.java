package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.dao.ProductDAO;

import java.util.ArrayList;

public class ProductService{
    ProductDAO dao;

    public ProductService() {
        dao = new ProductDAO();
    }

    public int create(Product product) throws Exception {
        try {
        	return dao.insert(product);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Product product) throws Exception {
        try {
        	dao.update(product);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Product product) throws Exception {
        try {
        	dao.delete(product);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Product find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Product> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
