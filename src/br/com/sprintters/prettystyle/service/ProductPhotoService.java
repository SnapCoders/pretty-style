package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.dao.ProductPhotoDAO;

public class ProductPhotoService {
    ProductPhotoDAO dao;

    public ProductPhotoService() {
        dao = new ProductPhotoDAO();
    }

    public void create(ProductPhoto productPhoto) {
        dao.create(productPhoto);
    }

    public void update(ProductPhoto productPhoto) {
        dao.update(productPhoto);
    }

    public void delete(ProductPhoto productPhoto) {
        dao.delete(productPhoto);
    }

    public ArrayList<ProductPhoto> list(int id) {
        return dao.list(id);
    }

    public ProductPhoto find(int id) {
        return dao.find(id);
    }
}
