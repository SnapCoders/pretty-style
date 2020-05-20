package br.com.sprintters.prettystyle.service;

import java.util.Base64;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.model.Client;
import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.model.Provider;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.utils.Crypt;
import br.com.sprintters.prettystyle.dao.AddressDAO;
import br.com.sprintters.prettystyle.dao.ClientDAO;
import br.com.sprintters.prettystyle.dao.PhoneNumberDAO;
import br.com.sprintters.prettystyle.dao.ProviderDAO;
import br.com.sprintters.prettystyle.dao.UserDAO;

public class UserService {
    UserDAO userDAO;
    ClientDAO clientDAO;
    ProviderDAO providerDAO;
    PhoneNumberDAO phoneNumberDAO;
    AddressDAO addressDAO;

    public UserService() {
        userDAO = new UserDAO();
        clientDAO = new ClientDAO();
        providerDAO = new ProviderDAO();
        phoneNumberDAO = new PhoneNumberDAO();
        addressDAO = new AddressDAO();
    }

    public int create(User user) throws Exception {
        try {
        	int idUser = 0;
        	
        	// 1 - Criptografar senha
        	String passwordHash = Crypt.criptoSHAHex(user.getPassword());
        	
        	user.setPassword(null);
        	user.setPasswordHash(passwordHash);
        	
        	// 2 - Checar se já existe um usuário com esta e-mail cadastrado
        	User userExists = userDAO.findByEmail(user.getEmail());
        	
        	if (userExists.getId() == 0) {
        		// 2 - Cadastrar o usuário
            	idUser = userDAO.insert(user);
            	
            	// 3 - Cadastrar cliente ou provider
            	if (user.isProvider()) {
            		user.getProvider().setIdUser(idUser);
            		providerDAO.create(user.getProvider());
            	} else {
            		user.getClient().setIdUser(idUser);
            		clientDAO.insert(user.getClient());
            	}
            	
            	// 4 - Cadastrar os telefones
            	for (PhoneNumber to : user.getPhoneNumbers()) {
            		to.setIdUser(idUser);
            		phoneNumberDAO.insert(to);
            	}
        	} else {
        		throw new Exception("Já existe um usuário com este e-mail cadastrado!");
        	}
        	
        	return idUser;
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(User user) throws Exception {
        try {
        	// 1 - Atualizar o usuário
        	userDAO.update(user);
        	
        	// 2 - Atualizar o provider ou client
        	if (user.isProvider()) {
        		Provider providerExists = providerDAO.findByIdUser(user.getId());
        		user.getProvider().setId(providerExists.getId());
        		providerDAO.update(user.getProvider());
        	} else {
        		Client clientExists = clientDAO.findByIdUser(user.getId());
        		user.getClient().setId(clientExists.getId());
        		clientDAO.update(user.getClient());
        	}
        	
        	ArrayList<PhoneNumber> phones = phoneNumberDAO.findByIdUser(user.getId());
        	
        	int c = 0;
        	
        	// 3 - Atualizar o telefones
        	for (PhoneNumber pn : user.getPhoneNumbers()) {
        		pn.setId(phones.get(c).getId());
        		phoneNumberDAO.update(pn);
        		c++;
        	}
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
    		User user = new User();
    		user = userDAO.find(id);
    		
    		Client client = clientDAO.findByIdUser(id);
			Provider provider = providerDAO.findByIdUser(id);
			
			if (client != null) {
				user.setClient(client);
			} else {
				user.setProvider(provider);
			}
			
			ArrayList<PhoneNumber> phones = phoneNumberDAO.findByIdUser(user.getId());
			
			user.setPhoneNumbers(phones);
			
			ArrayList<Address> addresses = new ArrayList<Address>();
			
			addresses.add(addressDAO.findByIdUser(id));
			
			user.setAddresses(addresses);
			
    		return user;
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
    		
    		//if (password.equals(decripto(user.getPasswordHash()))) {
    		if (Crypt.criptoSHAHex(password).equals(user.getPasswordHash())) {
    			user.setSigned(true);
    			
    			Client client = clientDAO.findByIdUser(user.getId());
    			Provider provider = providerDAO.findByIdUser(user.getId());
    			
    			if (client != null) {
    				user.setClient(client);
    			} else {
    				user.setProvider(provider);
    			}
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
