package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.ProductDAO;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.Product;

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
    
    public ArrayList<Product> listByIdProvider(int idProvider) throws Exception {
    	try {
    		return dao.listByIdProvider(idProvider);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public int createFavorite(ClientProductLike cpl) throws Exception {
    	try {
    		return dao.createFavorite(cpl);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<ClientProductLike> listFavoritesByIdClient(int idClient) throws Exception {
    	try {
    		return dao.listFavoritesByIdClient(idClient);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ClientProductLike listFavoriteByIdClientAndIdProduct(int idClient, int idProduct) throws Exception {
    	try {
    		return dao.listFavoriteByIdClientAndIdProduct(idClient, idProduct);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public void deleteFavoriteById(int id) throws Exception {
    	try {
    		dao.deleteFavoriteById(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
