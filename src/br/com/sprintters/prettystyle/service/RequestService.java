package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.ItemRequestDAO;
import br.com.sprintters.prettystyle.dao.ProductPhotoDAO;
import br.com.sprintters.prettystyle.dao.RequestDAO;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.ItemRequest;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.Request;

public class RequestService {
    RequestDAO requestDAO;
    ProductPhotoDAO productPhotoDAO;
    ItemRequestDAO itemRequestDAO;

    public RequestService() {
        requestDAO = new RequestDAO();
        productPhotoDAO = new ProductPhotoDAO();
        itemRequestDAO = new ItemRequestDAO();
    }

    public int create(Request request) throws Exception {
        try {
        	return requestDAO.insert(request);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Request request) throws Exception {
        try {
        	requestDAO.update(request);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Request request) throws Exception {
        try {
        	requestDAO.delete(request);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Request find(int id) throws Exception {
    	try {
    		return requestDAO.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Request> list() throws Exception {
    	try {
    		return requestDAO.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<Request> listRequestsByIdClient(int idClient) throws Exception {
    	try {
    		ArrayList<Request> requests = requestDAO.listRequestsByIdClient(idClient);
    		
    		for (Request request : requests) {
    			for (Item item : request.getItems()) {
    				Product product = item.getProduct();
    				
    				ArrayList<ProductPhoto> photos = productPhotoDAO.findAllPhotosByIdProduct(product.getId());
    				
    				for (ProductPhoto photo : photos) photo.setUrl(photo.getUrl().replace("\\","/"));
    				
    				product.setPhotos(photos);
    			}
    		}
    		
    		return requests;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public void createItemRequest(ItemRequest itemRequest) throws Exception{
    	itemRequestDAO.insert(itemRequest);
    }

}
