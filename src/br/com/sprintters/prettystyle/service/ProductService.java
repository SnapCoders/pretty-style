package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.CategoryDAO;
import br.com.sprintters.prettystyle.dao.ProductCategoryDAO;
import br.com.sprintters.prettystyle.dao.ProductDAO;
import br.com.sprintters.prettystyle.dao.ProductPhotoDAO;
import br.com.sprintters.prettystyle.dao.StockDAO;
import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductCategory;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.Stock;

public class ProductService{
    ProductDAO productDAO;
    ProductPhotoDAO productPhotoDAO;
    ProductCategoryDAO productCategoryDAO;
    CategoryDAO categoryDAO;
    StockDAO stockDAO;

    public ProductService() {
        productDAO = new ProductDAO();
        productPhotoDAO = new ProductPhotoDAO();
        productCategoryDAO = new ProductCategoryDAO();
        categoryDAO = new CategoryDAO();
        stockDAO = new StockDAO();
    }

    public int create(Product product) throws Exception {
        try {
        	product.setIdStock(stockDAO.insert(product.getStock()));
        	
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
    		Product product = productDAO.find(id);
    		
    		ArrayList<ProductPhoto> photos = productPhotoDAO.findAllPhotosByIdProduct(product.getId());
    		
    		product.setPhotos(photos);
    		
    		return product;
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
    		ArrayList<Product> products = productDAO.listByIdProvider(idProvider);
    		
    		for (Product product : products) {
    			ArrayList<ProductPhoto> photos = productPhotoDAO.findAllPhotosByIdProduct(product.getId());
    			product.setPhotos(photos);
    		}
    		
    		return products;
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
    		ArrayList<ClientProductLike> likes = productDAO.listFavoritesByIdUser(idUser);
    		for (ClientProductLike like : likes) {
    			Product product = like.getProduct();
    			ArrayList<ProductPhoto> photos = productPhotoDAO.findAllPhotosByIdProduct(product.getId());
    			product.setPhotos(photos);
    		}
    		return likes;
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
    		ArrayList<Product> products = productDAO.findByName(filter);
    		
    		for (Product product : products) {
    			ArrayList<ProductPhoto> photos = productPhotoDAO.findAllPhotosByIdProduct(product.getId());
    			
    			product.setPhotos(photos);
    		}
    		
    		return products;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    
    public ArrayList<Product> findByCategory(String filter) throws Exception {
    	try {
    		ArrayList<Product> products = productDAO.findByCategory(filter);
    		
    		for (Product product : products) {
    			ArrayList<ProductPhoto> photos = productPhotoDAO.findAllPhotosByIdProduct(product.getId());
    			
    			product.setPhotos(photos);
    		}
    		
    		return products;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
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
