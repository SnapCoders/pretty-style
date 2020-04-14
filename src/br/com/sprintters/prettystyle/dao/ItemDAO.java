package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.Request;

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
	public ArrayList<Item> listAllPlusItem(int id) throws Exception {
		ArrayList<Item> item = new ArrayList<Item>();
		String sqlSelect = "SELECT quantity, name, description, price FROM "
				+ "item INNER JOIN product on product.id = id_product  WHERE id_product = ?;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Item to = new Item(
						rs.getInt("quantity"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getInt("price")
					);
					item.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return item;
	}
	public ArrayList<Item> listRequestsByIdClient(int idClient) throws Exception  {
		ArrayList<Item> reqs = new ArrayList<Item>();
		String sqlSelect = "SELECT\r\n" + 
				"	p.name\r\n" + 
				"    , p.description\r\n" + 
				"    , p.price\r\n" + 
				"    , p.id_mark\r\n" + 
				"    , r.id_client\r\n" + 
				"FROM\r\n" + 
				"	product p\r\n" + 
				"    INNER JOIN item i on p.id = i.id_product\r\n" + 
				"    INNER JOIN request r on i.id_request = r.id\r\n" + 
				"WHERE r.id_client = ?;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idClient);
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Item to = new Item(
						rs.getInt("quantity"),	
						rs.getString("name"),	
						rs.getString("description"),
						rs.getInt("price")
					);
					reqs.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return reqs;
	}
}
