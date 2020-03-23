package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;
import br.com.sprintters.prettystyle.model.ProductCategory;
import br.com.sprintters.prettystyle.dao.ProductCategoryDAO;


public class ProductCategoryService {
    ProductCategoryDAO dao;

    public ProductCategoryService() {
        dao = new ProductCategoryDAO();
    }

    public void create(ProductCategory productCategory) throws Exception {
        try {
        	dao.insert(productCategory);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(ProductCategory productCategory) throws Exception {
        try {
        	dao.delete(productCategory);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ProductCategory find(int idProduct, int idCategory) throws Exception {
    	try {
    		return dao.find(idProduct, idCategory);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<ProductCategory> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
