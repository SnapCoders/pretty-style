package br.com.sprintters.prettystyle.service;

import java.util.Base64;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.dao.UserDAO;

public class UserService {
    UserDAO dao;

    public UserService() {
        dao = new UserDAO();
    }

    public int create(User user) throws Exception {
        try {
        	String passwordHash = cripto(user.getPassword());
        	
        	user.setPassword(null);
        	user.setPasswordHash(passwordHash);
        	
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
    
    public User login(String usernameOrEmail, String password) {
    	User user = null;
    	
    	try {
    		if (usernameOrEmail.contains("@")) user = dao.findByEmail(usernameOrEmail);
    		else user = dao.findByUsername(usernameOrEmail);
    		
    		String passwordDecripted = decripto(user.getPasswordHash());
    		
    		if (password.equals(passwordDecripted)) {
    			user.setSigned(true);
    		}
    	} catch (Exception e) {
    		user.setSigned(false);
    	}
    	
    	return user;
    }
    
    public static String cripto(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
    
    public static String decripto(String passwordHash) {
        return new String(Base64.getDecoder().decode(passwordHash));
    }
}
