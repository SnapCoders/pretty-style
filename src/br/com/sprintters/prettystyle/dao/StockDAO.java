package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.Stock;

public class StockDAO {

	public int insert(Stock to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO stock (quantity, created_at) values (?, now())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getQuantity());
			
			stm.execute();
			
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {				
					id = rs.getInt(1);
					to.setId(id);
				}
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return id;
	}
	
	public Stock find(int id) throws Exception {
		Stock to = new Stock();
		String sqlSelect = "SELECT * FROM stock WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setQuantity(rs.getInt("quantity"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
	
	public void update(Stock to) throws Exception {
		String sqlUpdate = "UPDATE stock SET quantity = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getQuantity());
			stm.setInt(2, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
