package br.com.sprintters.prettystyle.service;

import java.util.Base64;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.dao.PhoneNumberDAO;
import br.com.sprintters.prettystyle.dao.UserDAO;

public class UserService {
    UserDAO userDAO;
    PhoneNumberDAO phoneNumberDAO;

    public UserService() {
        userDAO = new UserDAO();
        phoneNumberDAO = new PhoneNumberDAO();
    }

    public int create(User user) throws Exception {
        try {
        	int idUser = 0;
        	
        	// 1 - Criptografar senha
        	String passwordHash = cripto(user.getPassword());
        	
        	user.setPassword(null);
        	user.setPasswordHash(passwordHash);
        	
        	// 2 - Cadastrar o usuário
        	idUser = userDAO.insert(user);
        	
        	// 3 - Cadastrar os telefones
        	for (PhoneNumber to : user.getPhoneNumbers()) {
        		to.setIdUser(idUser);
        		phoneNumberDAO.insert(to);
        	}
        	
        	return idUser;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(User user) throws Exception {
        try {
        	userDAO.update(user);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(User user) throws Exception {
        try {
        	userDAO.delete(user);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public User find(int id) throws Exception {
    	try {
    		return userDAO.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<User> list() throws Exception {
    	try {
    		return userDAO.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
    
    public User login(String usernameOrEmail, String password) {
    	User user = null;
    	
    	try {
    		if (usernameOrEmail.contains("@")) user = userDAO.findByEmail(usernameOrEmail);
    		else user = userDAO.findByUsername(usernameOrEmail);
    		
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
