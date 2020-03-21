package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.DAO.RequestDAO;

import java.util.ArrayList;

public class RequestService {
    RequestDAO dao;

    public RequestService() {
        dao = new RequestDAO();
    }

    public void create(Request request) {
        dao.create(request);
    }

    public void update(Request request) {
        dao.update(request);
    }

    public void delete(Request request) {
        dao.delete(request);
    }

    public ArrayList<Request> list(int id) {
        return dao.list(id);
    }

    public Request find(int id) {
        return dao.find(id);
    }
}
