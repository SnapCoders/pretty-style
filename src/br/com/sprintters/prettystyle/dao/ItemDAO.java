package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.Item;

import java.sql.PreparedStatement;

public class ItemDAO {
	public int insert(Item to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO item (quantity, id_product, created_at) values (?, ?, now())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getQuantity());
			stm.setInt(2, to.getIdProduct());
			stm.execute();
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {				
					id = rs.getInt(1);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return id;
	}
	
	public void update(Item to) throws Exception {
		String sqlUpdate = "UPDATE item SET quantity = ?, id_product = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getQuantity());
			stm.setInt(2, to.getIdProduct());
			stm.setInt(3, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Item to) throws Exception {
		String sqlDelete = "UPDATE item SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Item find(int id) throws Exception {
		Item to = new Item();
		String sqlSelect = "SELECT * FROM item WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setQuantity(rs.getInt("quantity"));
					to.setIdProduct(rs.getInt("id_product"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
	
	public ArrayList<Item> list() throws Exception  {
		ArrayList<Item> items = new ArrayList<Item>();
		String sqlSelect = "SELECT * FROM item WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Item to = new Item(
						rs.getInt("id"),
						rs.getInt("quantity"),
						rs.getInt("id_product"),
						rs.getInt("id_request"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					items.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return items;
	}
}
