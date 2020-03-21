package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;
import br.com.sprintters.prettystyle.model.ProductCategory;
import br.com.sprintters.prettystyle.dao.ProductCategoryDAO;


public class ProductCategoryService {
    ProductCategoryDAO dao;

    public ProductCategoryService() {
        dao = new ProductCategoryDAO();
    }

    public void create(ProductCategory productCategory) {
        dao.create(productCategory);
    }

    public void update(ProductCategory productCategory) {
        dao.update(productCategory);
    }

    public void delete(ProductCategory productCategory) {
        dao.delete(productCategory);
    }

    public ArrayList<ProductCategory> list(int id) {
        return dao.list(id);
    }

    public ProductCategory find(int id) {
        return dao.find(id);
    }
}
