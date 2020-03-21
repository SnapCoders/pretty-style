package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.dao.MarkDAO;

import java.util.ArrayList;

public class MarkService {
    MarkDAO dao;

    public MarkService() {
        dao = new MarkDAO();
    }

    public void create(Mark mark) {
        dao.create(mark);
    }

    public void update(Mark mark) {
        dao.update(mark);
    }

    public void delete(Mark mark) {
        dao.delete(mark);
    }

    public ArrayList<Mark> list(int id) {
        return dao.list(id);
    }

    public Mark find(int id) {
        return dao.find(id);
    }
}
