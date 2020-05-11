package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.ItemRequest;

public class ItemRequestDAO {
	
	public int insert(ItemRequest to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO item_request (id_item, id_request) values (?, ?)";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getIdItem());
			stm.setInt(2, to.getIdRequest());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return id;
	}
}
