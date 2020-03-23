package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.dao.UserDAO;

import java.util.ArrayList;

public class UserService {
    UserDAO dao;

    public UserService() {
        dao = new UserDAO();
    }

    public int create(User user) throws Exception {
        try {
        	return dao.insert(user);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(User user) throws Exception {
        try {
        	dao.update(user);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(User user) throws Exception {
        try {
        	dao.delete(user);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public User find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<User> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
