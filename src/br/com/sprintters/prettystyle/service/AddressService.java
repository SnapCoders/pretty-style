package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Address;
import br.com.sprintters.prettystyle.DAO.AddressDAO;

import java.util.ArrayList;

public class AddressService {
    AddressDAO dao;

    public AddressService() {
        dao = new AddressDAO();
    }

    public void create(Address address) {
        dao.create(address);
    }

    public void update(Address address) {
        dao.update(address);
    }

    public void delete(Address address) {
        dao.delete(address);
    }

    public ArrayList<Address> list(int id) {
        return dao.list(id);
    }

    public Address find(int id) {
        return dao.find(id);
    }
}
