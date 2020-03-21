package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.DAO.ItemDAO;

import java.util.ArrayList;

public class ItemService {
    ItemDAO dao;

    public ItemService() {
        dao = new ItemDAO();
    }

    public void create(Item item) {
        dao.create(item);
    }

    public void update(Item item) {
        dao.update(item);
    }

    public void delete(Item item) {
        dao.delete(item);
    }

    public ArrayList<Item> list(int id) {
        return dao.list(id);
    }

    public Item find(int id) {
        return dao.find(id);
    }
}
