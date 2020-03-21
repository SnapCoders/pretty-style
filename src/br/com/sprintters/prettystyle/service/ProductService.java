package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.DAO.ProductDAO;

import java.util.ArrayList;

public class ProductService{
    ProductDAO dao;

    public ProductService() {
        dao = new ProductDAO();
    }

    public void create(Product product) {
        dao.create(product);
    }

    public void update(Product product) {
        dao.update(product);
    }

    public void delete(Product product) {
        dao.delete(product);
    }

    public ArrayList<Product> list(int id) {
        return dao.list(id);
    }

    public Product find(int id) {
        return dao.find(id);
    }
}
