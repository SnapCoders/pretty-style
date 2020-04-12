package br.com.sprintters.prettystyle.service;

import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.dao.MarkDAO;

import java.util.ArrayList;

public class MarkService {
    MarkDAO dao;

    public MarkService() {
        dao = new MarkDAO();
    }

    public int create(Mark mark) throws Exception {
        try {
        	return dao.insert(mark);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void update(Mark mark) throws Exception {
        try {
        	dao.update(mark);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public void delete(Mark mark) throws Exception {
        try {
        	dao.delete(mark);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public Mark find(int id) throws Exception {
    	try {
    		return dao.find(id);
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }

    public ArrayList<Mark> list() throws Exception {
    	try {
    		return dao.list();
    	} catch (Exception e) {
    		throw new Exception(e.getMessage());
    	}
    }
}
