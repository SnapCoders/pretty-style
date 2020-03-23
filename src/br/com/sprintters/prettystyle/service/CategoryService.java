package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.dao.CategoryDAO;

import java.util.ArrayList;

public class CategoryService {
    CategoryDAO dao;

    public CategoryService() {
        dao = new CategoryDAO();
    }

    public int create(Category category) throws Exception {
    	try {
    		return dao.insert(category);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Category category) throws Exception {
    	try {
    		dao.update(category);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Category category) throws Exception {
        try {
        	dao.delete(category);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Category find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Category> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
