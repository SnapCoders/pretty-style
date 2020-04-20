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
    
    public ArrayList<Product> listBestSellers() throws Exception {
    	try {
    		return dao.listBestSellers();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Product> listMore() {
    	ArrayList<Product> lista = new ArrayList<Product>();

    	lista.add(new Product("Teste 1", "Produto teste 1", 500.00, 2));
		lista.add(new Product("Teste 2", "Produto teste 2", 550.00, 3));
		lista.add(new Product("Teste 3", "Produto teste 3", 920.00, 4));
		lista.add(new Product("Teste 4", "Produto teste 4", 159.00, 4));
		lista.add(new Product("Teste 5", "Produto teste 5", 859.00, 4));
		lista.add(new Product("Teste 6", "Produto teste 6", 959.00, 4));
		lista.add(new Product("Teste 7", "Produto teste 7", 120.00, 4));
		lista.add(new Product("Teste 8", "Produto teste 8", 500.00, 4));
		
		return lista;
    }
    
    public ArrayList<Product> listByIdProvider(int idProvider) throws Exception {
    	try {
    		return dao.listByIdProvider(idProvider);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
