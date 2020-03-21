package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.dao.UserDAO;

import java.util.ArrayList;

public class UserService {
    UserDAO dao;

    public UserService() {
        dao = new UserDAO();
    }

    public void create(User user) {
        dao.create(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public void delete(User user) {
        dao.delete(user);
    }

    public ArrayList<User> list(int id) {
        return dao.list(id);
    }

    public User find(int id) {
        return dao.find(id);
    }
}
