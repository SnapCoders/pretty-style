package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.CategoryDAO;
import br.com.sprintters.prettystyle.dao.ProductCategoryDAO;
import br.com.sprintters.prettystyle.dao.ProductDAO;
import br.com.sprintters.prettystyle.dao.StockDAO;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductCategory;
import br.com.sprintters.prettystyle.model.Stock;

public class ProductService{
    ProductDAO productDAO;
    ProductCategoryDAO productCategoryDAO;
    CategoryDAO categoryDAO;
    StockDAO stockDAO;

    public ProductService() {
        productDAO = new ProductDAO();
        productCategoryDAO = new ProductCategoryDAO();
        categoryDAO = new CategoryDAO();
        stockDAO = new StockDAO();
        
    }

    public int create(Product product, Stock stock) throws Exception {
        try {
        	int idStock = stockDAO.insert(stock);
        	product.setIdStock(idStock);
        	int idProduct = productDAO.insert(product);
        	
        	for (int i = 0; i < product.getCategories().size(); i++) {
        		ProductCategory pc = new ProductCategory(idProduct, product.getCategories().get(i).getId());
        		productCategoryDAO.insert(pc);
        	}
        	return idProduct;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }


    public void update(Product product) throws Exception {
        try {
        	productDAO.update(product);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Product product) throws Exception {
        try {
        	productDAO.delete(product);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Product find(int id) throws Exception {
    	try {
    		return productDAO.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Product> list() throws Exception {
    	try {
    		return productDAO.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Product> listBestSellers() throws Exception {
    	try {
    		ArrayList<Product> products = productDAO.listBestSellers();
    		
     		return products;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Product> listByIdProvider(int idProvider) throws Exception {
    	try {
    		return productDAO.listByIdProvider(idProvider);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public int createFavorite(ClientProductLike cpl) throws Exception {
    	try {
    		return productDAO.createFavorite(cpl);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<ClientProductLike> listFavoritesByIdUser(int idUser) throws Exception {
    	try {
    		return productDAO.listFavoritesByIdUser(idUser);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ClientProductLike listFavoriteByIdUserAndIdProduct(int idUser, int idProduct) throws Exception {
    	try {
    		return productDAO.listFavoriteByIdUserAndIdProduct(idUser, idProduct);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public void deleteFavoriteById(int id) throws Exception {
    	try {
    		productDAO.deleteFavoriteById(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
	public ArrayList<Category> listByIdProduct(int id) throws Exception{
    	ArrayList<ProductCategory> listaID = productCategoryDAO.listByIdProduct(id);
    	ArrayList<String> ids = new ArrayList<String>();
    	
    	for(ProductCategory pc: listaID) {
    		ids.add(""+pc.getIdCategory());
    	}
    	
    	String idsConcatenado = String.join("','", ids);
    	
    	ArrayList<Category> lista = categoryDAO.listByIdCategory(idsConcatenado);
    
    	try {
    		return lista;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public Product findProductAndCategory(int id) throws Exception {
    	Product to;
    	try {
    		to = productDAO.findProductAndCategory(id);
    		if(to.getId() == 0) {
    			return productDAO.find(id);
    		}
    		return to;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Product> findByName(String filter) throws Exception {
    	try {
    		return productDAO.findByName(filter);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Product> findByCategory(String filter) throws Exception {
    	try {
    		return productDAO.findByCategory(filter);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    //Metodos da classe Stock
    
    public void updateQuantity(int idProduct, int quantity) throws Exception {
    	try {
    		Product product = productDAO.find(idProduct);
    		Stock stock = stockDAO.find(product.getIdStock());
    		int newQuantity = stock.getQuantity()+ quantity;
    		stock.setQuantity(newQuantity);
    		
    		stockDAO.update(stock);
    		
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
