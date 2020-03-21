package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.DAO.CategoryDAO;

import java.util.ArrayList;

public class CategoryService {
    CategoryDAO dao;

    public CategoryService() {
        dao = new CategoryDAO();
    }

    public void create(Category category) {
        dao.create(category);
    }

    public void update(Category category) {
        dao.update(category);
    }

    public void delete(Category category) {
        dao.delete(category);
    }

    public ArrayList<Category> list(int id) {
        return dao.list(id);
    }

    public Category find(int id) {
        return dao.find(id);
    }
}

