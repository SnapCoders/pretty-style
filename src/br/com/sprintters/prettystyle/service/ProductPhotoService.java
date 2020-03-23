package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.dao.ProductPhotoDAO;

public class ProductPhotoService {
    ProductPhotoDAO dao;

    public ProductPhotoService() {
        dao = new ProductPhotoDAO();
    }

    public int create(ProductPhoto productPhoto) throws Exception {
        try {
        	return dao.insert(productPhoto);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(ProductPhoto productPhoto) throws Exception {
        try {
        	dao.update(productPhoto);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(ProductPhoto productPhoto) throws Exception {
        try {
        	dao.delete(productPhoto);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ProductPhoto find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<ProductPhoto> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
