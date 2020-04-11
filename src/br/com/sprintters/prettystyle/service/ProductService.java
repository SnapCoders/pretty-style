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
    
    public ArrayList<Product> listMore() {
    	ArrayList<Product> lista = new ArrayList<Product>();

    	lista.add(new Product("Teste", "Teste description", 500.00, 2));
		lista.add(new Product("Teste2", "Teste2 description", 550.00, 3));
		lista.add(new Product("Teste3", "Teste3 description", 920.00, 4));
		lista.add(new Product("Teste 4", "Teste 4", 159.00, 4));
		
		return lista;
    }
}
