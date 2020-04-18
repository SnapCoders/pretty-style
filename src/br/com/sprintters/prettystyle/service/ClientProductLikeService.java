package br.com.sprintters.prettystyle.service;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.dao.ClientProductLikeDAO;
import br.com.sprintters.prettystyle.model.ClientProductLike;

public class ClientProductLikeService {
	ClientProductLikeDAO dao;

    public ClientProductLikeService() {
        dao = new ClientProductLikeDAO();
    }

    public int create(ClientProductLike clientProductLike) throws Exception {
    	try {
    		return dao.insert(clientProductLike);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(ClientProductLike clientProductLike) throws Exception {
    	try {
    		dao.update(clientProductLike);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(ClientProductLike clientProductLike) throws Exception {
        try {
        	dao.delete(clientProductLike);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ClientProductLike find(int idProduct, int idClient) throws Exception {
    	try {
    		return dao.find(idProduct, idClient);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public ArrayList<ClientProductLike> listProductLikeByIdClient(int idClient) throws Exception {
    	try {
    		return dao.listProductLikeByIdClient(idClient);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
