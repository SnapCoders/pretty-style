package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.PhoneNumber;
import br.com.sprintters.prettystyle.dao.PhoneNumberDAO;

import java.util.ArrayList;

public class PhoneNumberService {
    PhoneNumberDAO dao;

    public PhoneNumberService() {
        dao = new PhoneNumberDAO();
    }

    public void create(PhoneNumber phoneNumber) {
        dao.create(phoneNumber);
    }

    public void update(PhoneNumber phoneNumber) {
        dao.update(phoneNumber);
    }

    public void delete(PhoneNumber phoneNumber) {
        dao.delete(phoneNumber);
    }

    public ArrayList<PhoneNumber> list(int id) {
        return dao.list(id);
    }

    public PhoneNumber find(int id) {
        return dao.find(id);
    }
}
